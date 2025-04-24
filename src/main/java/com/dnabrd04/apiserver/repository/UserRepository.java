package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByFirebaseId(String firebaseId);
    List<User> findById_userIn(List<Long> ids);
}
