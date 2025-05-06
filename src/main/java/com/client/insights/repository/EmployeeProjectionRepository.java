package com.client.insights.repository;

import com.client.insights.entity.EmployeeProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeProjectionRepository extends JpaRepository<EmployeeProjection, UUID> {
    @Override
    Optional<EmployeeProjection> findById(UUID uuid);
}