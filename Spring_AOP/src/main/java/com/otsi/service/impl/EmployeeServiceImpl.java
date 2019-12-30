package com.otsi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otsi.dao.CouchBaseRepository;
import com.otsi.dao.EmployeeDao;
import com.otsi.model.Employee;
import com.otsi.model.Employee2;
import com.otsi.model.EmployeeVO;
import com.otsi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private CouchBaseRepository couchBaseRepository;

	@Override
	public List<EmployeeVO> saveEmployeeDetails(List<EmployeeVO> empVo) {
		List<EmployeeVO> empList = new ArrayList<>();
		List<Employee> dtoList = new ArrayList<>();
		empVo.forEach(e -> {
			Employee dto = new Employee();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setStatus(e.isStatus());
			dto.setAddress(e.getAddress());
			dtoList.add(dto);
		});

		List<Employee> list = employeeDao.saveAll(dtoList);
		
		list.forEach(e -> {
			EmployeeVO vo = new EmployeeVO();
			vo.setId(e.getId());
			vo.setName(e.getName());
			vo.setAge(e.getAge());
			vo.setStatus(e.isStatus());
			vo.setAddress(e.getAddress());
			empList.add(vo);
		});
		
		
		return empList;

		//return saveEmployeeDataInCouchBase(empList);
	}

	public List<EmployeeVO> saveEmployeeDataInCouchBase(List<EmployeeVO> empVo) {
		List<EmployeeVO> empList = new ArrayList<>();
		List<Employee2> dtoList = new ArrayList<>();
		empVo.forEach(e -> {
			Employee2 dto = new Employee2();
			dto.setId(Long.toString(e.getId()));
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setStatus(e.isStatus());
			dto.setAddress(e.getAddress());
			dtoList.add(dto);
		});
		
		List<Employee2> list = (List<Employee2>) couchBaseRepository.saveAll(dtoList);

		list.forEach(e -> {
			EmployeeVO vo = new EmployeeVO();
			vo.setId(Long.parseLong(e.getId()));
			vo.setName(e.getName());
			vo.setAge(e.getAge());
			vo.setStatus(e.isStatus());
			vo.setAddress(e.getAddress());
			empList.add(vo);
		});

		return empList;
	}
	
}
