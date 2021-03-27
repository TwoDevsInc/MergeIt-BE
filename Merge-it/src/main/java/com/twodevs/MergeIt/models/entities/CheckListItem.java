package com.twodevs.MergeIt.models.entities;
// Generated 26 mar. 2021 21:06:26 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChecklistItems generated by hbm2java
 */
@Entity
@Table(name = "checklist_items")
public class CheckListItem implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private CheckList checkList;
	private String name;
	private Boolean done;

	public CheckListItem() {
	}

	public CheckListItem(int id, CheckList checkList) {
		this.id = id;
		this.checkList = checkList;
	}

	public CheckListItem(int id, CheckList checkList, String name, Boolean done) {
		this.id = id;
		this.checkList = checkList;
		this.name = name;
		this.done = done;
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
	@JoinColumn(name = "id_checklist", nullable = false)
	public CheckList getChecklists() {
		return this.checkList;
	}

	public void setChecklists(CheckList checkList) {
		this.checkList = checkList;
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

}