package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 18:34:00 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Teams generated by hbm2java
 */
@Entity
@Table(name = "teams")
public class Team implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Date createdAt;
	@JsonIgnoreProperties({"teams"})
	private Set<User> users = new HashSet<User>(0);
	@JsonIgnoreProperties({"taskLists"})
	private Set<Project> projects = new HashSet<Project>(0);

	public Team() {
	}

	public Team(int id, Date createdAt) {
		this.id = id;
		this.createdAt = createdAt;
	}

	public Team(int id, String name, Date createdAt, Set<User> users, Set<Project> projects) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.users = users;
		this.projects = projects;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", nullable = false, length = 13)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "teams_users", joinColumns = {
			@JoinColumn(name = "id_team", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "id_user", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "teams")
	public Set<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

}
