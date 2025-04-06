package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
