package com.otsi.service;

import java.nio.file.Path;
import java.util.List;

import com.otsi.model.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployeesList();
	void getEmployee(String employeeId,Path path);
}
