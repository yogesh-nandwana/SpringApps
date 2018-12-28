package com.na.todo.dao;

import java.util.List;

import com.na.todo.model.Todo;

public interface ITodoDAO {
	public void save(Todo todo);
	//public void update(Todo todo);
	public void delete(Todo todo);
	
	public List<Todo> findAll();
	public Todo findBySrNo(int srNo);
	public Todo findByText(String todoTxt);
	
	public boolean isTodoExists(String text); 
	
	public int findMaxSrNo();
}