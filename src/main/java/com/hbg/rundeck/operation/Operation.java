/**
 * 
 */
package com.hbg.rundeck.operation;

import java.util.Map;

import com.hbg.rundeck.job.Joblist;

/**
 * @author dinulaga
 *
 */
public interface Operation {
	public Joblist process(final String projectId, final Map<String, String> requestBody);
}
