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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Projects generated by hbm2java
 */
@Entity
@Table(name = "projects")
public class Project implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Team team;
	private String name;
	private Date createdAt;
	private Set<TaskList> list = new HashSet<TaskList>(0);

	public Project() {
	}

	public Project(int id, Team team, Date createdAt) {
		this.id = id;
		this.team = team;
		this.createdAt = createdAt;
	}

	public Project(int id, Team team, String name, Date createdAt, Set<TaskList> list) {
		this.id = id;
		this.team = team;
		this.name = name;
		this.createdAt = createdAt;
		this.list = list;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team", nullable = false)
	public Team getTeams() {
		return this.team;
	}

	public void setTeams(Team team) {
		this.team = team;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projects")
	public Set<TaskList> getList() {
		return this.list;
	}

	public void setList(Set<TaskList> list) {
		this.list = list;
	}

}