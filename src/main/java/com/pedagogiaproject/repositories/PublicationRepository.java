package com.pedagogiaproject.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

	public Publication findByTitleUrl(String publication);

	public List<Publication> findByTopic(String topic);

	public List<Publication> findByTitleContaining(String title);

	public List<Publication> findByAmmountViewGreaterThanOrderByAmmountViewDesc(int greaterThan);

	public List<Publication> findByStarGreaterThanOrderByStarDesc(int greaterThan);

	public List<Publication> findByOrderByDate(Date date);
}
