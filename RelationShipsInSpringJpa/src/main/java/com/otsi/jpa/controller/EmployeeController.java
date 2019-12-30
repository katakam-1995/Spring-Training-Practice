package com.otsi.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otsi.jpa.model.Employee;
import com.otsi.jpa.service.impl.EmployeeServiceImpl;



@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	@PostMapping(value="/saveEmployeeDetails")
	public  ResponseEntity<List<Employee>> saveEmployeeDetails(@RequestBody List<Employee> empVo){
		List<Employee> employeeDetails=empServiceImpl.saveEmployeeDetails(empVo);
		return  ResponseEntity.status(HttpStatus.OK)
		        .body(employeeDetails);
	}
	
	@GetMapping(value="/getEmployeeDetails")
	public ResponseEntity<Employee> getEmployeeDetails(@RequestParam int id){
		Employee employee=empServiceImpl.getEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(employee);
	}
	
	@GetMapping(value="/getEmployeeDetailsWithGivenCount")
	public ResponseEntity<Page<Employee>> getEmployeeDetailsWithGivenCount(@RequestParam int id){

		Page<Employee> allEmployees = empServiceImpl.getEmployeeDetailsWithGivenCount(id);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(allEmployees);
	}
	
	@GetMapping(value="/getEmployeeDetailsWithGivenName")
	public ResponseEntity<Page<Employee>> getEmployeeDetailsWithGivenName(@RequestParam String name){

		Page<Employee> allEmployees = empServiceImpl.getEmployeeDetailsWithGivenName(name);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(allEmployees);
	}
	
	@GetMapping(value="/getEmployees")
	public ResponseEntity<Page<Employee>> getEmployees(){

		Page<Employee> allEmployees = empServiceImpl.getEmployees();
		return ResponseEntity.status(HttpStatus.OK)
		        .body(allEmployees);
	}
}
