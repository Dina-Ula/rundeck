/**
 * 
 */
package com.hbg.rundeck.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hbg.rundeck.constants.RundeckConstants;
import com.hbg.rundeck.facade.JobFacade;
import com.hbg.rundeck.project.model.Project;

/**
 * @author dinulaga
 *
 */
@Controller
public class JobController {

	@Autowired
	private JobFacade facade;

	@GetMapping("/projects")
	public String getAllProjects(Model model) {
		final List<Project> projects = facade.getAllProjects();

		model.addAttribute("projects", projects);

		return "projects";
	}

	@GetMapping("/project/{projectId}")
	public String getProject(Model model, @PathVariable String projectId) {
		model.addAttribute("projectId", projectId);
		model.addAttribute("elements", "job");

		return "project";
	}

	@PostMapping("/project/{projectId}")
	public String editProject(@PathVariable String projectId, @RequestParam final Map<String, String> requestBody,
			RedirectAttributes redirectAttributes) {

		String status = facade.editJobByProjectId(requestBody, projectId);

		if (RundeckConstants.FAILED.equals(status)) {
			redirectAttributes.addFlashAttribute(RundeckConstants.STATUS, RundeckConstants.SOMETHING_WENT_WRONG);
			return "redirect:/project/" + projectId;
		}

		return "redirect:/success";
	}
}
