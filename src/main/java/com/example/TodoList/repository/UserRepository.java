package com.example.TodoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TodoList.domain.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	UserModel findByEmail(String email);
	
} 
