package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.model.Comment;
import com.dnabrd04.apiserver.service.CommentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * Create a new comment.
     * @param comment to create.
     * @return a ResponseEntity with the comment created.
     */
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.createComment(comment));
    }

    /**
     * Get a list with all the comments by a post.
     * @param id of the post.
     * @return a ResponseEntity with the list created.
     */
    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long id) {
        return ResponseEntity.ok(commentService.getCommentsByPost(id));
    }

    /**
     * Delete a comment.
     * @param id of the comment to delete.
     * @return a ResponseEntity without content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }
}
