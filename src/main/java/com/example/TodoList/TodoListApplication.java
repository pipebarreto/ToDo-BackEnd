package com.example.TodoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.TodoList.domain.StatusName;
import com.example.TodoList.domain.Todo;
import com.example.TodoList.domain.UserModel;
import com.example.TodoList.repository.TodoRepository;
import com.example.TodoList.repository.UserRepository;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner demo(TodoRepository todorepository, UserRepository urepository) {
		return (args) -> {
			
			urepository.save(new UserModel("diego@test.com",
					"$2a$10$AkzWFy0xm43MF4MwpPV/2efMNLWgRrjgr1bOUgqBAErGbm4Sj92o."));
				
			todorepository.save(new Todo ("Finish Java Task", "Study", "Java", StatusName.OnGoing));
			todorepository.save(new Todo ("Waiting for response", "Wait", "Java", StatusName.Completed));
			todorepository.save(new Todo ("First day at Integrify", "Start", "Java", StatusName.NotStarted));
			
		};
	}
	
}
