package com.pedagogiaproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

	Topic findByNameUrl(String nameUrl);

	Topic findByNameIgnoreCase(String name);

	List<Topic> findByNameContaining(String name);

	List<Topic> findByOrderByAmmountPublicationDesc();

}
