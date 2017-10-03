package com.apiprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiprojeto.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
