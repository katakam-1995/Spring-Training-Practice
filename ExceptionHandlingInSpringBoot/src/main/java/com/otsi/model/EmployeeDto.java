package com.otsi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeDto {
	
	@Id
    private int id;

    private String name;
    
    private String age;

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

	public EmployeeDto() {
		
	}

	public EmployeeDto(int id, String name, String age, String address, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.status = status;
	}

	
    
    

}
