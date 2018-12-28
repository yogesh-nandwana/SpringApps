package com.na.todo.service;

import com.na.todo.model.User;

public interface ILoginService {
	public User authenticate(User user);
}
