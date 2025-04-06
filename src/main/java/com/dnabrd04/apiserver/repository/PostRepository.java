package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
