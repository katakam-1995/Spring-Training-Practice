package com.otsi.service.impl;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otsi.model.Employee;
import com.otsi.repository.EmployeeRepository;
import com.otsi.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getEmployeesList() {
		List<Employee> employees=employeeRepository.findAll();
		return employees;
	}


	@Override
	public void getEmployee(String employeeId, Path path) {
		Optional<Employee> employee=employeeRepository.findById(Integer.parseInt(employeeId));
		Employee emp=employee.get();
		emp.setFilePath(path.toString());
		employeeRepository.save(emp);		
	}

}
