package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.dto.PostDTO;
import com.dnabrd04.apiserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("""
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p.id_post, pr, p.text, p.privacity, p.creation_date, u, COUNT(l.post.id_post), COUNT(c))
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            WHERE u.id_user = :idUser
            GROUP BY p.id_post, u, p.text, p.privacity, p.creation_date
            """)
    List<PostDTO> findByUserId(@Param("idUser") Long idUser);

    @Query("""
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p.id_post, pr, p.text, p.privacity, p.creation_date, u, COUNT(l.post.id_post), COUNT(c))
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            GROUP BY p.id_post, u, p.post, p.text, p.privacity, p.creation_date
            """)
    List<PostDTO> findAllPosts();

    @Query("""
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p.id_post, pr, p.text, p.privacity, p.creation_date, u, COUNT(l.post.id_post), COUNT(c))
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            WHERE p.id_post = :idPost
            GROUP BY p.id_post
            """)
    PostDTO findPostById(@Param("idPost") Long id);
}
