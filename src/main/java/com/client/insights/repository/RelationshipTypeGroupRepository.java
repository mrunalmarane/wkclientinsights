package com.client.insights.repository;

import com.client.insights.entity.RelationshipTypeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelationshipTypeGroupRepository extends JpaRepository<RelationshipTypeGroup, UUID> {
}