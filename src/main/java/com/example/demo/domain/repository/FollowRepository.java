package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Follow;
import com.example.demo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Follow findByFollowerAndFollowing(User follower, User following);
}
