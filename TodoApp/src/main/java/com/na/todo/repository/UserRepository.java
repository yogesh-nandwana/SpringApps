package com.na.todo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.na.todo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUserId(String userId);
}