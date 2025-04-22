package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.model.Like;
import com.dnabrd04.apiserver.model.User;
import com.dnabrd04.apiserver.service.LikeService;
import com.dnabrd04.apiserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public ResponseEntity<Like> createLike(@RequestBody Like like) {
        return ResponseEntity.ok(likeService.createLike(like));
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<Long> countLikesByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.getCountLike(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId, @PathVariable Long postId) {
        likeService.deleteLike(userId, postId);
        return ResponseEntity.noContent().build();
    }
}
