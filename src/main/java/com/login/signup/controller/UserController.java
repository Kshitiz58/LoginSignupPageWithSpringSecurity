package com.login.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.login.signup.model.User;
import com.login.signup.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping({"/","/login"})
	public String getLogin() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "signup";
	}
	
//	@GetMapping("/home")
//	public String getHome() {
//		return "home";
//	}
	
	@PostMapping("/login")
	public String postlogin(@ModelAttribute User user, Model model) {
		User usr = userService.userLogin(user.getUsername(), user.getPassword());
		
		if (usr != null) {
			return "home";
		}
		return "login";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user) {
		userService.userSignup(user);
		return "login";
	}
	
}
