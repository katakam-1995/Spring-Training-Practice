package com.otsi.emp.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.otsi.emp.model.EmployeeVO;
import com.otsi.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	List<EmployeeVO> employeeList=new ArrayList<>();
	
	@Override
	public List<EmployeeVO> saveEmployeeDetails(List<EmployeeVO> list) {		 
		 List<EmployeeVO> empDetails=list.stream().map(emp -> setEmployeeDetails(emp)).collect(Collectors.toList());
		 employeeList.addAll(empDetails);
		 System.out.println(employeeList);
		 if(!ObjectUtils.isEmpty(employeeList)) {
			 return employeeList;
		 }
		 return Collections.emptyList();
	}

	private EmployeeVO setEmployeeDetails(EmployeeVO empVO) {
		EmployeeVO employee=new EmployeeVO();
		employee.setId(empVO.getId());
		employee.setName(empVO.getName());
		employee.setAge(empVO.getAge());
		employee.setStatus(empVO.isStatus());
		employee.setAddress(empVO.getAddress());
		return employee;
	}

	public EmployeeVO getEmployeeDetails(long id) {
		EmployeeVO emp = employeeList.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);
		System.out.println(emp);
		return emp;
	}

	public EmployeeVO updateEmployeeDetails(long id) {
		return null;
	}

}
