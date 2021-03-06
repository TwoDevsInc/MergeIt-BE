package com.twodevs.MergeIt.models.entities.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.twodevs.MergeIt.models.entities.File;

public class FileDTO implements Serializable {
	
	private int id;
	@JsonIgnoreProperties("taskList")
	private TaskDTO task;
	private String name;
	private String path;
	private String type;
	
	public FileDTO(File file) {
		this.id = file.getId();
		this.name = file.getName();
		this.path = file.getPath();
		this.type = file.getType();
		this.task = new TaskDTO(file.getTask());
	}
	
	public FileDTO() {
	}

	public FileDTO(int id, String name, String path, String type,TaskDTO task) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.type = type;
		this.task = task;
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public TaskDTO getTask() {
		return task;
	}

	public void setTask(TaskDTO task) {
		this.task = task;
	}	
	
}
