package com.na.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private int id;

	@Column(unique=true)
	private String role;

	@Column(name="IS_CREATE_ALLOWED",nullable=false)
	private char isCreateAllowed;
	
	@Column(name="IS_UPDATE_ALLOWED",nullable=false)
	private char isUpdateAllowed;

	@Column(name="IS_DELETE_ALLOWED",nullable=false)
	private char isDeleteAllowed;

	protected Role() {
		//Not to be used directly
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public char getIsCreateAllowed() {
		return isCreateAllowed;
	}

	public void setIsCreateAllowed(char isCreateAllowed) {
		this.isCreateAllowed = isCreateAllowed;
	}

	public Character getIsDeleteAllowed() {
		return isDeleteAllowed;
	}

	public void setIsDeleteAllowed(char isDeleteAllowed) {
		this.isDeleteAllowed = isDeleteAllowed;
	}
	

	public Character getIsUpdateAllowed() {
		return isUpdateAllowed;
	}

	public void setIsUpdateAllowed(char isUpdateAllowed) {
		this.isUpdateAllowed = isUpdateAllowed;
	}

	@Override
	public String toString() {
		return String
				.format("Role [id=%s, role=%s, isCreateAllowed=%s, isUpdateAllowed=%s, isDeleteAllowed=%s]",
						id, role, isCreateAllowed, isUpdateAllowed,
						isDeleteAllowed);
	}
}