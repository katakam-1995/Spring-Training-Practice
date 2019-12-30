package com.otsi.service.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otsi.dao.EmployeeDao;
import com.otsi.model.EmployeeDto;
import com.otsi.model.EmployeeVo;
import com.otsi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public List<EmployeeVo> saveEmployeeDetails(List<EmployeeVo> empVo) {
		List<EmployeeVo> empList = new ArrayList<>();
		List<EmployeeDto> dtoList = new ArrayList<>();
		empVo.forEach(e -> {
			EmployeeDto dto = new EmployeeDto();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setStatus(e.isStatus());
			dto.setAddress(e.getAddress());
			dtoList.add(dto);
		});

		List<EmployeeDto> list = employeeDao.saveAll(dtoList);
		list.forEach(e -> {
			EmployeeVo vo = new EmployeeVo();
			vo.setId(e.getId());
			vo.setName(e.getName());
			vo.setAge(e.getAge());
			vo.setStatus(e.isStatus());
			vo.setAddress(e.getAddress());
			empList.add(vo);
		});

		return empList;
	}

	public EmployeeVo addEmployee(EmployeeVo vo) {
		EmployeeDto dto = new EmployeeDto();
		dto.setId(vo.getId());
		dto.setName(vo.getName());
		dto.setAge(vo.getAge());
		dto.setStatus(vo.isStatus());
		dto.setAddress(vo.getAddress());

		EmployeeDto emp = employeeDao.save(dto);

		vo.setId(emp.getId());
		vo.setName(emp.getName());
		vo.setAge(emp.getAge());
		vo.setStatus(emp.isStatus());
		vo.setAddress(emp.getAddress());

		return vo;

	}

}
