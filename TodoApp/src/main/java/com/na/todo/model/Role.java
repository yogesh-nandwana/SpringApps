package com.na.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	@Id
	private Integer id;

	@Column(name="ROLE_NAME",unique=true)
	private String role;

	@Column(name="IS_CREATE_ALLOWED",nullable=false)
	private Character isCreateAllowed;
	
	@Column(name="IS_UPDATE_ALLOWED",nullable=false)
	private Character isUpdateAllowed;

	@Column(name="IS_DELETE_ALLOWED",nullable=false)
	private Character isDeleteAllowed;

	public Role() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Character getIsCreateAllowed() {
		return isCreateAllowed;
	}

	public void setIsCreateAllowed(Character isCreateAllowed) {
		this.isCreateAllowed = isCreateAllowed;
	}

	public Character getIsDeleteAllowed() {
		return isDeleteAllowed;
	}

	public void setIsDeleteAllowed(Character isDeleteAllowed) {
		this.isDeleteAllowed = isDeleteAllowed;
	}
	

	public Character getIsUpdateAllowed() {
		return isUpdateAllowed;
	}

	public void setIsUpdateAllowed(Character isUpdateAllowed) {
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