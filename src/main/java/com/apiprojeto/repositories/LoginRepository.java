package com.apiprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiprojeto.models.Login;


public interface LoginRepository extends JpaRepository<Login, Long> {

}
