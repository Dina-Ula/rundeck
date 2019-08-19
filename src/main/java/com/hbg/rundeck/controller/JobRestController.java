/**
 * 
 */
package com.hbg.rundeck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	private static final String ALL_ATTRIBUTES = "allAttributes";
	private static final String ADD_ATTRIBUTES = "addAttributes";

	private static final String ID_ATTRIBUTES = "idAttributes";
	private static final String TARGET_ATTRIBUTES = "targetAttributes";

	@Autowired
	private JobFacade facade;

	@GetMapping(path = "/project/job/attributes/{name}")
	public ResponseEntity<List<String>> getElementsByName(@PathVariable String name) {
		List<String> elements = facade.getAllElementsByName(name);

		return new ResponseEntity<List<String>>(elements, HttpStatus.OK);
	}

	@GetMapping(path = "/project/job/attributes/add/{name}")
	public ResponseEntity<Map<String, List<String>>> getAddElementsByName(@PathVariable String name) {
		Map<String, List<String>> elements = new HashMap<String, List<String>>();

		elements.put(ALL_ATTRIBUTES, facade.getAllElementsByName(name));
		elements.put(ADD_ATTRIBUTES, facade.getElementsToAddByName(name));

		return ResponseEntity.ok().body(elements);
	}

	@GetMapping(path = "/project/job/attributes/remove/{name}")
	public ResponseEntity<Map<String, List<String>>> getRemoveElementsByName(@PathVariable String name) {
		Map<String, List<String>> elements = new HashMap<String, List<String>>();

		elements.put(ALL_ATTRIBUTES, facade.getAllElementsByName(name));
		elements.put(ADD_ATTRIBUTES, facade.getElementsToRemoveByName(name));

		return ResponseEntity.ok().body(elements);
	}

	@GetMapping(path = "/project/job/attributes/update/{name}")
	public ResponseEntity<Map<String, List<String>>> getElementsToUpdateByName(@PathVariable String name) {
		Map<String, List<String>> elements = new HashMap<String, List<String>>();

		elements.put(ALL_ATTRIBUTES, facade.getAllElementsByName(name));
		elements.put(ID_ATTRIBUTES, facade.getAllElementsToIdentifyByName(name));
		elements.put(TARGET_ATTRIBUTES, facade.getAllElementsToUpdateByName(name));

		return ResponseEntity.ok().body(elements);
	}
}
