package com.otsi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.exception.ResourceNotFoundException;
import com.otsi.model.EmployeeVo;
import com.otsi.service.service.impl.EmployeeServiceImpl;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empServiceImpl;
	
	@PostMapping(value = "/saveEmployee")
	public ResponseEntity<EmployeeVo> addEmployee (@Valid @RequestBody EmployeeVo employee)
	{
		empServiceImpl.addEmployee(employee);
	    return new ResponseEntity<EmployeeVo>(employee, HttpStatus.OK);
	}
	
	@PostMapping(value="/saveEmployeeDetails")
	public  ResponseEntity<List<EmployeeVo>> saveEmployeeDetails(@RequestBody List<EmployeeVo> empVo) throws Exception{
		if(!empVo.isEmpty()) {
			List<EmployeeVo> employeeDetails=empServiceImpl.saveEmployeeDetails(empVo);
			return  ResponseEntity.status(HttpStatus.OK)
			        .body(employeeDetails);
		}
		throw new ResourceNotFoundException("No Input Found");
	}


}
