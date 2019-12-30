package com.otsi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="project")
public class Project {
	
	@Id
	private long id;
	
	private String name;
	
	private String amount;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Project(long id, String name, String amount) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public Project() {
		super();
	}

	
	
}
