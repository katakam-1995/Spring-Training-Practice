package com.rootzz.model;

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

@Entity
@Table(name = "parent_root")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "root_id", nullable = false)
	private FamilyRootzz familyRootzz;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "parent_relation",
    joinColumns = @JoinColumn(name = "parent_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "rel_id", referencedColumnName = "id"))  
    private List<Relation> relation;

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

	public FamilyRootzz getFamilyRootzz() {
		return familyRootzz;
	}

	public void setFamilyRootzz(FamilyRootzz familyRootzz) {
		this.familyRootzz = familyRootzz;
	}

	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Relation> getRelation() {
		return relation;
	}

	public void setRelation(List<Relation> relation) {
		this.relation = relation;
	}

	public Parent(int id, String name, FamilyRootzz familyRootzz, List<Relation> relation) {
		super();
		this.id = id;
		this.name = name;
		this.familyRootzz = familyRootzz;
		this.relation = relation;
	}

	



}
