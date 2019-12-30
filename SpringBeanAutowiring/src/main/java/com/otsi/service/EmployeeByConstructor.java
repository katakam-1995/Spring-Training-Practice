package com.otsi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.otsi.model.Employee;

public class EmployeeByConstructor {
	private Employee employee;

	@Autowired(required=false)
	public EmployeeByConstructor(@Qualifier("employee") Employee emp){
		this.employee=emp;
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
}
