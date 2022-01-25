package com.maxim.server.model.entities;

import java.util.List;


public class Technician {

	private long id;

	private String name;

	private List<Task> tasks;

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

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Technician(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Technician() {
		super();
	}
	
	
	
}
