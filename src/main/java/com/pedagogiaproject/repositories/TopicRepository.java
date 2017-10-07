package com.pedagogiaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	public void findByNameContaining(String name);

	public void findByNameUrl(String nameUrl);

	public void findByAmmountPublicationGreaterThanOrderByAmmountPublicationDesc(int greaterThan);
}
