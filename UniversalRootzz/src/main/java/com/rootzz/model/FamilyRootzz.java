package com.rootzz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "family_root")
public class FamilyRootzz {

	@Id
	private int id;

	private String surName;

	@OneToMany(mappedBy = "familyRootzz")
	@JsonIgnore
	private List<Parent> parent;

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

	public List<Parent> getParent() {
		return parent;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

	
}
