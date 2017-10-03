package com.apiprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apiprojeto.models.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
     public void findByNameContaing();
     public void findByNameUrl();
     public void findByAmmountPublicationGreaterThanOrderByAmmountPublicationDesc(int i);
}
