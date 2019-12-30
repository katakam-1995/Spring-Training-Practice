package com.otsi.dao;

import com.otsi.model.Employee;

public interface EmployeeDao {
	public void insert(Employee employee);
	public Employee findById(int id);
	void insertPostgreSql(Employee employee);
}

