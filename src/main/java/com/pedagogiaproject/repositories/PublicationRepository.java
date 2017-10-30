package com.pedagogiaproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public Publication findByTitleUrl(String publication);

	public List<Publication> findByTopicNameUrl(String topic);

	public List<Publication> findByTitleContainingIgnoreCase(String title);

	public List<Publication> findByOrderByAmmountViewDesc();

	public List<Publication> findByOrderByStarDesc();

	public List<Publication> findByOrderByDate();

	public List<Publication> findByTextContainingIgnoreCase(String word);
}
