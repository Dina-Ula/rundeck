/**
 * 
 */
package com.hbg.rundeck.facade;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.job.Joblist.Job;
import com.hbg.rundeck.project.model.Project;
import com.hbg.rundeck.service.JobService;

/**
 * @author dinulaga
 *
 */
@Component
public class JobFacade {

	@Autowired
	private JobService service;

	public List<Project> getAllProjects() {
		return service.getAllProjects().getBody();
	}

	public Joblist getProjectByName(String id) {
		return service.getProjectById(id).getBody();
	}

	public Set<String> getAllElements() {
		Map<String, List<String>> elements = service.getAllElements();

		return elements.keySet();
	}

	public List<String> getAllElementsByName(String name) {
		Map<String, List<String>> elements = service.getAllElements();	

		return elements.get(name);
	}

	public void editJobByProjectId(final Map<String, String> requestBody, String projectId) {
		Joblist joblist = service.getProjectById(projectId).getBody();
		List<Job> jobs = joblist.getJob();
		for (Job job : jobs) {
			job.setDescription(job.getDescription() + "Test");
		}

		service.editProjectById(joblist, projectId);
	}
}
