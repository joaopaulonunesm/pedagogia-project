package com.pedagogiaproject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Topic;
import com.pedagogiaproject.repositories.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public Topic save(Topic topic) {
		return topicRepository.save(topic);
	}

	public void delete(Long id) {
		topicRepository.delete(id);
	}

	public Topic findOne(Long id) {
		return topicRepository.findOne(id);
	}

	public List<Topic> findAll() {
		return topicRepository.findAll();
	}

	public Topic findByNameIgnoreCase(String name) {
		return topicRepository.findByNameIgnoreCase(name);
	}

	public Topic findByNameUrl(String nameUrl) {
		return topicRepository.findByNameUrl(nameUrl);
	}

	public List<Topic> findByNameContaining(String name) {
		return topicRepository.findByNameContaining(name);
	}

	public List<Topic> findByAmmountPublicationGreaterThanOrderByAmmountPublicationDesc() {
		return topicRepository.findByOrderByAmmountPublicationDesc();
	}

	public String nameToNameUrl(Topic topic) {

		String nameUrl = topic.getName().replaceAll(" ", "-").replaceAll("[ãâàáä]", "a").replaceAll("[êèéë]", "e")
				.replaceAll("[îìíï]", "i").replaceAll("[õôòóö]", "o").replaceAll("[ûúùü]", "u")
				.replaceAll("[ÃÂÀÁÄ]", "A").replaceAll("[ÊÈÉË]", "E").replaceAll("[ÎÌÍÏ]", "I")
				.replaceAll("[ÕÔÒÓÖ]", "O").replaceAll("[ÛÙÚÜ]", "U").replace('ç', 'c').replace('Ç', 'C')
				.replace('ñ', 'n').replace('Ñ', 'N');

		nameUrl = nameUrl.toLowerCase() + "-" + topic.hashCode();

		return nameUrl;
	}

}
