package com.apiprojeto.services;

import java.util.List;

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
	public Publication findByTitleUrl(String publication){
		return publicationRepository.findByTitleUrl(publication);
	} 
	public List<Publication> findByTopic(){
		return publicationRepository.findAll();
	}
	public List<Publication> findByTitleContaing(){
		return publicationRepository.findByTitleContaing();
	}
	public List<Publication> findByAmmountViewGreaterThanOrderByAmmountViewDesc(int i){
		return publicationRepository.findByAmmountViewGreaterThanOrderByAmmountViewDesc(i);
	}
	public List<Publication> findByStarGreaterThanOrderByStarDesc(int i){
		return publicationRepository.findByStarGreaterThanOrderByStarDesc(i);
	}
	public List<Publication> findByOrderByDate(){
		return publicationRepository.findByOrderByDate();
	}
	
	
}
