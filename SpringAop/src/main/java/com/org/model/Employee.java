package com.org.model;

public class Employee {
	
	private long id;
	
	private String name;
	
	private long age;
	
	private boolean status;
	
	private String address;

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

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(long id, String name, long age, boolean status, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.status = status;
		this.address = address;
	}
	

}
