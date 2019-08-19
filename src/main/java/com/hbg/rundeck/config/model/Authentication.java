/**
 * 
 */
package com.hbg.rundeck.config.model;

import lombok.Data;

/**
 * @author dinulaga
 *
 */
@Data
public class Authentication {
	private String username;
	private String password;
	private String endpoint;
	private String successURL;
}
