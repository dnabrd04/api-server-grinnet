package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    @Query("Select f FROM Follow f WHERE f.followed.id_user = :idUser")
    List<Follow> getFollowersByIdUser(@Param("idUser") Long id);
}
