package com.example.TodoList.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TodoList.config.JwtUtil;
import com.example.TodoList.domain.UserModel;
import com.example.TodoList.repository.UserRepository;
import com.example.TodoList.service.UserModelService;

@RestController
public class UserController {
	
	@Autowired
	private UserModelService userDetailsService;
	
    @Autowired
    private AuthenticationManager authManager;
    
    @Autowired private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	

	@PostMapping("/signup")
    public UserModel addUser(@RequestBody UserModel user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		 user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return userDetailsService.saveUser(user);
    }
	
	@PostMapping("/login")
    public Map<String, Object> loginHandler(@RequestBody UserModel user){
        try {
            UsernamePasswordAuthenticationToken authInputToken =
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());

            authManager.authenticate(authInputToken);

            String token = jwtUtil.generateAccessToken(user);

            return Collections.singletonMap("jwt-token", token);
        }catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }
	
	 @PutMapping("/changePassword")
    public UserModel changePassword(@RequestBody String password){	 
        String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel user = userRepository.findByEmail(email);
		user.setPassword(passwordEncoder.encode(password));
        return userDetailsService.updateUser(user.getId(), user);      
        
    }
	 
	 //For testing only
	 @GetMapping(value="/users")
	    public List<UserModel> getTodos() {	
	        return userDetailsService.getUsers();
	    } 
}
