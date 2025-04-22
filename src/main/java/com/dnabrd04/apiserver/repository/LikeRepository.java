package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Like;
import com.dnabrd04.apiserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Long countByPost(Long postId);
    void deleteByUserIdAndPostId(Long userId, Long postId);
}
