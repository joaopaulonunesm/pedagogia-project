package com.apiprojeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiprojeto.models.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public Publication findByTitleUrl(String publication);
	public void findByTopic();
	public List<Publication> findByTitleContaing();
	public List<Publication> findByAmmountViewGreaterThanOrderByAmmountViewDesc(int i);
	public List<Publication> findByStarGreaterThanOrderByStarDesc(int i);
	public List<Publication> findByOrderByDate();
}
