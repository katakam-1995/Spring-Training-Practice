package com.otsi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="report")
public class Report {
	
	@Id
	private long id;
	
	private String name;
	
	private String details;
	
	private String budget;

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

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public Report(long id, String name, String details, String budget) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.budget = budget;
	}

	public Report() {
		super();
	}


	
	

}
