package com.apiprojeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiprojeto.models.Comment;
import com.apiprojeto.repositories.CommentRepository;


@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	public void delete(Long id) {
		commentRepository.delete(id);
		
	}

}
