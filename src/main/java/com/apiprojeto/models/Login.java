package com.apiprojeto.models;

import javax.persistence.Column;

public class Login {

	private Long id;
	@Column(nullable=false)
	private String user;
	@Column(nullable=false)
	private String password;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
