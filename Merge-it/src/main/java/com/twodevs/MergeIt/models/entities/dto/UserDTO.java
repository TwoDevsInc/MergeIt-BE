package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.User;

public class UserDTO implements Serializable{
	
	private int id;
	private String username;
	private String email;
	private String name;
	private String surname;
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.name = user.getName();
		this.surname = user.getSurname();
	}
	
	public UserDTO(UserRegisterDTO user) {
		this.username = user.getUsername();
		this.email = user.getEmail();
		this.name = user.getName();
		this.surname = user.getSurname();
	}
	
	public UserDTO() {
	}
	
	public UserDTO(int id, String username, String email, String name, String surname,
			Set<TeamDTO> teams) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	

}
