package com.pedagogiaproject.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedagogiaproject.models.Publication;
import com.pedagogiaproject.repositories.PublicationRepository;

@Service
@RequiredArgsConstructor
public class PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;

	public Publication save(Publication publication) {
		return publicationRepository.save(publication);
	}

	public void delete(Long id) {
		publicationRepository.deleteById(id);
	}

	public Publication findOne(Long id) {
		return publicationRepository.findById(id).orElseThrow(() -> new RuntimeException("Publicação por ID não encontrada. Id: " + id));
	}

	public Publication findByTitleUrl(String publication) {
		return publicationRepository.findByTitleUrl(publication);
	}

	public List<Publication> findByTopicNameUrl(String nameTopic) {
		return publicationRepository.findByTopicNameUrl(nameTopic);
	}

	public List<Publication> findByTitleContaingIgnoreCase(String title) {
		return publicationRepository.findByTitleContainingIgnoreCase(title);
	}

	public List<Publication> findByTextContaingIgnoreCase(String word) {
		return publicationRepository.findByTextContainingIgnoreCase(word);
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