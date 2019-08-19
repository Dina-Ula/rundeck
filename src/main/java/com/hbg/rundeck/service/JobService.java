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

	public ResponseEntity<Joblist> getProjectById(String projectId) {
		String projectURL = MessageFormat.format(rundeckConfiguration.getJob().getAny(), projectId);
		return client.getProjectById(projectURL, user.getHeaders());
	}

	public ResponseEntity<String> editProjectById(Joblist joblist, String projectId) {
		String projectURL = MessageFormat.format(rundeckConfiguration.getJob().getEdit(), projectId);

		HttpHeaders headers = user.getHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);

		HttpEntity<Joblist> requestEntity = new HttpEntity<>(joblist, headers);

		return client.editProjectById(projectURL, requestEntity, joblist);
	}

}
