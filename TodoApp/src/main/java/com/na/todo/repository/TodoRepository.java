package com.na.todo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.na.todo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	Todo findByText(String text);
	Todo findBySrNo(Integer srNo);
	
	@Query("select max(srNo) from Todo")
	Integer findMaxSrNo();
	//List<Todo> findByUserId(int userId);
}