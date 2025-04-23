package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Like;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.id_post = :postId")
    Long countByPost(@Param("postId") Long postId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Like l WHERE l.user.id_user = :userId AND l.post.id_post = :postId")
    void deleteByUserIdAndPost(@Param("userId") Long userId, @Param("postId") Long postId);
}
