package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.Team;


public class TeamDTO implements Serializable{
	
	private int id;
	private String name;
	
	public TeamDTO(Team team) {
		this.id = team.getId();
		this.name = team.getName();
	}
	
	public TeamDTO() {
	}

	public TeamDTO(int id, String name, Set<UserDTO> users) {
		super();
		this.id = id;
		this.name = name;
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

	
	
	

}
