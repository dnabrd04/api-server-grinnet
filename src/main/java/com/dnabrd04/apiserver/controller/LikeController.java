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
    public ResponseEntity<Void> createLike(@RequestBody Like like) {
        likeService.createLike(like);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<Long> countLikesByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(likeService.getCountLike(postId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id, @RequestParam Long postId) {
        likeService.deleteLike(id, postId);
        return ResponseEntity.noContent().build();
    }
}
