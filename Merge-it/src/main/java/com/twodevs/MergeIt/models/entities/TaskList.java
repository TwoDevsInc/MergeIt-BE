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
 * Lists generated by hbm2java
 */
@Entity
@Table(name = "lists")
public class TaskList implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Project project;
	private String name;
	private Date createdAt;
	private Boolean archived;
	private Set<Task> tasks = new HashSet<Task>(0);

	public TaskList() {
	}

	public TaskList(int id, Project project, Date createdAt) {
		this.id = id;
		this.project = project;
		this.createdAt = createdAt;
	}

	public TaskList(int id, Project project, String name, Date createdAt, Boolean archived, Set<Task> tasks) {
		this.id = id;
		this.project = project;
		this.name = name;
		this.createdAt = createdAt;
		this.archived = archived;
		this.tasks = tasks;
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
	@JoinColumn(name = "id_project", nullable = false)
	public Project getProjects() {
		return this.project;
	}

	public void setProjects(Project project) {
		this.project = project;
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

	@Column(name = "archived")
	public Boolean getArchived() {
		return this.archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "lists")
	public Set<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

}