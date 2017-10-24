package com.pedagogiaproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedagogiaproject.models.Login;
import com.pedagogiaproject.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/logins/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> saveLogin(@RequestBody Login login, @PathVariable Long id) {

		String userCurrent = loginService.findOne(id).getUser();

		String passwordCurrent = loginService.findOne(id).getPassword();

		if (login.getUser() == null || login.getUser().isEmpty() || login.getUser().equals(userCurrent)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (login.getPassword() == null || login.getPassword().isEmpty()
				|| login.getPassword().equals(passwordCurrent)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
