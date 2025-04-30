package com.dnabrd04.apiserver.repository;

import com.dnabrd04.apiserver.model.Resource;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    @Query("SELECT r FROM Resource r WHERE r.post = :idPost")
    List<Resource> getResourcesByPost(@Param("idPost") Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Resource r WHERE r.id_resource = :idResource")
    void deleteByPostId(@Param("idResource") Long id);
}
