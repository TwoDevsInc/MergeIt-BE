package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 18:34:00 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
public class Projects implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Teams teams;
	private String name;
	private Date createdAt;
	private Set<Lists> listses = new HashSet<Lists>(0);

	public Projects() {
	}

	public Projects(int id, Teams teams, Date createdAt) {
		this.id = id;
		this.teams = teams;
		this.createdAt = createdAt;
	}

	public Projects(int id, Teams teams, String name, Date createdAt, Set<Lists> listses) {
		this.id = id;
		this.teams = teams;
		this.name = name;
		this.createdAt = createdAt;
		this.listses = listses;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_team", nullable = false)
	public Teams getTeams() {
		return this.teams;
	}

	public void setTeams(Teams teams) {
		this.teams = teams;
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
	public Set<Lists> getListses() {
		return this.listses;
	}

	public void setListses(Set<Lists> listses) {
		this.listses = listses;
	}

}