package com.login.signup.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.signup.model.MyUser;


public interface UserRepository extends JpaRepository<MyUser, Integer>{

	Optional<MyUser> findByUsername(String username);
}
