package com.example.TodoList.service;

import java.util.List;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.TodoList.domain.UserModel;
import com.example.TodoList.repository.UserRepository;


@Service
public class UserModelServiceImp implements UserModelService, UserDetailsService {
	
	private final UserRepository userRepository;
	
	
	
	public UserModelServiceImp (UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	    
	
	@Override
	public UserModel saveUser(UserModel user) {
		return userRepository.save(user);
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws
		UsernameNotFoundException {
		UserModel curruser = userRepository.findByEmail(email);
		UserDetails user = new org.springframework.security.core.userdetails.User(email, curruser.getPassword(),
				AuthorityUtils.createAuthorityList(curruser.getEmail()));
		return user;
		}

	@Override
	public UserModel updateUser (Long id, UserModel user) {
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public List<UserModel> getUsers() {	
		return userRepository.findAll();
	}
	
	
}
