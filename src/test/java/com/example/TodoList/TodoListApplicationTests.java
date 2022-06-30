package com.example.TodoList;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.TodoList.domain.StatusName;
import com.example.TodoList.repository.TodoRepository;
import com.example.TodoList.service.TodoService;
import com.example.TodoList.service.UserModelService;
import com.example.TodoList.domain.Todo;
import com.example.TodoList.domain.UserModel;

@SpringBootTest
class TodoListApplicationTests {
	
	@Autowired private TodoRepository todoRepository;
	
	
	@Autowired private TodoService todoService;
	
	@Autowired private UserModelService userService;

	
	
	@Test
	public void CreateTodo() {		
		Todo todo = new com.example.TodoList.domain.Todo
				("study", "Study", "Java", StatusName.OnGoing);	
		todoService.saveTodo(todo);
		assertThat(todo.getId()).isNotNull();
	}
	
	
	
	@SuppressWarnings("unused")
	@Test
	public void DeleteTodo() {			
		Todo todo = new Todo();	
		todoService.saveTodo(todo);	
		int count1=0;
		int count2=0;		
		for (Todo todo1: todoRepository.findAll()) {
			count1++;
				};
								
		todoService.deleteTodo(todo.getId());	
		
		for (Todo todo2: todoRepository.findAll()) {
			count2++;
				};			
				
		assertThat(count1).isEqualTo(count2+1);	
	}
	
	
	
	@Test
	public void CreateUser() {		
		UserModel user = new UserModel("juha@hotmail.com","testing");
		userService.saveUser(user);
		assertThat(user.getId()).isNotNull();
	}
	
	
	
	@Test
	public void FindTodo() {		
		Todo todo = new Todo("integrify", "integrify","integrify", StatusName.OnGoing);	
		todoService.saveTodo(todo);
		
		Optional<Todo> todo1=(todoService.findById(todo.getId()));
		
		assertThat(todo.getName()).isEqualTo(todo1.get().getName());
	}
	
	
	
	

}
