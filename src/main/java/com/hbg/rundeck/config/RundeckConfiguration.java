/**
 * 
 */
package com.hbg.rundeck.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.hbg.rundeck.config.model.Authentication;
import com.hbg.rundeck.config.model.Job;

import lombok.Data;

/**
 * @author dinulaga
 *
 */
@Data
@Component
@ConfigurationProperties("rundeck")
public class RundeckConfiguration {
	private Job job;
	private Authentication authentication;

	private Map<String, List<String>> elements;
	private Map<String, List<String>> elementsToAdd;
	private Map<String, List<String>> elementsToRemove;
	private Map<String, List<String>> elementsToIdentify;
	private Map<String, List<String>> elementsToUpdate;

	private List<String> elementTypeBoolean;
	private List<String> elementTypeList;
}
