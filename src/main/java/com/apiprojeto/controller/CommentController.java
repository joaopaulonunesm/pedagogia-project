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

import com.apiprojeto.models.Comment;
import com.apiprojeto.models.Publication;
import com.apiprojeto.services.CommentService;




@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	private Publication publication;
	
	// POST para Criar
		@RequestMapping(value="/comments", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Comment> salvar(@RequestBody Comment comment){
			if(!comment.equals("")&&Comment.getDate()==null){
				//OBS: o que devo retornar ?????
				return null;
			}
			return new ResponseEntity<>(commentService.save(comment), HttpStatus.OK);
		}
		
		@RequestMapping(value="/comments/{id}", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Comment> delete(@PathVariable Long id){
			publication.getComments().remove(id);
			commentService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
}
