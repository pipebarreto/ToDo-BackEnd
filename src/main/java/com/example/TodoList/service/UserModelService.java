package com.example.TodoList.service;


import java.util.List;
import com.example.TodoList.domain.UserModel;

public interface UserModelService {
	
	UserModel saveUser(UserModel user);

	UserModel updateUser(Long id, UserModel user);
	
	List <UserModel> getUsers();
	
}
