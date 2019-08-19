/**
 * 
 */
package com.hbg.rundeck.facade;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.operation.Operation;
import com.hbg.rundeck.project.model.Project;
import com.hbg.rundeck.result.Result;
import com.hbg.rundeck.result.Result.Failed;
import com.hbg.rundeck.result.Result.Skipped;
import com.hbg.rundeck.result.Result.Succeeded;
import com.hbg.rundeck.service.JobService;

/**
 * @author dinulaga
 *
 */
@Component
public class JobFacade {

	@Autowired
	private JobService service;

	@Resource
	private Map<String, Operation> operations;

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

	public List<String> getElementsToAddByName(String name) {
		Map<String, List<String>> elements = service.getElementsToAdd();
		return elements.get(name);
	}

	public List<String> getElementsToRemoveByName(String name) {
		Map<String, List<String>> elements = service.getElementsToRemove();
		return elements.get(name);
	}

	public List<String> getAllElementsToIdentifyByName(String name) {
		Map<String, List<String>> elements = service.getAllElementsToIdentify();
		return elements.get(name);
	}

	public List<String> getAllElementsToUpdateByName(String name) {
		Map<String, List<String>> elements = service.getAllElementsToUpdate();
		return elements.get(name);
	}

	public void editJobByProjectId(final Map<String, String> requestBody, String projectId) {

		Joblist jobList = service.getProjectById(projectId).getBody();

		Operation operation = operations.get(requestBody.get("operation"));

		Joblist modifiedJoblist = operation.process(projectId, requestBody);

		if (modifiedJoblist == null) {
			return;
		}

		ResponseEntity<Result> result = service.editProjectById(modifiedJoblist, projectId);
		printResult(result);

		Failed failed = result.getBody().getFailed();
		List<com.hbg.rundeck.result.Result.Failed.Job> failedJobs = failed.getJob();
		if (!CollectionUtils.isEmpty(failedJobs)) {

			System.out.println("The modified job import failed. Hence, the previous version is reloaded!");
			result = service.editProjectById(jobList, projectId);
			printResult(result);
		}
	}

	private void printResult(ResponseEntity<Result> result) {
		Succeeded succeeded = result.getBody().getSucceeded();
		List<com.hbg.rundeck.result.Result.Succeeded.Job> succeededJobs = succeeded.getJob();
		for (com.hbg.rundeck.result.Result.Succeeded.Job succeededJob : succeededJobs) {
			System.out.println("Succeeded Job: " + succeededJob.getId());
		}

		Skipped skipped = result.getBody().getSkipped();
		List<com.hbg.rundeck.result.Result.Skipped.Job> skippedJobs = skipped.getJob();
		for (com.hbg.rundeck.result.Result.Skipped.Job skippedJob : skippedJobs) {
			System.out.println("Skipped Job: " + skippedJob.getId());
		}

		Failed failed = result.getBody().getFailed();
		List<com.hbg.rundeck.result.Result.Failed.Job> failedJobs = failed.getJob();
		for (com.hbg.rundeck.result.Result.Failed.Job failedJob : failedJobs) {
			System.out.println("Failed Job: " + failedJob.getId());
			System.out.println("Failed Job: " + failedJob.getError());
		}
	}
}
