package com.na.todo.exception;

public class NoSuchTodoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoSuchTodoException(int srNo) {
		super("No such todo with srNo:"+srNo);
	}
}