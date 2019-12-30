package com.rootzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rootzz.model.Parent;
import com.rootzz.service.impl.RootzzServiceImpl;


@Controller
@RequestMapping("/rootzz")
public class RootzzController {
	@Autowired
	private RootzzServiceImpl rootzzServiceImpl;
	
	@PostMapping(value="/saveParentDetails")
	public  ResponseEntity<List<Parent>> saveParentDetails(@RequestBody List<Parent> parent){
		List<Parent> employeeDetails=rootzzServiceImpl.saveParentDetails(parent);
		return  ResponseEntity.status(HttpStatus.OK)
		        .body(employeeDetails);
	}
	
	@PostMapping(value="/saveParentRelationDetails")
	public  ResponseEntity<List<Parent>> saveParentRelationDetails(@RequestBody List<Parent> parent){
		List<Parent> employeeDetails=rootzzServiceImpl.saveParentRelationDetails(parent);
		return  ResponseEntity.status(HttpStatus.OK)
		        .body(employeeDetails);
	}
}
