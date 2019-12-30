package com.otsi.model;

import javax.validation.constraints.NotEmpty;

public class EmployeeVo {

	private int id;

    @NotEmpty(message = "Name Must Not Be Empty")
	private String name;

	private String age;

	@NotEmpty(message = "Address Must Not Be Empty")
	private String address;
	
	private boolean status;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EmployeeVo [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", status="
				+ status + "]";
	}

	

	
	

}
