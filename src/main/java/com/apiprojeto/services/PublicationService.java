package com.apiprojeto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiprojeto.models.Publication;
import com.apiprojeto.repositories.PublicationRepository;


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
}
