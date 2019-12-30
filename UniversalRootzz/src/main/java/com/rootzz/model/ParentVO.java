package com.rootzz.model;

import javax.persistence.Id;

public class ParentVO {

	public ParentVO() {
		super();
	}

	@Id
	private int id;

	private String name;
	
	private FamilyRootzzVO familyRootzzVO;

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

	public FamilyRootzzVO getFamilyRootzzVO() {
		return familyRootzzVO;
	}

	public void setFamilyRootzzVO(FamilyRootzzVO familyRootzzVO) {
		this.familyRootzzVO = familyRootzzVO;
	}

	public ParentVO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public void showParentDetails() {
		System.out.println("Parent Id : " + id);
		System.out.println("Parent Name : " + name);
	}

}
