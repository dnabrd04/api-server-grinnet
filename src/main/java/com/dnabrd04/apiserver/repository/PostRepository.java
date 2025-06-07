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
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p, pr,
                (SELECT COUNT(ul) > 0 FROM Like ul WHERE ul.post.idPost = p.idPost AND ul.user.firebaseId = :firebaseUserId)
            )
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            LEFT JOIN p.resources r
            WHERE u.idUser = :idUser
            GROUP BY p.idPost, u, p.post, p.text, p.privacity, p.creation_date
            """)
    List<PostDTO> findByUserIdWithLikeStatus(@Param("idUser") Long idUser, @Param("firebaseUserId") String currentUser);

    @Query("""
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p, pr,
                (SELECT COUNT(ul) > 0 FROM Like ul WHERE ul.post.idPost = p.idPost AND ul.user.firebaseId = :firebaseUserId)
            )
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            LEFT JOIN p.resources r
            GROUP BY p.idPost, u, p.post, p.text, p.privacity, p.creation_date
            """)
    List<PostDTO> findAllPostsWithLikeStatus(@Param("firebaseUserId") String currentUser);

    @Query("""
            SELECT new com.dnabrd04.apiserver.dto.PostDTO(p, pr,
                (SELECT COUNT(ul) > 0 FROM Like ul WHERE ul.post.idPost = p.idPost AND ul.user.firebaseId = :firebaseUserId)
            )
            FROM Post p
            LEFT JOIN p.likes l
            LEFT JOIN p.comments c
            LEFT JOIN p.user u
            LEFT JOIN p.post pr
            LEFT JOIN p.resources r
            WHERE p.idPost = :idPost
            GROUP BY p.idPost, u, p.post, p.text, p.privacity, p.creation_date
            """)
    PostDTO findPostByIdWithLikeStatus(@Param("idPost") Long id, @Param("firebaseUserId") String currentUser);
}
