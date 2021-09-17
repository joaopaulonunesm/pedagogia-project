package com.pedagogiaproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Login;
import com.pedagogiaproject.repositories.LoginRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

	private final LoginRepository loginRepository;

	public Login save(Login login) {
		return loginRepository.save(login);
	}

	public Login findOne() {
		return loginRepository.findAll().get(0);
	}

}
