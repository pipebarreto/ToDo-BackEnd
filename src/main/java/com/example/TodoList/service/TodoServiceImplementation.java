package com.example.TodoList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.TodoList.domain.Todo;
import com.example.TodoList.repository.TodoRepository;


@Service
public class TodoServiceImplementation implements TodoService {

	private final TodoRepository todoRepository;
	
	public TodoServiceImplementation (TodoRepository todoRepository) {
		this.todoRepository=todoRepository;
	}
	
	@Override
	public List<Todo> getTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Optional<Todo> findById(Long id) {
		return  todoRepository.findById(id);
	}


	@Override
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo updateTodo(Long id, Todo todo) {		
		if(todoRepository.findById(id).isEmpty()) {
			return null;
		}
		else {
		todo.setId(id);
		return todoRepository.save(todo);
		}
	}

	@Override
	public void deleteTodo(Long id) {
		todoRepository.deleteById(id);
	}
	
}
