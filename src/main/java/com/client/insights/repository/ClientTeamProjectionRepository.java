package com.client.insights.repository;

import com.client.insights.entity.ClientTeamProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ClientTeamProjectionRepository extends JpaRepository<ClientTeamProjection, UUID> {
    List<ClientTeamProjection> findByEmployeeNameContainsIgnoreCaseOrEmployeeAliasIsContainingIgnoreCase(String employeeName, String employeeAlias);

    List<ClientTeamProjection> findByEmployeeNameContainsIgnoreCaseOrEmployeeAliasIsContainingIgnoreCaseAndRoleNameContainsIgnoreCase(String employeeName, String employeeAlias, String roleName);

    List<ClientTeamProjection> findByEmployeeNameContainingIgnoreCaseOrEmployeeAliasIsContainingIgnoreCaseAndRoleNameIsContaining(String employeeName, String employeeAlias, String roleName);

    @Query("""
    SELECT c FROM ClientTeamProjection c
    WHERE 
        (UPPER(c.employeeName) LIKE UPPER(CONCAT('%', :employeeName, '%')) 
        OR UPPER(c.employeeAlias) LIKE UPPER(CONCAT('%', :employeeAlias, '%')))
        AND UPPER(c.roleName) LIKE UPPER(CONCAT('%', :roleName, '%'))
""")
    List<ClientTeamProjection> searchWithRoleFilter(
            @Param("employeeName") String employeeName,
            @Param("employeeAlias") String employeeAlias,
            @Param("roleName") String roleName
    );
}