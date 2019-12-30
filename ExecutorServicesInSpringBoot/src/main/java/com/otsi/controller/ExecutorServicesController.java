package com.otsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.service.ExecutorServicesImpl;

@RestController
public class ExecutorServicesController {

	@Autowired
	private ExecutorServicesImpl executorServicesImpl;

	/*
	 * @GetMapping("/generatingUniqueIdsToNames") public
	 * ResponseEntity<List<ExecutorServices>> generatingUniqueIdsToNames() {
	 * List<ExecutorServices> listOfNamesWithIds =
	 * executorServicesImpl.generatingUniqueIdsToNames(); return
	 * ResponseEntity.status(HttpStatus.OK).body(listOfNamesWithIds);
	 * 
	 * }
	 */
	
	@GetMapping("/generatingUniqueIdsToNames")
	public void generatingUniqueIdsToNames() throws InterruptedException {
		executorServicesImpl.generatingUniqueIdsToNames();
	}

}
