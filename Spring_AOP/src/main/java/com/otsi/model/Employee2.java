package com.otsi.model;

import javax.persistence.GenerationType;

//import javax.persistence.Id;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;


import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

@Document

public class Employee2 {


	@Id
	@GeneratedValue(strategy = GenerationStrategy.UNIQUE)
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Field
	private String name;

	@Field
	private long age;

	@Field
	private boolean status;

	@Field
	private String address;

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}

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
		return "Employee2 [id=" + id + ", name=" + name + ", age=" + age + ", status=" + status + ", address=" + address
				+ "]";
	}

//	public Employee2() {
//		super();
//	}

}
