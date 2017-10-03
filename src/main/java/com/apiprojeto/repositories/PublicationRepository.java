package com.apiprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiprojeto.models.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public void findByTitleUrl();
	public void findByAssunto();
	public void findByTitleContaing();
	public void findByAmmountViewGreaterThanOrderByAmmountViewDesc(int i);
	public void findByStarGreaterThanOrderByStarDesc(int i);
	public void findByOrderByDate();
}
