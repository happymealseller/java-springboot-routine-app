package com.myproject.habitapp.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myproject.habitapp.model.Routine;
import com.myproject.habitapp.model.Task;

import com.myproject.habitapp.service.RoutineService;
import com.myproject.habitapp.service.TaskService;

@Controller
public class TaskController {	
	@Autowired
	private TaskService taskService;	
	@Autowired
	private RoutineService routineService;	
	
	@PostMapping("/routines/{id}/addtask")
	public String addTask(@ModelAttribute("task") Task task, @PathVariable("id") int routineId) {
		Optional<Routine> routineOptinal = routineService.getRoutineById(routineId);
		Routine routine = routineOptinal.orElse(new Routine());		
		if (routine.getRoutineId() != 0) {
			//task.setTaskOrder(routine); count task by id
			task.setTaskStatus("incomplete");
			task.setRoutine(routine);
			taskService.addTask(task);	
		}				
		return "redirect:/routines/{id}";
	}		

	@PostMapping("/routines/{id}/deletetask/{taskId}")
	public String deleteTask(@ModelAttribute("task") Task task, @PathVariable("id") int routineId, @PathVariable("taskId") int taskId) {
		Optional<Routine> routineOptinal = routineService.getRoutineById(routineId);
		Routine routine = routineOptinal.orElse(new Routine());		
		if (routine.getRoutineId() != 0) {			
			taskService.deleteTaskById(taskId);	
		}				
		return "redirect:/routines/{id}";
	}		
}
