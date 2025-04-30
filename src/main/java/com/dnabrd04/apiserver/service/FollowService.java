package com.dnabrd04.apiserver.service;

import com.dnabrd04.apiserver.model.Follow;
import com.dnabrd04.apiserver.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {

    @Autowired
    private FollowRepository followRepository;

    public Follow createFollow(Follow follow) {
        return followRepository.save(follow);
    }

    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }

    public List<Follow> getFollowsByUser(Long id) {
        return followRepository.getFollowersByIdUser(id);
    }
}
