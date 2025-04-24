package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> getFollowsByUser(Long id);
}
