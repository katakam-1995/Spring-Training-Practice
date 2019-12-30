package com.otsi.model;

import javax.persistence.Id;

public class Company {
	
	@Id
	private long id;

	private String name;

	private long year;

}
