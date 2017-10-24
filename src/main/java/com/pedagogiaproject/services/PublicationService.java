package com.pedagogiaproject.services;

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

	public List<Publication> findByTopicName(String nameTopic) {
		return publicationRepository.findByTopicName(nameTopic);
	}

	public List<Publication> findByTitleContaing(String title) {
		return publicationRepository.findByTitleContaining(title);
	}

	public List<Publication> findByAmmountView() {
		return publicationRepository.findByOrderByAmmountViewDesc();
	}

	public List<Publication> findByOrderByStarDesc() {
		return publicationRepository.findByOrderByStarDesc();
	}

	public List<Publication> findByOrderByDate() {
		return publicationRepository.findByOrderByDate();
	}

	public String titleToTitleUrl(Publication publication) {

		String urlTitle = publication.getTitle().replaceAll(" ", "-").replaceAll("[ãâàáä]", "a")
				.replaceAll("[êèéë]", "e").replaceAll("[îìíï]", "i").replaceAll("[õôòóö]", "o")
				.replaceAll("[ûúùü]", "u").replaceAll("[ÃÂÀÁÄ]", "A").replaceAll("[ÊÈÉË]", "E")
				.replaceAll("[ÎÌÍÏ]", "I").replaceAll("[ÕÔÒÓÖ]", "O").replaceAll("[ÛÙÚÜ]", "U").replace('ç', 'c')
				.replace('Ç', 'C').replace('ñ', 'n').replace('Ñ', 'N');

		urlTitle = urlTitle.toLowerCase() + "-" + publication.hashCode();

		return urlTitle;
	}

}
