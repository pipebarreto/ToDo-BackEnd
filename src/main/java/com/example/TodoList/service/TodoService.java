package com.example.TodoList.service;

import java.util.List;
import java.util.Optional;
import com.example.TodoList.domain.Todo;

public interface TodoService {
	
	List <Todo> getTodos();

	Optional<Todo> findById(Long id);
	
	Todo saveTodo (Todo todo);
	
	Todo updateTodo (Long id, Todo todo);
	
	void deleteTodo (Long id);

}
