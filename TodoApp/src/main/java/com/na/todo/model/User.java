package com.na.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	private int id;
	
	@Column(name="USER_ID",unique=true)
	private String userId;
	
	private char[] password;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ROLE_ID")
	private Role role;
	
	protected User() {//Not to be used directly
		// //needed to fix Failed to read HTTP message: org.springframework.http.converter.HttpMessageNotReadableException: Could not read document
	}
	
	
	public User(String userId,String password) {
		this.userId = userId;
		this.password = password.toCharArray();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
