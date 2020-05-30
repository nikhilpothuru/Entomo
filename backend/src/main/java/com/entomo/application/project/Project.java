package com.entomo.application.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false, unique=true)
	private String name;
	@Column(nullable=false)
	private String description; 

	public Project() {
		
	}
	
	public Project(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	// Getters & Setters for Id
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	// Getters & Setters for Name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// Getters & Setters for Description
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
