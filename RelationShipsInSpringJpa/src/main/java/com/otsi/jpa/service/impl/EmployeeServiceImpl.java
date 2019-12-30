package com.otsi.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.otsi.jpa.exception.ResourceNotFoundException;
import com.otsi.jpa.model.Employee;
import com.otsi.jpa.repository.DepartmentDao;
import com.otsi.jpa.repository.EmployeeDao;
import com.otsi.jpa.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private DepartmentDao deptDao;
	/*
	 * public List<Employee> saveEmployeeDetails(List<Employee> emp) {
	 * 
	 * emp = emp.stream().map(employee -> { int id =
	 * employee.getDepartment().getId(); Optional<Department> dept =
	 * deptDao.findById(id); employee.setDepartment(dept.get()); return employee;
	 * }).collect(Collectors.toList());
	 * 
	 * List<Employee> list=employeeDao.saveAll(emp); return list; }
	 * 
	 * public Employee getEmployeeDetails(int id) { return
	 * employeeDao.findById(id).map(emp -> { emp.setName(emp.getName());
	 * emp.setAge(emp.getAge()); emp.setAddress(emp.getAddress()); return
	 * employeeDao.save(emp); }).orElseThrow(() -> new
	 * ResourceNotFoundException("emp_id " + id + " not found")); }
	 * 
	 * public List<Employee> saveRolesAndEmployeeDetails(List<Employee> emp) {
	 * List<Employee> list=employeeDao.saveAll(emp); return list; }
	 */

	public Page<Employee> getEmployeeDetailsWithGivenCount(int id) {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Page<Employee> allEmployees = employeeDao.findAllById(id, firstPageWithTwoElements);
		return allEmployees;
	}

	@Override
	public List<Employee> saveEmployeeDetails(List<Employee> emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getEmployeeDetails(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Page<Employee> getEmployeeDetailsWithGivenName(String name) {
		Pageable sortedByName = 
				  PageRequest.of(0, 3, Sort.by("name"));
		Page<Employee> allEmployees = employeeDao.findAllByName(name, sortedByName);
		return allEmployees;
	}

	public Page<Employee> getEmployees() {
		Pageable pageSize = PageRequest.of(0, 5);
		Page<Employee> allEmployees = employeeDao.findAll(pageSize);
		return allEmployees;
	}

}
