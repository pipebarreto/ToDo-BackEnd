package com.example.TodoList.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.TodoList.domain.StatusName;
import com.example.TodoList.domain.Todo;
import com.example.TodoList.repository.TodoRepository;
import com.example.TodoList.repository.UserRepository;
import com.example.TodoList.service.TodoService;



@RestController
public class TodoController  {
	
	@Autowired
	private TodoService todoService;
	
	@Autowired private UserRepository userRepository;
	
	@Autowired private TodoRepository todoRepository;
	
	
	@GetMapping(value="/todos")
	public List<Todo> findByStatus(@RequestParam(required=false) StatusName status) {
		if (status!=null){
			return todoRepository.findByStatus(status);
		}
		else {
			return todoService.getTodos();

		}
	}

    @GetMapping(value="/todos/{id}")
    public @ResponseBody Optional<Todo> findTodoRest(@PathVariable("id") Long todoId) {	
    	return todoService.findById(todoId);
    }  
    
    
    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
    	String email = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	todo.setOwnerId(userRepository.findByEmail(email).getId());
    	return todoService.saveTodo(todo);
    }
    
    
    @PutMapping(value="/todos/{id}")
	public Todo upateTodo (@PathVariable("id") Long id, @RequestBody Todo todo) {
    	return todoService.updateTodo(id, todo);
	}
    
	
	@DeleteMapping(value="/todos/{id}")
	public void deleteTodos (@PathVariable("id") Long id) {
		todoService.deleteTodo(id);
	}


}
