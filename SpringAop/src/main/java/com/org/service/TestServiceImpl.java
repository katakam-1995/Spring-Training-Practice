package com.org.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.org.model.Employee;

@Service
public class TestServiceImpl implements TestService {

	public static List<Employee> employeeList=new ArrayList<>();

	@Override
	public String getInfo(String info) {
		
		return info;
	}

	@Override
	public List<Employee> saveEmployeeDetails(List<Employee> emp) {
		employeeList.addAll(emp);
		 if(!ObjectUtils.isEmpty(employeeList)) {
			 return employeeList;
		 }
		 return Collections.emptyList();
	}

}
