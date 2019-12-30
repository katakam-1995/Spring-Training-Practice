package com.otsi.model;

import org.springframework.batch.item.ItemProcessor;

import com.otsi.dao.Employee;

public class DBLogProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee employee) throws Exception {
		System.out.println("Inserting employee : " + employee);
		if(employee.getId() == null) {
			System.out.println("Missing employee id : " + employee.getId());
			return null;
		}
        return employee;
	}

}
