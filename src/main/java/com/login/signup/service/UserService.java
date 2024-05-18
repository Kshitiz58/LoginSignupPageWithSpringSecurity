package com.login.signup.service;

import com.login.signup.model.User;

public interface UserService {
	
	User userLogin(String username, String password);
	
	void userSignup(User user);

}
