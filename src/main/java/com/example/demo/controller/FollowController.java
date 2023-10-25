package com.example.demo.controller;

import com.example.demo.domain.entity.User;
import com.example.demo.domain.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {
    @Autowired
    private FollowService followService;


    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestParam("followerId") User follower, @RequestParam("followingId") User following) {

        if (followService.isFollowing(follower, following)) {
            return ResponseEntity.badRequest().body("Already following");
        }

        followService.follow(follower, following);
        return ResponseEntity.ok("Followed successfully");
    }

    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollow(@RequestParam("followerId") User follower, @RequestParam("followingId") User following) {

        if (!followService.isFollowing(follower, following)) {
            return ResponseEntity.badRequest().body("Not following");
        }

        followService.unfollow(follower, following);
        return ResponseEntity.ok("Unfollowed successfully");
    }
}
