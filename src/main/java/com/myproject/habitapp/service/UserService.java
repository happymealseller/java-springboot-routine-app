package com.myproject.habitapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.habitapp.model.User;
import com.myproject.habitapp.repo.UserRepository;

@Service
public class UserService {	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}

	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByUserEmail(email);
	}		
}


