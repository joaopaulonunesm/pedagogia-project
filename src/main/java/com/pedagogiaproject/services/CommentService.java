package com.pedagogiaproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Comment;
import com.pedagogiaproject.models.Publication;
import com.pedagogiaproject.repositories.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PublicationService publicationService;

	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}

	public void delete(Long id) {
		commentRepository.delete(id);
	}

	public void deleteAllByPublication(Publication publication) {

		for (Comment comment : publication.getComments()) {
			delete(comment.getId());
		}
	}

	public void deleteCommentInPublication(Long id) {

		for (Publication publication : publicationService.findByOrderByDate()) {

			for (Comment comment : publication.getComments()) {

				if (comment.getId() == id) {

					publication.getComments().remove(comment);

				}
			}
		}
	}

	public List<Comment> findAll() {
		return commentRepository.findAll();
	}

}
