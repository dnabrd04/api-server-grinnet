package com.dnabrd04.apiserver.controller;


import com.dnabrd04.apiserver.dto.PostDTO;
import com.dnabrd04.apiserver.model.Post;
import com.dnabrd04.apiserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        return ResponseEntity.ok(postService.getPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostDTO(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostsByUser(id));
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.createPost(post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post existingPost = postService.getPost(id);

        if(existingPost == null) {
            return ResponseEntity.noContent().build();
        }

        existingPost.setText(post.getText());
        existingPost.setPrivacity(post.getPrivacity());

        return ResponseEntity.ok(postService.updatePost(existingPost));
    }
}
