/**
 * 
 */
package com.hbg.rundeck.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hbg.rundeck.facade.JobFacade;

/**
 * @author dinulaga
 *
 */
@RestController
public class JobRestController {

	@Autowired
	private JobFacade facade;

	@GetMapping(path = "/project/job/attributes/{name}")
	public ResponseEntity<List<String>> getElementsByName(@PathVariable String name) {
		List<String> elements = facade.getAllElementsByName(name);

		return new ResponseEntity<List<String>>(elements, HttpStatus.OK);
	}
}
