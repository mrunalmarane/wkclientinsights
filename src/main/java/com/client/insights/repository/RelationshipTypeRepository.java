package com.client.insights.repository;

import com.client.insights.entity.RelationshipType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelationshipTypeRepository extends JpaRepository<RelationshipType, UUID> {
}