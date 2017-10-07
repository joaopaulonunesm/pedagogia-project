package com.pedagogiaproject.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Publication;
import com.pedagogiaproject.repositories.PublicationRepository;

@Service
public class PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;

	public Publication save(Publication publication) {
		return publicationRepository.save(publication);
	}

	public void delete(Long id) {
		publicationRepository.delete(id);
	}

	public Publication findByTitleUrl(String publication) {
		return publicationRepository.findByTitleUrl(publication);
	}

	public List<Publication> findByTopic(String nameTopic) {
		return publicationRepository.findByTopic(nameTopic);
	}

	public List<Publication> findByTitleContaing(String title) {
		return publicationRepository.findByTitleContaining(title);
	}

	public List<Publication> findByAmmountViewGreaterThanOrderByAmmountViewDesc(int greaterThan) {
		return publicationRepository.findByAmmountViewGreaterThanOrderByAmmountViewDesc(greaterThan);
	}

	public List<Publication> findByStarGreaterThanOrderByStarDesc(int greaterThan) {
		return publicationRepository.findByStarGreaterThanOrderByStarDesc(greaterThan);
	}

	public List<Publication> findByOrderByDate(Date date) {
		return publicationRepository.findByOrderByDate(date);
	}

}
