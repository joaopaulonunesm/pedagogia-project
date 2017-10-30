package com.pedagogiaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pedagogiaproject.models.Topic;
import com.pedagogiaproject.services.TopicService;

@Controller
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping(value = "/topics", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> postTopic(@RequestBody Topic topic) {

		if (topic.getName().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		topic.setAmmountPublication(0);
		topic.setNameUrl(topicService.nameToNameUrl(topic));

		return new ResponseEntity<>(topicService.save(topic), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/topics/{nameUrl}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> putTopic(@RequestBody Topic topic, @PathVariable String nameUrl) {

		Topic currentTopic = topicService.findByNameUrl(nameUrl);

		if (currentTopic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (topic.getName().isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		topic.setNameUrl(topicService.nameToNameUrl(topic));

		topic.setId(currentTopic.getId());

		return new ResponseEntity<>(topicService.save(topic), HttpStatus.OK);
	}

	@RequestMapping(value = "/topics/{nameUrl}", method = RequestMethod.DELETE)
	public ResponseEntity<Topic> deleteTopic(@PathVariable String nameUrl) {

		Topic topic = topicService.findByNameUrl(nameUrl);

		if (topic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (topic.getAmmountPublication() > 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		topicService.delete(topic.getId());

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/topics/name/containg/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopicByNameContaing(@PathVariable String name) {

		return new ResponseEntity<>(topicService.findByNameContaining(name), HttpStatus.OK);
	}

	@RequestMapping(value = "/topics/name/url/{nameUrl}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topic> getTopicByNameUrl(@PathVariable String nameUrl) {

		return new ResponseEntity<>(topicService.findByNameUrl(nameUrl), HttpStatus.OK);
	}

	@RequestMapping(value = "/topics/ammountpublication", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopicByAmmountPublication() {

		return new ResponseEntity<>(topicService.findByAmmountPublicationGreaterThanOrderByAmmountPublicationDesc(), HttpStatus.OK);
	}

}
