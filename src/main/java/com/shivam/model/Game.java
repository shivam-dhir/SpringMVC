package com.shivam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="gamedb")
public class Game {

	@Id
	private int id;
	private String name;
	private int metascore;
	
	

	public Game() {
		super();
	}

	// if creating a parameterized constructor for an entity class, it is necessary to create a default constructor with no 
	// fields. This helps spring to create a bean for this class.
	public Game(int id, String name, int metascore) {
		super();
		this.id = id; 
		this.name = name;
		this.metascore = metascore;
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
	
	public int getMetascore() {
		return metascore;
	}
	
	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", metascore=" + metascore + "]";
	}
	
	
	
}
