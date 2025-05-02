package com.client.insights.repository;

import com.client.insights.entity.RelationshipProjection;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RelationshipProjectionRepository extends JpaRepository<RelationshipProjection, UUID> {
     List<RelationshipProjection> findByAliasContainingIgnoreCase(String alias);
}