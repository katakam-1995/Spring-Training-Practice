package com.rootzz.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "relation")
public class Relation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String relation;
	
	@ManyToMany(mappedBy="relation")
    @JsonIgnoreProperties
	private List<Parent> parent;

	public int getId() {
		return id;
	}

	public String getRelation() {
		return relation;
	}

	public List<Parent> getParent() {
		return parent;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public void setParent(List<Parent> parent) {
		this.parent = parent;
	}

	public Relation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Relation(int id, String relation, List<Parent> parent) {
		super();
		this.id = id;
		this.relation = relation;
		this.parent = parent;
	}

}
