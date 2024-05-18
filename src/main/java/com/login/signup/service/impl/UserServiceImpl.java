package com.login.signup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.signup.model.User;
import com.login.signup.repository.UserRepository;
import com.login.signup.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User userLogin(String username, String password) {
		
		return userRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public void userSignup(User user) {
		userRepo.save(user);
		
	}

}
