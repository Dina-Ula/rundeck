/**
 * 
 */
package com.hbg.rundeck.operation.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.hbg.rundeck.job.Joblist;
import com.hbg.rundeck.job.Joblist.Job;
import com.hbg.rundeck.job.Joblist.Job.Context;
import com.hbg.rundeck.job.Joblist.Job.Context.Options;
import com.hbg.rundeck.job.Joblist.Job.Context.Options.Option;
import com.hbg.rundeck.operation.Operation;
import com.hbg.rundeck.service.JobService;

/**
 * @author dinulaga
 *
 */
@Component
public class ReorderOperation implements Operation {

	private static final String OPTION_PREFIX = "option-";

	@Autowired
	private JobService service;

	@Override
	public Joblist process(String projectId, final Map<String, String> pOptions) {

		List<String> optionNames = IntStream.range(1, pOptions.size())
				.filter(entry -> pOptions.get(OPTION_PREFIX + Integer.toString(entry)) != null)
				.mapToObj(entry -> pOptions.get(OPTION_PREFIX + Integer.toString(entry))).collect(Collectors.toList());

		if (CollectionUtils.isEmpty(optionNames)) {
			return null;
		}

		Joblist joblist = service.getProjectById(projectId).getBody();

		List<Job> jobs = joblist.getJob();
		for (Job job : jobs) {

			Context contextElement = job.getContext();
			if (contextElement == null) {
				continue;
			}

			Options optionsElement = contextElement.getOptions();
			if (optionsElement == null) {
				continue;
			}

			List<Option> optionsList = optionsElement.getOption();
			List<Option> orderedOptionsList = new ArrayList<>();
			for (String optionName : optionNames) {
				for (Option option : optionsList) {
					if (optionName.equalsIgnoreCase(option.getName())) {
						orderedOptionsList.add(option);
					}
				}
			}

			// Add the remaining options to the end
			List<Option> remainingOptions = optionsList.stream()
					.filter(((Predicate<Option>) orderedOptionsList::contains).negate()).collect(Collectors.toList());
			// Clear the existing options list
			optionsList.clear();
			// Add the ordered options and the remaining options to the list
			optionsList.addAll(orderedOptionsList);
			optionsList.addAll(remainingOptions);
		}

		return joblist;
	}

}
