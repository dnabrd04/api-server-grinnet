package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.Comment;
import com.dnabrd04.apiserver.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class will be used to do all the database operations of the Comment class.
 *
 * @author dnabrd04
 */
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Create and return the comment of the database.
     * @param comment to create.
     * @return the comment created.
     */
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    /**
     * Get all the comments of a specific post.
     * @param id of the specific post.
     * @return a list with all the comments.
     */
    public List<Comment> getCommentsByPost(Long id) {
        return commentRepository.getCommentsByPost(id);
    }

    /**
     * Delete the comment of the database by id.
     * @param id to delete the comment.
     */
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
