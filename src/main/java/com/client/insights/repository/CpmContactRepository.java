package com.client.insights.repository;

import com.client.insights.entity.CpmContact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CpmContactRepository extends JpaRepository<CpmContact, UUID> {
    List<CpmContact> findAllByContactCodeContaining(String contactCode);
}