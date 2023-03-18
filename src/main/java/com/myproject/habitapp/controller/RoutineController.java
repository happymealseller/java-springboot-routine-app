package com.myproject.habitapp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.myproject.habitapp.model.Routine;
import com.myproject.habitapp.model.Task;
import com.myproject.habitapp.model.User;
import com.myproject.habitapp.service.RoutineService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoutineController {	
	@Autowired
	private RoutineService routineService;
	
	@GetMapping("/dashboard")
	public String showRoutine(HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");		
		Optional<User> userOptional = Optional.ofNullable(user); 
        user = userOptional.orElse(new User());    
        
		List<Routine> routines = routineService.getRoutineByUserId(user);
		
		String today = LocalDate.now().toString();		
		model.addAttribute("user", user);
		model.addAttribute("routines", routines);
		model.addAttribute("today", today);		
		return "dashboard";		
	}
	
	@PostMapping("/dashboard")
	public String addRoutine(@ModelAttribute("routine") Routine routine, HttpSession session) {		
		User user = (User) session.getAttribute("user");
		routine.setUser(user);
		routineService.addRoutine(routine);
		return "redirect:/dashboard";		
	}	
	
	@GetMapping("/routines/{id}")
	public String viewRoutine(@PathVariable("id") int routineId, Model model) {
		Optional<Routine> routineOptional = routineService.getRoutineById(routineId);
		Routine routine = routineOptional.orElse(new Routine());  		
		List<Task> tasks = routineService.getTaskById(routineId);
		
		if (routine.getRoutineId() == 0) {
        	return "redirect:/dashboard";
        } else {
        	 model.addAttribute("routine", routine);
        	 model.addAttribute("tasks", tasks);
        	 return "routine-display";	
        }							
	}
		
	@PostMapping("/routines/{id}/edit")
	public String editRoutine(@ModelAttribute("routine") Routine routine, @PathVariable("id") int routineId) {		
	    routineService.updateRoutineById(routineId, routine);
	    return "redirect:/dashboard";
	}
	
		
	@PostMapping("/routines/{id}/delete")
	public String deleteRoutine(@PathVariable("id") int routineId, Model model) {		
		try {
			routineService.deleteRoutineById(routineId);
			return "redirect:/dashboard";
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "");
			return "redirect:/routines/{id}?error=Unable to delete routines with active tasks!";

		}
	}	
}
