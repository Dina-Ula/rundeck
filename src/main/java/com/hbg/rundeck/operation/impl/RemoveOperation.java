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
public class RemoveOperation implements Operation {

	private static final String GET = "get";
	private static final String SIZE = "size";
	private static final String REMOVE = "remove";
	private static final String SELECT_PREFIX = "select-";
	private static final String REGEX_ELEMENT_PREFIX = "regex-element-";
	private static final String REMOVE_ELEMENT_PREFIX = "remove-element-";

	@Autowired
	private JobService service;

	@Autowired
	private OperationHelper operationHelper;

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

		Map<String, String> removeElement = new HashMap<>();
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(REMOVE_ELEMENT_PREFIX) && StringUtils.isNotBlank(value)) {
				removeElement.put(key.replace(REMOVE_ELEMENT_PREFIX, StringUtils.EMPTY), value);
				break;
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

		if (CollectionUtils.isEmpty(removeElement)) {
			return null;
		}

		Joblist joblist = service.getProjectById(projectId).getBody();

		List<Job> jobs = joblist.getJob();
		for (Job job : jobs) {
			try {

				if (operationHelper.ignoreJob(job, regexElementId, regex)) {
					System.out.println("Ignoring: Job Id: " + job.getId() + "Job Name: " + job.getName());
					continue;
				}

				Object elementToModify = job;
				if (!CollectionUtils.isEmpty(selectedElements)) {

					elementToModify = operationHelper.getElement(job, selectedElements);
					if (elementToModify == null) {
						continue;
					}
				}

				removeElement(elementToModify, removeElement);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {

				System.out.println("The element failed to remove for the job, " + job.getName());
				e.printStackTrace();
				return null;
			}
		}

		return joblist;
	}

	private void removeElement(Object element, Map<String, String> removeElement) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		if (!element.getClass().getName().equals(ArrayList.class.getName())) {
			operationHelper.setElement(element, removeElement);
			return;
		}

		int size = (int) element.getClass().getMethod(SIZE).invoke(element);

		for (int i = 0; i < size; i++) {
			Object object = element.getClass().getMethod(GET, Integer.TYPE).invoke(element, i);

			for (Map.Entry<String, String> entry : removeElement.entrySet()) {

				String key = entry.getKey();
				String value = entry.getValue();
				String objectValue = (String) object.getClass().getMethod(GET + StringUtils.capitalize(key))
						.invoke(object);

				if (value.equals(objectValue)) {
					element.getClass().getMethod(REMOVE, Integer.TYPE).invoke(element, i);
					size--;
				}
			}
		}
	}
}
