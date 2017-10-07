package com.pedagogiaproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Comment;
import com.pedagogiaproject.repositories.CommentRepository;

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
