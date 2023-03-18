package com.myproject.habitapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.habitapp.model.Task;
import com.myproject.habitapp.repo.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;

	public Task addTask(Task task) {
		return taskRepository.save(task);		
	}	

	public void deleteTaskById(int taskId) {
		taskRepository.deleteById(taskId);		
	}

}
