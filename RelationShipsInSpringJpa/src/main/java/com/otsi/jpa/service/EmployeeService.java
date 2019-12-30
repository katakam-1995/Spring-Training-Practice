package com.otsi.jpa.service;

import java.util.List;
import java.util.Optional;

import com.otsi.jpa.model.Employee;

public interface EmployeeService {
	
	List<Employee> saveEmployeeDetails(List<Employee> emp) ;
	Employee getEmployeeDetails(int id);

}
