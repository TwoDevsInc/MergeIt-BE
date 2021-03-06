package com.twodevs.MergeIt.models.entities;
// Generated 27 mar. 2021 19:54:19 by Hibernate Tools 5.2.12.Final

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Comments generated by hbm2java
 */
@Entity
@Table(name = "comments")
public class Comment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Task task;
	private User user;
	private String text;
	private LocalDate createdAt;
	private Boolean archived;

	public Comment() {
	}

	public Comment(int id, Task task, User user, LocalDate createdAt) {
		this.id = id;
		this.task = task;
		this.user = user;
		this.createdAt = createdAt;
	}

	public Comment(int id, Task task, User user, String text, LocalDate createdAt, Boolean archived) {
		this.id = id;
		this.task = task;
		this.user = user;
		this.text = text;
		this.createdAt = createdAt;
		this.archived = archived;
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
	@JoinColumn(name = "id_task", nullable = false)
	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "created_at", nullable = true, length = 13)
	public LocalDate getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "archived")
	public Boolean getArchived() {
		return this.archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
