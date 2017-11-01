package com.pedagogiaproject.models;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Login {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "LOGINSEQ", sequenceName = "LOGIN_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LOGINSEQ")
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
