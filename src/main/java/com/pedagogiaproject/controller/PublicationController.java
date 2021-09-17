package com.pedagogiaproject.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedagogiaproject.models.Publication;
import com.pedagogiaproject.models.Topic;
import com.pedagogiaproject.services.CommentService;
import com.pedagogiaproject.services.PublicationService;
import com.pedagogiaproject.services.TopicService;

@Controller
@RequiredArgsConstructor
public class PublicationController {

	private final PublicationService publicationService;
	private final TopicService topicService;
	private final CommentService commentService;

	@RequestMapping(value = "/publications", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Publication> postPublication(@RequestBody Publication publication) throws ServletException {

		if (publication.getSummary().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (publication.getTitle().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (publication.getTopic() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Topic topic = topicService.findOne(publication.getTopic().getId());

		if (topic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (publication.getPhotoUrl() == null && publication.getVideoUrl() == null && publication.getText() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if ((publication.getPhotoUrl() != null && publication.getPhotoUrl().isEmpty())
				&& (publication.getVideoUrl() != null && publication.getVideoUrl().isEmpty())
				&& (publication.getText() != null && publication.getText().isEmpty())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		publication.setDate(new Date());
		publication.setAmmountView(0);
		publication.setTitleUrl(publicationService.titleToTitleUrl(publication));

		topic.setAmmountPublication(topic.getAmmountPublication() + 1);
		topicService.save(topic);

		return new ResponseEntity<>(publicationService.save(publication), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/publications/{titleUrl}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Publication> putPublication(@RequestBody Publication publication,
			@PathVariable String titleUrl) {

		Publication currentPublication = publicationService.findByTitleUrl(titleUrl);

		if (currentPublication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (publication.getSummary().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (publication.getTitle().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (publication.getTopic() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Topic topic = topicService.findByNameIgnoreCase(publication.getTopic().getName());

		if (topic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (publication.getPhotoUrl().isEmpty() && publication.getText().isEmpty()
				&& publication.getVideoUrl().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		publication.setTitleUrl(publicationService.titleToTitleUrl(publication));

		publication.setId(currentPublication.getId());

		return new ResponseEntity<>(publicationService.save(publication), HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/{titleUrl}", method = RequestMethod.DELETE)
	public ResponseEntity<Publication> deletePublication(@PathVariable String titleUrl) {

		Publication publication = publicationService.findByTitleUrl(titleUrl);

		if (publication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		commentService.deleteAllByPublication(publication);

		Topic topic = publication.getTopic();
		topic.setAmmountPublication(topic.getAmmountPublication() - 1);
		topicService.save(topic);

		publicationService.delete(publication.getId());

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/publications/id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Publication> deletePublication(@PathVariable Long id) {

		Publication publication = publicationService.findOne(id);

		if (publication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		commentService.deleteAllByPublication(publication);

		Topic topic = publication.getTopic();
		topic.setAmmountPublication(topic.getAmmountPublication() - 1);
		topicService.save(topic);

		publicationService.delete(publication.getId());

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/title/url/{titleUrl}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Publication> getOnePublication(@PathVariable String titleUrl) {

		Publication publication = publicationService.findByTitleUrl(titleUrl);

		if (publication == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(publication, HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/containg/{word}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Set<Publication>> getPublicationByWord(@PathVariable String word) {

		List<Publication> byTitle = publicationService.findByTitleContaingIgnoreCase(word);

		List<Publication> byText = publicationService.findByTextContaingIgnoreCase(word);

		List<Publication> byTopic = new ArrayList<>();

		Topic topic = topicService.findByNameIgnoreCase(word);

		if (topic != null) {
			byTopic = publicationService.findByTopicNameUrl(topic.getName());
		}

		Set<Publication> publications = new HashSet<>();
		publications.addAll(byTopic);
		publications.addAll(byTitle);
		publications.addAll(byText);

		return new ResponseEntity<>(publications, HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/topic/{topic}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Publication>> getPublicationByTopic(@PathVariable String topic) {

		return new ResponseEntity<>(publicationService.findByTopicNameUrl(topic), HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/view", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Publication>> getPublicationByView() {

		return new ResponseEntity<>(publicationService.findByAmmountView(), HttpStatus.OK);
	}

	@RequestMapping(value = "/publications/star", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Publication>> getPublicationByStar() {

		return new ResponseEntity<>(publicationService.findByOrderByStarDesc(), HttpStatus.OK);
	}

	@RequestMapping(value = "/publications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Publication>> getPublications() {

		return new ResponseEntity<>(publicationService.findByOrderByDate(), HttpStatus.OK);
	}

}
