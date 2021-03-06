package com.pedagogiaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedagogiaproject.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
