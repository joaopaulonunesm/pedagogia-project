package com.pedagogiaproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	@Id
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "LOGINSEQ", sequenceName = "LOGIN_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LOGINSEQ")
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
}
