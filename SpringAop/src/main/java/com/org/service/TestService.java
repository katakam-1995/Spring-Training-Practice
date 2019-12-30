package com.org.service;

import java.util.List;

import com.org.model.Employee;

public interface TestService {

	String getInfo(String info);

	List<Employee> saveEmployeeDetails(List<Employee> empVo);

}
