package com.myproject.habitapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="routine")
public class Routine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="routine_id")
	private int routineId;	
	
	@Column(name="routine_order")
	private	int routineOrder;
	
	@Column(name="routine_name")
	private	String routineName;	
			
	@Column(name="routine_description")
	private	String routineDescription;
	
	@ManyToOne
	@JoinColumn(name = "user_id")	
	private User user;
	
	@OneToMany(mappedBy = "routine")
	private List<Task> tasks;
		
	public Routine() {}

	public int getRoutineId() {
		return routineId;
	}

	public void setRoutineId(int routineId) {
		this.routineId = routineId;
	}

	public int getRoutineOrder() {
		return routineOrder;
	}

	public void setRoutineOrder(int routineOrder) {
		this.routineOrder = routineOrder;
	}

	public String getRoutineName() {
		return routineName;
	}

	public void setRoutineName(String routineName) {
		this.routineName = routineName;
	}

	public String getRoutineDescription() {
		return routineDescription;
	}

	public void setRoutineDescription(String routineDescription) {
		this.routineDescription = routineDescription;
	}	
	


	  public User getUser() {
	        return user;
	    }

	    public void setUser(User user) {
	        this.user = user;
	    }
	    
	    // Getter and setter methods for tasks
	    public List<Task> getTasks() {
	        return tasks;
	    }

	    public void setTasks(List<Task> tasks) {
	        this.tasks = tasks;
	    }
	
	
}
