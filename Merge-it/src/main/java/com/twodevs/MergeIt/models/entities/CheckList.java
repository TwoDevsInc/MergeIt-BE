package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 21:06:26 by Hibernate Tools 5.2.12.Final

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Checklists generated by hbm2java
 */
@Entity
@Table(name = "checklists")
public class CheckList implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	@JsonIgnoreProperties({"taskList","files","comments","checkLists","hibernateLazyInitializer", "handler"})
	private Task task;
	private String name;
	private Boolean done;
	@JsonIgnoreProperties({"checklist"})
	private Set<CheckListItem> checkListItems = new HashSet<CheckListItem>(0);

	public CheckList() {
	}

	public CheckList(int id, Task task) {
		this.id = id;
		this.task = task;
	}

	public CheckList(int id, Task task, String name, Boolean done, Set<CheckListItem> checkListItems) {
		this.id = id;
		this.task = task;
		this.name = name;
		this.done = done;
		this.checkListItems = checkListItems;
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

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "done")
	public Boolean getDone() {
		return this.done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "checklist")
	public Set<CheckListItem> getCheckListItems() {
		return this.checkListItems;
	}

	public void setCheckListItems(Set<CheckListItem> checkListItems) {
		this.checkListItems = checkListItems;
	}

}
