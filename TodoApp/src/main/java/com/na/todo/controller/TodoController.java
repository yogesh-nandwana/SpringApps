package com.na.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.na.todo.exception.NoSuchTodoException;
import com.na.todo.exception.TodoAlredyExistsException;
import com.na.todo.model.Todo;
import com.na.todo.service.ITodoService;

@RestController
public class TodoController {
	@Autowired
	private ITodoService todoService;
	
	
	@PostMapping("/todos")
	private void createTodo(@RequestBody Todo todo) throws TodoAlredyExistsException {
		todoService.createTodo(todo);
	}

	@PutMapping("/todos")
	private void updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo);
	}

	@GetMapping("/todos")
	private List<Todo> getTodos(){
		return todoService.getAllTodos();
		
	}

	@GetMapping("/todos/srno/max")
	private int getMaxSrNo(){
		return todoService.getMaxSrNo();
	}

	@GetMapping("/todos/{text}")
	private boolean isTodoExists(@PathVariable String text){
		return todoService.getTodo(text)==null?false:true;
	}

	@DeleteMapping("/todos/{srNo}")// not sure why its not complaining for uncaught checked exception
	private void deleteTodo(@PathVariable int srNo){
		todoService.deleteTodo(srNo);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
	private void todoAlreadyExistsExceptionHandler(TodoAlredyExistsException e){}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	private void todoAlreadyExistsExceptionHandler(NoSuchTodoException e){}
}