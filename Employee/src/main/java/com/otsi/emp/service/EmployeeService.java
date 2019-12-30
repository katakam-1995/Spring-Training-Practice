package com.otsi.emp.service;

import java.util.List;

import com.otsi.emp.model.EmployeeVO;

public interface EmployeeService {
	List<EmployeeVO> saveEmployeeDetails(List<EmployeeVO> list);
	EmployeeVO getEmployeeDetails(long id);
}
