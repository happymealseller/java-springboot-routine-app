package com.myproject.habitapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.habitapp.model.User;
import com.myproject.habitapp.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
	
	@PostMapping("/signup")
	public String processSignup(@ModelAttribute("user") User user, Model model) {
		try {
			userService.addUser(user);
			model.addAttribute("error", "You account has been created!");
			return "/login";
		} catch (DataIntegrityViolationException e) {
			model.addAttribute("error", "Email has been used, please login instead.");
	        return "login";
		}
	}	
	    
    @GetMapping("/login")
    public String showLogin(Model model) {    
    	model.addAttribute("error", "Log in to get started!");
        return "login";
    }
    
    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email, 
    							@RequestParam("password") String password, 
    							Model model,
    							HttpSession session) {       
    Optional<User> userOptional = userService.getUserByEmail(email);
    User user = userOptional.orElse(new User());     
   
    	if (user.getUserEmail() == null) {
    		model.addAttribute("error", "User does not exist!");
    		return "login";
        } else if (user.getUserPassword() != null && user.getUserPassword().equals(password)) {
        	session.setAttribute("user", user);
        	return "redirect:/dashboard";
        } else {
        	model.addAttribute("error", "Login details does not match.");
        	return "login";
        }
    }	
    
    @GetMapping("/logout")
    public String processLogout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }
    
    
    
}