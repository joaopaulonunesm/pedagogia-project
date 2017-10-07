package com.pedagogiaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

}
