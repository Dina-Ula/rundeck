/**
 * 
 */
package com.hbg.rundeck.service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hbg.rundeck.auth.model.User;
import com.hbg.rundeck.client.JobClient;
import com.hbg.rundeck.config.RundeckConfiguration;
import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.project.model.Project;
import com.hbg.rundeck.result.Result;

/**
 * @author dinulaga
 *
 */
@Component
public class JobService {

	@Autowired
	private User user;

	@Autowired
	private JobClient client;

	@Autowired
	private RundeckConfiguration rundeckConfiguration;

	public ResponseEntity<List<Project>> getAllProjects() {
		return client.getAllProjects(rundeckConfiguration.getJob().getAll(), user.getHeaders());
	}

	public Map<String, List<String>> getAllElements() {
		return rundeckConfiguration.getElements();
	}

	public Map<String, List<String>> getElementsToAdd() {
		return rundeckConfiguration.getElementsToAdd();
	}
	
	public Map<String, List<String>> getElementsToRemove() {
		return rundeckConfiguration.getElementsToRemove();
	}

	public Map<String, List<String>> getAllElementsToIdentify() {
		return rundeckConfiguration.getElementsToIdentify();
	}

	public Map<String, List<String>> getAllElementsToUpdate() {
		return rundeckConfiguration.getElementsToUpdate();
	}

	public ResponseEntity<Joblist> getProjectById(String projectId) {
		String projectURL = MessageFormat.format(rundeckConfiguration.getJob().getAny(), projectId);
		return client.getProjectById(projectURL, user.getHeaders());
	}

	public ResponseEntity<Result> editProjectById(Joblist joblist, String projectId) {
		String projectURL = MessageFormat.format(rundeckConfiguration.getJob().getEdit(), projectId);

		HttpHeaders headers = user.getHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);

		HttpEntity<Joblist> requestEntity = new HttpEntity<>(joblist, headers);

		return client.editProjectById(projectURL, requestEntity, joblist);
	}

	public boolean isElementTypeBoolean(String elementName) {
		return rundeckConfiguration.getElementTypeBoolean().contains(elementName.toLowerCase());
	}

	public boolean isElementTypeList(String elementName) {
		return rundeckConfiguration.getElementTypeList().contains(elementName.toLowerCase());
	}
}
