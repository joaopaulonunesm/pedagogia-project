package com.apiprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apiprojeto.models.Login;
import com.apiprojeto.services.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/logins/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Login> alterarIngrediente(@RequestBody Login login, @PathVariable Long id){
	String userAtual = loginService.findOne(id).getUser();
	String passwordAtual = loginService.findOne(id).getPassword();
	if(!login.getUser().equals("")&&login.getUser()!=userAtual&&!login.getPassword().equals("")&&login.getPassword()!=passwordAtual){
		login.setId(id);
		return new ResponseEntity<>(loginService.save(login), HttpStatus.OK);
	}else{
		//OBS: O que vou retornar??
		return null;
	}
	
	
	
	}

	
	
	
}
	

	
