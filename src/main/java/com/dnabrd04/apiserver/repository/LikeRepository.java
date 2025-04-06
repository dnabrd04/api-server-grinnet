package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
