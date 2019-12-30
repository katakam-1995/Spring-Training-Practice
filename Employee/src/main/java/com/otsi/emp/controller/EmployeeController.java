package com.otsi.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.emp.model.EmployeeVO;
import com.otsi.emp.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	@PostMapping(value="/saveEmployeeDetails")
	public  ResponseEntity<List<EmployeeVO>> saveEmployeeDetails(@RequestBody List<EmployeeVO> empVo){
		List<EmployeeVO> employeeDetails=empServiceImpl.saveEmployeeDetails(empVo);
		return  ResponseEntity.status(HttpStatus.OK)
		        .body(employeeDetails);
	}

	@GetMapping(value="/getEmployeeDetails")
	public ResponseEntity<EmployeeVO> getEmployeeDetails(@RequestParam long id){
		EmployeeVO employee=empServiceImpl.getEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(employee);
	}

	@PutMapping(value="/updateEmployeeDetails")
	public ResponseEntity<EmployeeVO> updateEmployeeDetails(@RequestParam long id){
		EmployeeVO employee=empServiceImpl.updateEmployeeDetails(id);
		return ResponseEntity.status(HttpStatus.OK)
		        .body(employee);
	}

}
