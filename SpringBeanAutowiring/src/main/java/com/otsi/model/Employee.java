package com.otsi.model;

public class Employee {

	private long id;

	private String name;
	
    private Department department;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void showEployeeDetails() {
		System.out.println("Employee Id : " + id);
		System.out.println("Employee Name : " + name);
		System.out.println("Department : " + department.getName());
	}

}
