package com.rootzz.model;

public class FamilyRootzzVO {
	
	private int id;

	private String surName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public FamilyRootzzVO(int id, String surName) {
		super();
		this.id = id;
		this.surName = surName;
	}

	public FamilyRootzzVO() {
		super();
	}
	
	
}
