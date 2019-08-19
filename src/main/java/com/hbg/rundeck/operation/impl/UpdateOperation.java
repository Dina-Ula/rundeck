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
public class UpdateOperation implements Operation {

	private static final String GET = "get";
	private static final String SIZE = "size";
	private static final String SELECT_PREFIX = "select-";
	private static final String UPDATE_ID_PREFIX = "update-id-";
	private static final String UPDATE_TARGET_PREFIX = "update-target-";

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

		Map<String, String> modifyId = new HashMap<>();
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(UPDATE_ID_PREFIX) && StringUtils.isNotBlank(value)) {
				modifyId.put(key.replace(UPDATE_ID_PREFIX, StringUtils.EMPTY), value);
			}
		}

		Map<String, String> modifyTarget = new HashMap<>();
		for (Map.Entry<String, String> entry : requestBody.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();
			if (key.contains(UPDATE_TARGET_PREFIX)) {
				modifyTarget.put(key.replace(UPDATE_TARGET_PREFIX, StringUtils.EMPTY), value);
			}
		}

		if (CollectionUtils.isEmpty(modifyId) || CollectionUtils.isEmpty(modifyTarget)) {
			return null;
		}

		Joblist joblist = service.getProjectById(projectId).getBody();

		List<Job> jobs = joblist.getJob();
		for (Job job : jobs) {

			try {
				
				Object element = job;
				if (!CollectionUtils.isEmpty(selectedElements)) {
					element = operationHelper.getElement(job, selectedElements);
				}

				updateElement(element, modifyId, modifyTarget);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {

				System.out.println("The element failed to update for the job, " + job.getName());
				e.printStackTrace();
				return null;
			}
		}

		return joblist;

	}

	private void updateElement(Object element, Map<String, String> modifyId, Map<String, String> modifyTarget)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
			SecurityException {

		if (!element.getClass().getName().equals(ArrayList.class.getName())) {

			for (Map.Entry<String, String> id : modifyId.entrySet()) {

				String idKey = id.getKey();
				String idValue = id.getValue();
				String objectValue = (String) element.getClass().getMethod(GET + StringUtils.capitalize(idKey))
						.invoke(element);
				if (idValue.equals(objectValue)) {
					operationHelper.setElement(element, modifyTarget);
					break;
				}
			}

			return;
		}

		int size = (int) element.getClass().getMethod(SIZE).invoke(element);

		for (int i = 0; i < size; i++) {
			Object object = element.getClass().getMethod(GET, Integer.TYPE).invoke(element, i);

			for (Map.Entry<String, String> id : modifyId.entrySet()) {

				String idKey = id.getKey();
				String idValue = id.getValue();
				String objectValue = (String) object.getClass().getMethod(GET + StringUtils.capitalize(idKey))
						.invoke(object);

				if (idValue.equals(objectValue)) {
					operationHelper.setElement(object, modifyTarget);
				}

				break;
			}
		}
	}
}
