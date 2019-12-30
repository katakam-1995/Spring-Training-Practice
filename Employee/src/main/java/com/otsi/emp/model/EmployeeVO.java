package com.otsi.emp.model;

public class EmployeeVO {

	private long id;
	
	private String name;
	
	private long age;
	
	private boolean status;
	
	private String address;
	
	//private List<EmployeeVO> EmployeeVO;
	
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

	@Override
	public String toString() {
		return "EmployeeVO [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + ", address="
				+ address + "]";
	}

}
