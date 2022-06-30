package com.example.TodoList.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.TodoList.domain.StatusName;
import com.example.TodoList.domain.Todo;


public interface TodoRepository extends JpaRepository<Todo, Long> {
	
	List<Todo> findByStatus (StatusName status);

}

