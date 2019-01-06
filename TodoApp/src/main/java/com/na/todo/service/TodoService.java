package com.na.todo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.na.todo.exception.NoSuchTodoException;
import com.na.todo.exception.TodoAlredyExistsException;
import com.na.todo.model.Todo;
import com.na.todo.repository.TodoRepository;

@Service
public class TodoService implements ITodoService {
    private static final Logger logger = Logger.getLogger("TodoService");
	
	@Autowired
	private TodoRepository todoRepo;

	public void createTodo(Todo todo) throws TodoAlredyExistsException {
		if(getTodo(todo.getSrNo())==null){
			todoRepo.save(todo);
		}else {
			throw new TodoAlredyExistsException(todo.getSrNo());
		}
	}

	public void updateTodo(Todo todo) {
		Todo aTodo = getTodo(todo.getSrNo());
		if(aTodo!=null){
			todoRepo.save(todo);
		}else{
			throw new NoSuchTodoException(todo.getSrNo());
		}
	}

	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}

	public Todo getTodo(int srNo) {
		return todoRepo.findOne(srNo);
	}

	@Override
	public Todo getTodo(String todoTxt) {
		return todoRepo.findByText(todoTxt);
	}

	public void deleteTodo(int srNo) throws NoSuchTodoException {
		Todo todo = getTodo(srNo);
		if(todo!=null) {
			todoRepo.delete(todo);
		}else {
			throw new NoSuchTodoException(srNo);
		}
	}

	@Override
	public int getMaxSrNo() {
		Integer maxSrNo = todoRepo.findMaxSrNo();
		if(maxSrNo!=null){
			return maxSrNo.intValue();
		}else{
			logger.warn("No todos in database, returning maxSrNo as 0");
			return 0;
		}
	}

	@Override
	public boolean isTodoExists(String text) {
		Todo found = todoRepo.findByText(text);
		return found!=null?true:false;
	}
}