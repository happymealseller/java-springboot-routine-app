package com.myproject.habitapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private int taskId;	
	
	@Column(name="task_order")
	private	int taskOrder;
	
	@Column(name="task_name")
	private	String taskName;	
			
	@Column(name="task_description")
	private	String taskDescription;
	
	@Column(name="task_duration")
	private	int taskDuration;
	
	@Column(name="task_status")
	private	String taskStatus;
	
	@ManyToOne
	@JoinColumn(name = "routine_id")	
	private Routine routine; 	
	
	public Task() {}	

	public int getTaskId() {
		return taskId;
	}

	public int getTaskOrder() {
		return taskOrder;
	}

	public void setTaskOrder(int taskOrder) {
		this.taskOrder = taskOrder;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getTaskDuration() {
		return taskDuration;
	}

	public void setTaskDuration(int taskDuration) {
		this.taskDuration = taskDuration;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	
}
