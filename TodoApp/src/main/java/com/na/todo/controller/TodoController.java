package com.na.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.na.todo.exception.TodoAlredyExistsException;
import com.na.todo.model.Todo;
import com.na.todo.service.ITodoService;

@RestController
public class TodoController {
	@Autowired
	private ITodoService todoService;
	
	
	@PostMapping("/todo")
	public void createTodo(@RequestBody Todo todo) throws TodoAlredyExistsException {
		todoService.createTodo(todo);
	}

	@PutMapping("/todo")
	public void updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
	}

	@GetMapping("/todo")
	public List<Todo> getTodos(){
		return todoService.getAllTodos();
	}

	@GetMapping("/todo/srNo")
	public int getLatestSrNo(){
		return todoService.getLatestSrNo();
	}

	@GetMapping("/todo/{text}")
	public boolean isTodoExists(@PathVariable String text){
		return todoService.getTodo(text)==null?false:true;
	}

	@DeleteMapping("/todo/{srNo}")// not sure why its not complaining for uncaught checked exception
	public void deleteTodo(@PathVariable int srNo){
		todoService.deleteTodo(srNo);
	}
}