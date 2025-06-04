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

    @GetMapping("/{id}/followers")
    public ResponseEntity<String> getFollowersByUser(@PathVariable Long id) {
        return ResponseEntity.ok("" + followService.getFollowsByUser(id).size());
    }

    @GetMapping("/{id}/following")
    public ResponseEntity<String> getFollowingsByUser(@PathVariable Long id) {
        return ResponseEntity.ok("" + followService.getFollowedsByUser(id).size());
    }

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkIfUserFollows(@RequestParam Long idFollowed, @RequestParam Long idFollower) {
        return ResponseEntity.ok(followService.checkIfUserFollows(idFollowed, idFollower));
    }

    @DeleteMapping("/unfollow")
    public ResponseEntity<Void> unfollowUser(
            @RequestParam Long followerId,
            @RequestParam Long followedId
    ) {
        followService.unfollow(followerId, followedId);
        return ResponseEntity.noContent().build();
    }
}
