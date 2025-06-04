package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Follow;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    @Query("Select f FROM Follow f WHERE f.followed.idUser = :idUser")
    List<Follow> getFollowersByIdUser(@Param("idUser") Long id);

    @Query("Select f FROM Follow f WHERE f.follower.idUser = :idUser")
    List<Follow> getFollowedsByIdUser(@Param("idUser") Long id);

    @Query("Select f FROM Follow f WHERE f.followed.idUser = :idUserFollowed and f.follower.idUser = :idUserFollower")
    List<Follow> checkUserFollows(@Param("idUserFollowed") Long idFollowed, @Param("idUserFollower") Long idFollower);

    @Modifying
    @Transactional
    @Query("DELETE FROM Follow f WHERE f.follower.idUser = :followerId AND f.followed.idUser = :followedId")
    void deleteFollow(@Param("followerId") Long followerId, @Param("followedId") Long followedId);
}
