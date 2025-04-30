package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("Select c FROM Comment c WHERE c.post.id = :post")
    List<Comment> getCommentsByPost(@Param("post") Long id);
}
