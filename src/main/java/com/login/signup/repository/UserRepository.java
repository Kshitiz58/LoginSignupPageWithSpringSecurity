package com.login.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.signup.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsernameAndPassword(String username, String password);
}
