package com.apiprojeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiprojeto.models.Login;
import com.apiprojeto.repositories.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public Login save(Login login) {
		return loginRepository.save(login);
	}
}
