package com.dnabrd04.apiserver.controller;

import com.dnabrd04.apiserver.model.Follow;
import com.dnabrd04.apiserver.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping
    public ResponseEntity<Follow> createFollow(@RequestBody Follow follow) {
        return ResponseEntity.ok(followService.createFollow(follow));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Follow>> getFollowsByUser(@RequestParam Long id) {
        return ResponseEntity.ok(followService.getFollowsByUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@RequestParam Long id) {
        followService.deleteFollow(id);
        return ResponseEntity.noContent().build();
    }
}
