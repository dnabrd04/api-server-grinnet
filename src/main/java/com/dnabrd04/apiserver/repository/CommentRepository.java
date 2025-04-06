package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
