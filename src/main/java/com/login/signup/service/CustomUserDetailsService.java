package com.login.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.signup.model.MyUser;
import com.login.signup.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = userRepo.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found: " +username));
		
		return User.builder()
				.username(user.getUsername())
				.password(user.getPassword())
				.roles(getRoles(user))
				.build();
	}
	public String [] getRoles (MyUser user) {
		if(user.getRole() == null || user.getRole().isEmpty()) {
			return new String[] {"USER"};
		}
		return user.getRole().split(",");
	}

}
