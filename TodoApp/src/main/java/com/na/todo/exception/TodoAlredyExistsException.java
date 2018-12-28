package com.na.todo.exception;

public class TodoAlredyExistsException extends Exception {
	private static final long serialVersionUID = 1L;

	public TodoAlredyExistsException(int srNo) {
		super("Todo with srNo:"+srNo+" already exists!");
	}
	
}
