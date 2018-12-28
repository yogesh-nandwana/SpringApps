package com.na.todo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.na.todo.model.Todo;

@Repository
public class TodoInMemoryRepository {
	@Autowired
	private ITodoDAO todoDAO;

	public void create(Todo todo) {
		todoDAO.save(todo);
	}

	public void update(Todo todo) {
		todoDAO.save(todo);
	}

	public List<Todo> get() {
		return todoDAO.findAll();
	}

	public Todo get(int srNo) {
		return todoDAO.findBySrNo(srNo);
	}

	public Todo get(String todoTxt) {
		return todoDAO.findByText(todoTxt);
	}

	public void delete(Todo todo) {
		todoDAO.delete(todo);
	}

	public int getLatestSrNo() {
		return todoDAO.findMaxSrNo();
	}

	public boolean isTodoExists(String text) {
		return todoDAO.isTodoExists(text);
	}
}
