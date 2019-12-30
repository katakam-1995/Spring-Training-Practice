package com.otsi.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.otsi.jpa.model.Employee;
import com.otsi.jpa.service.impl.EmployeeServiceImpl;


@Controller
@RequestMapping("/roles")
public class RolesController {
	
	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	/*
	 * @PostMapping(value="/saveEmployeeDetails") public
	 * ResponseEntity<List<Employee>> saveEmployeeDetails(@RequestBody
	 * List<Employee> empVo){ List<Employee>
	 * employeeDetails=empServiceImpl.saveRolesAndEmployeeDetails(empVo); return
	 * ResponseEntity.status(HttpStatus.OK) .body(employeeDetails); }
	 */
	
	@GetMapping(value="/getEmployeeDetails")
	public ResponseEntity<Employee> getEmployeeDetails(@RequestParam int id){
		Employee employee=empServiceImpl.getEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(employee);
	}
}
