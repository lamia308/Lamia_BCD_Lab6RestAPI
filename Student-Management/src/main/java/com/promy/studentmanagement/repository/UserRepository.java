package com.promy.studentmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promy.studentmanagement.entity.User;

public interface UserRepository extends JpaRepository <User, Integer>{
	
	public User findByUsername(String username);

}
