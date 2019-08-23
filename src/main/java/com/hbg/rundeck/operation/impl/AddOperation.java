/**
 * 
 */
package com.hbg.rundeck.operation.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbg.rundeck.config.RundeckConfiguration;
import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.job.Joblist.Job;
import com.hbg.rundeck.operation.Operation;
import com.hbg.rundeck.operation.helper.OperationHelper;
import com.hbg.rundeck.service.JobService;

/**
 * @author dinulaga
 *
 */
@Component
public class AddOperation implements Operation {

	private static final String GET = "get";
	private static final String ADD = "add";
	private static final String SIZE = "size";
	private static final String SELECT_PREFIX = "select-";
	private static final String ADD_ELEMENT_PREFIX = "add-element-";
	private static final String REGEX_ELEMENT_PREFIX = "regex-element-";

	@Autowired
	private JobService service;

	@Autowired
	private OperationHelper operationHelper;

	@Autowired
	private RundeckConfiguration rundeckConfiguration;

	@Override
	public Joblist process(String projectId, final Map<String, String> requestBody) {

		List<String> selectedElements = new ArrayList<>();
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(SELECT_PREFIX) && StringUtils.isNotBlank(value)) {
				selectedElements.add(value);
			}
		}

		Map<String, String> addElements = new HashMap<>();
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(ADD_ELEMENT_PREFIX) && StringUtils.isNotBlank(value)) {
				addElements.put(key.replace(ADD_ELEMENT_PREFIX, StringUtils.EMPTY), value);
			}
		}

		String regexElementId = StringUtils.EMPTY;
		String regex = StringUtils.EMPTY;
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(REGEX_ELEMENT_PREFIX) && StringUtils.isNotBlank(value)) {
				regexElementId = key.replace(REGEX_ELEMENT_PREFIX, StringUtils.EMPTY);
				regex = value;
			}
		}

		if (CollectionUtils.isEmpty(addElements)) {
			return null;
		}

		Joblist joblist = service.getProjectById(projectId).getBody();

		List<Job> jobs = joblist.getJob();
		for (Job job : jobs) {
			try {
				String elementValue = operationHelper.getElementValueAsString(job, regexElementId);

				boolean matches = elementValue.matches(regex);

				if (matches) {
					System.out.println("Ignoring: Job Id: " + job.getId() + "Job Name: " + job.getName());
					continue;
				}

				Object elementToModify = job;
				if (!CollectionUtils.isEmpty(selectedElements)) {
					elementToModify = operationHelper.getElement(job, selectedElements);
				}

				System.out.println("Adding a new element to the job, " + job.getId());
				addElement(elementToModify, addElements);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException | InstantiationException e) {
				System.out.println("The element failed to add for the job, " + job.getName());
				e.printStackTrace();
				return null;
			}
		}

		return joblist;
	}

	private void addElement(Object element, Map<String, String> addElements)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException, InstantiationException {

		if (!element.getClass().getName().equals(ArrayList.class.getName())) {
			operationHelper.setElement(element, addElements);
			return;
		}

		if (isElementExisting(element, addElements)) {
			System.out.println("Element to add is already available, " + addElements);
			return;
		}

		Object newElement = element.getClass().getMethod(GET, Integer.TYPE).invoke(element, 0).getClass()
				.getConstructor().newInstance();
		operationHelper.setElement(newElement, addElements);
		element.getClass().getMethod(ADD, Object.class).invoke(element, newElement);
	}

	private boolean isElementExisting(Object element, Map<String, String> addElements) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		boolean isElementExisting = Boolean.FALSE;

		int size = (int) element.getClass().getMethod(SIZE).invoke(element);

		for (int i = 0; i < size; i++) {

			Object object = element.getClass().getMethod(GET, Integer.TYPE).invoke(element, i);

			// Check if the element to add already exists.
			List<String> entries = rundeckConfiguration.getElementTypeList();
			for (String entry : entries) {

				String fullClassName = object.getClass().getName();
				String className = fullClassName.substring(fullClassName.lastIndexOf("$") + 1).toLowerCase();
				if (className.equals(entry)) {

					Map<String, List<String>> elementsToIdentify = rundeckConfiguration.getElementsToIdentify();

					List<String> identifiers = elementsToIdentify.get(className);
					for (String identifier : identifiers) {

						String objectValue = (String) object.getClass()
								.getMethod(GET + StringUtils.capitalize(identifier)).invoke(object);

						if (addElements.get(identifier).equalsIgnoreCase(objectValue)) {
							isElementExisting = Boolean.TRUE;
						}

						break;
					}
				}
			}
		}

		return isElementExisting;
	}
}
