package com.otsi.service;

import java.util.List;

import com.otsi.model.EmployeeVo;

public interface EmployeeService {
	
	List<EmployeeVo> saveEmployeeDetails(List<EmployeeVo> empVo);

}
