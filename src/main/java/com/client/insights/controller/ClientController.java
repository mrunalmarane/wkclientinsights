package com.client.insights.controller;


import com.client.insights.Exception.ClientNotFoundException;
import com.client.insights.dto.ClientTeamProjectionDto;
import com.client.insights.dto.ContactProjectionDto;
import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.RelationshipProjection;
import com.client.insights.service.ClientDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Operation(summary = "Fetch client data by client ID")
    @GetMapping (value = "/clientData", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CpmContactDto> getClientData(@RequestParam String clientId) {
        // Logic to fetch client data based on the clientId
        if (clientId == null || clientId.isEmpty()) {
            throw new ClientNotFoundException("Client ID not found");
        }
        System.out.println("Fetching data for client ID: " + clientId);
        return clientDetailsService.getClientDetailsByContactCode(clientId);
    }

    @Operation(summary = "Fetch clients by company name")
    @GetMapping (value = "/clientsByCompanyName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ContactProjectionDto>> getClientDetailsByCompanyName(@RequestParam String companyName) {
        // Logic to fetch client data based on the clientId
        if (companyName == null || companyName.isEmpty()) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for company name: " + companyName);
        List<ContactProjectionDto> clientDetailsByCompanyName = clientDetailsService.getClientDetailsByCompanyName(companyName);
        return ResponseEntity.ok(clientDetailsByCompanyName);
    }

    @Operation(summary = "Fetch clients by client team member name")
    @GetMapping (value = "/clientsByClientTeamMember", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientTeamProjectionDto>> getClientDetailsByClientTeamMemberName(@RequestParam String clientTeamMember) {
        // Logic to fetch client data based on the clientId
        if (clientTeamMember == null || clientTeamMember.isEmpty()) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for client team member name: " + clientTeamMember);
        List<ClientTeamProjectionDto> clientDetailsByClientTeamMember = clientDetailsService.getClientDetailsByClientTeamMember(clientTeamMember);
        return ResponseEntity.ok(clientDetailsByClientTeamMember);
    }

    @Operation(summary = "Fetch clients by client team member name")
    @GetMapping (value = "/clientsByTeamMemberAndRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientTeamProjectionDto>> getClientDetailsByClientTeamMemberNameAndRoleName(@RequestParam String clientTeamMember, @RequestParam String roleName) {
        // Logic to fetch client data based on the clientId
        if ((clientTeamMember == null || clientTeamMember.isEmpty()) && (roleName == null || roleName.isEmpty())) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for client team member name: " + clientTeamMember + " and role name: " + roleName);
        List<ClientTeamProjectionDto> clientDetailsByClientTeamMember = clientDetailsService.getClientDetailsByClientTeamMemberNameAndRoleName(clientTeamMember, roleName);
        return ResponseEntity.ok(clientDetailsByClientTeamMember);
    }

    @Operation(summary = "Fetch clients by connected application name")
    @GetMapping (value = "/clientsByConnectedApplication", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationConnection>> getClientDetailsByConnectedApplication(@RequestParam String applicationName) {
        // Logic to fetch client data based on the clientId
        if (applicationName == null || applicationName.isEmpty()) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for application name: " + applicationName);
        List<ApplicationConnection> clientDetailsByConnectedApplication = clientDetailsService.getClientDetailsByConnectedApplication(applicationName);
        return ResponseEntity.ok(clientDetailsByConnectedApplication);
    }

    @Operation(summary = "Fetch clients by relationships")
    @GetMapping (value = "/clientsByRelationshipName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RelationshipProjection>> getClientDetailsByRelationshipName(@RequestParam String relationshipName) {
        // Logic to fetch client data based on the clientId
        if (relationshipName == null || relationshipName.isEmpty()) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for relationship name: " + relationshipName);
        List<RelationshipProjection> clientDetailsByRelationshipName = clientDetailsService.getClientDetailsByRelationshipName(relationshipName);
        return ResponseEntity.ok(clientDetailsByRelationshipName);
    }
}
