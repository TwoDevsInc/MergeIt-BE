package com.twodevs.MergeIt.models.entities;
// Generated 27 mar. 2021 20:36:03 by Hibernate Tools 5.2.12.Final

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
 * Tasks generated by hbm2java
 */
@Entity
@Table(name = "tasks")
public class Task implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private TaskList taskList;
	private String name;
	private String description;
	private Date createdAt;
	private String color;
	private Boolean archivada;
	private Set<File> files = new HashSet<File>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<CheckList> checkLists = new HashSet<CheckList>(0);

	public Task() {
	}

	public Task(int id, TaskList taskList, Date createdAt) {
		this.id = id;
		this.taskList = taskList;
		this.createdAt = createdAt;
	}

	public Task(int id, TaskList taskList, String name, String description, Date createdAt, String color,
			Boolean archivada) {
		this.id = id;
		this.taskList = taskList;
		this.name = name;
		this.description = description;
		this.createdAt = createdAt;
		this.color = color;
		this.archivada = archivada;
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
	@JoinColumn(name = "id_taskList", nullable = false)
	public TaskList getTaskLists() {
		return this.taskList;
	}

	public void setTaskLists(TaskList taskList) {
		this.taskList = taskList;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "created_at", nullable = false, length = 13)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "color", length = 6)
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "archivada")
	public Boolean getArchivada() {
		return this.archivada;
	}

	public void setArchivada(Boolean archivada) {
		this.archivada = archivada;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	public Set<File> getFiles() {
		return this.files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "task")
	public Set<CheckList> getCheckLists() {
		return this.checkLists;
	}

	public void setCheckLists(Set<CheckList> checkLists) {
		this.checkLists = checkLists;
	}

}
