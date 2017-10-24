package com.pedagogiaproject.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedagogiaproject.models.Comment;
import com.pedagogiaproject.models.Publication;
import com.pedagogiaproject.services.CommentService;
import com.pedagogiaproject.services.PublicationService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private PublicationService publicationService;

	@RequestMapping(value = "/comments/publication/{titleUrl}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Publication> postComment(@RequestBody Comment comment, @PathVariable String titleUrl) {

		Publication publication = publicationService.findByTitleUrl(titleUrl);

		if (publication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (comment.getText().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		comment.setDate(new Date());

		commentService.save(comment);

		publication.getComments().add(comment);

		publicationService.save(publication);

		return new ResponseEntity<>(publication, HttpStatus.OK);
	}

	@RequestMapping(value = "/comments/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Comment> deleteComment(@PathVariable Long id) {

		commentService.deleteCommentInPublication(id);

		commentService.delete(id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
