package com.myproject.habitapp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.habitapp.model.Routine;
import com.myproject.habitapp.model.Task;
import com.myproject.habitapp.model.User;
import com.myproject.habitapp.repo.RoutineRepository;

@Service
public class RoutineService {	
	@Autowired
	private RoutineRepository routineRepository;
		
	public List<Routine> getRoutineByUserId(User user) {
	    return routineRepository.findAllByUserId(user.getUserId());
	}

	public void addRoutine(Routine routine) {
		routineRepository.save(routine);		
	}

	public Optional<Routine> getRoutineById(int routineId) {
		return routineRepository.findById(routineId);
	}

	
	public void deleteRoutineById(int routineId) {
		routineRepository.deleteById(routineId);		
	}

	public void updateRoutineById(int routineId, Routine routine) {
	    Optional<Routine> routineOptional = routineRepository.findById(routineId);
	    Routine existingRoutine = routineOptional.orElse(new Routine());
	    
	    existingRoutine.setRoutineName(routine.getRoutineName());
	    existingRoutine.setRoutineDescription(routine.getRoutineDescription());

	    routineRepository.save(existingRoutine);
	}

	public List<Task> getTaskById(int routineId) {
		Optional<Routine> routineOptional = routineRepository.findById(routineId);
		Routine routine = routineOptional.orElse(new Routine());
		
		if (routine.getRoutineId() != 0) {
			return routine.getTasks();
		} else { 
			 return Collections.emptyList();
		}
		
    }

}

