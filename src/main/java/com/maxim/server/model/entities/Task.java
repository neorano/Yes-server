package com.maxim.server.model.entities;

import java.sql.Timestamp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Task {

	private long id;
	
	private Timestamp begin;
	
	private Timestamp end;
	
	private String description;
	
	@JsonIgnoreProperties({"tasks"})

	private Technician technician;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getBegin() {
		return begin;
	}

	public void setBegin(Timestamp begin) {
		this.begin = begin;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	
}
