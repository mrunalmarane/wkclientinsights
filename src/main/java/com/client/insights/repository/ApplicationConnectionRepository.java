package com.client.insights.repository;

import com.client.insights.entity.ApplicationConnection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ApplicationConnectionRepository extends JpaRepository<ApplicationConnection, UUID> {
    List<ApplicationConnection> findAllByConnectedApplicationIdAndIsDeletedFalse(UUID connectedApplicationId);
}