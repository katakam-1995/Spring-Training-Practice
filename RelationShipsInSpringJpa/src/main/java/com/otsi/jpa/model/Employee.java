package com.otsi.jpa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    
    private String age;

    private String address;
    
   
    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = false)
    private Department department;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "emp_role",
    joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))  
    //@JsonProperty("roles")
    private List<Roles> roles;

	public List<Roles> getRoles() {
		return roles;
	}

	@JsonCreator
	public void setRoles(@JsonProperty("roles") List<Roles> roles) {
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(int id, String name, String age, String address, Department department, List<Roles> roles) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.department = department;
		this.roles = roles;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
