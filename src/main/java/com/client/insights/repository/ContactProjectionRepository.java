package com.client.insights.repository;

import com.client.insights.entity.ContactProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContactProjectionRepository extends JpaRepository<ContactProjection, UUID> {
    List<ContactProjection> findContactProjectionByCompanyNameIsContainingIgnoreCase(String companyName);
}