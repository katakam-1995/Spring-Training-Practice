package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.model.Employee;
import com.org.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/getInfo")
	private String getInfo(String info) {
		return testService.getInfo(info);

	}
	
	@PostMapping(value="/saveEmployeeDetails")
	public  ResponseEntity<List<Employee>> saveEmployeeDetails(@RequestBody List<Employee> empVo){
		List<Employee> employeeDetails=testService.saveEmployeeDetails(empVo);
		return  ResponseEntity.status(HttpStatus.OK)
		        .body(employeeDetails);
	}
	

}
