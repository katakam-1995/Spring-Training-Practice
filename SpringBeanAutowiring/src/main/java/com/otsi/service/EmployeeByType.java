package com.otsi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.otsi.model.Employee;

public class EmployeeByType {

		@Autowired
		private Employee employee;
		
		@Autowired
		public void setEmployee(Employee emp){
			this.employee=emp;
		}
		
		public Employee getEmployee(){
			return this.employee;
		}
}
