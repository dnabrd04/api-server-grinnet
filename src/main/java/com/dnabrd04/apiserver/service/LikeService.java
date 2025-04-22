package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.Like;
import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    /**
     * Receives a like and adds it to the database.
     *
     * @param "like" to add on the database
     * @return the user added on the database.
     */
    public Like createLike(Like like) {
        return likeRepository.save(like);
    }

    /**
     * Receives an id of a post and gets the likes it has.
     *
     * @param id to search on the database
     * @return the user with match the id on the database.
     */
    public Long getCountLike(Long id) {
        return likeRepository.countByPost(id);
    }

    /**
     * Receives an id user and an id post and delete the like.
     */
    public void deleteLike(Long userId, Long postId) {
        likeRepository.deleteByUserIdAndPostId(userId, postId);
    }
}
