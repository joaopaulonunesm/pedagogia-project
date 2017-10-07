package com.pedagogiaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Login;
import com.pedagogiaproject.repositories.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public Login save(Login login) {
		return loginRepository.save(login);
	}

	public Login findOne(Long id) {
		return loginRepository.findOne(id);
	}

}
