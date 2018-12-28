package com.na.todo.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.na.todo.model.Todo;

@Repository
public class InMemoryTodoDAO implements ITodoDAO {

	private Map<Integer,Todo> map = new HashMap<>();
	
	public InMemoryTodoDAO() {
		map.put(1, new Todo(1,"todo1"));
		map.put(2, new Todo(2,"todo2"));
		map.put(3, new Todo(3,"todo3"));
	}
	
	@Override
	public void save(Todo todo) {
		//Integer maxSrNo = map.keySet().stream().reduce((currKey,nextKey)->currKey.intValue()>nextKey.intValue()?currKey:nextKey).get();
		map.put(todo.getSrNo(), todo);
	}

	/*@Override
	public void update(Todo todo) {
		map.put(todo.getSrNo(), todo);
	}*/

	@Override
	public List<Todo> findAll() {
		Collection<Todo> values = map.values();
		return new ArrayList<Todo>(values);
	}

	@Override
	public Todo findBySrNo(int srNo) {
		return map.get(srNo);
	}
	
	@Override
	public Todo findByText(String todoTxt) {
		//return map.values().stream().filter(todo -> todo.getText().equals(todoTxt)).findFirst().orElse(null);
		Collection<Todo> values = map.values();
		Iterator<Todo> iterator = values.iterator();
		while(iterator.hasNext()){
			Todo todo = iterator.next();
			if(todoTxt.equals(todo.getText())){
				return todo;
			}
		}
		return null;
	}

	@Override
	public void delete(Todo todo) {
		map.remove(todo.getSrNo());
	}

	@Override
	public int findMaxSrNo() {
		int latestSrNo = Collections.max(map.keySet());
		return latestSrNo;
	}

	@Override
	public boolean isTodoExists(String text) {
		return findByText(text)==null?false:true;
	}
}