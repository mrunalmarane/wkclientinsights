package com.client.insights.repository;

import com.client.insights.entity.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelationshipRepository extends JpaRepository<Relationship, UUID> {
}