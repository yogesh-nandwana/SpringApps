package com.na.todo.service;

import java.util.List;

import com.na.todo.exception.NoSuchTodoException;
import com.na.todo.exception.TodoAlredyExistsException;
import com.na.todo.model.Todo;

public interface ITodoService {
	
	public void createTodo(Todo todo) throws TodoAlredyExistsException;
	
	public void updateTodo(Todo todo) throws NoSuchTodoException;
	
	public List<Todo> getAllTodos();
	
	public Todo getTodo(String todoTxt);
	
	public void deleteTodo(int srNo) throws NoSuchTodoException;

	public int getMaxSrNo();

	public boolean isTodoExists(String text);
}
