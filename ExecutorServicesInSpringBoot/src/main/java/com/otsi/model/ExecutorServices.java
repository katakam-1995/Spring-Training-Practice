package com.otsi.model;

public class ExecutorServices {

	public ExecutorServices(int id, String name, String thrdnme) {
		super();
		this.id = id;
		this.name = name;
		this.thrdnme = thrdnme;
	}

	private int id;

	private String name;

	private String thrdnme;

	public String getThrdnme() {
		return thrdnme;
	}

	public void setThrdnme(String thrdnme) {
		this.thrdnme = thrdnme;
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

	@Override
	public String toString() {
		return "ExecutorServices [id=" + id + ", name=" + name + ", thrdnme=" + thrdnme + "]";
	}

	public ExecutorServices() {
	}

}
