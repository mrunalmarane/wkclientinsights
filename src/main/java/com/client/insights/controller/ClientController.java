package com.client.insights.controller;


import com.client.insights.Exception.ClientNotFoundException;
import com.client.insights.dto.ApplicationConnectionDto;
import com.client.insights.dto.ClientTeamProjectionDto;
import com.client.insights.dto.ContactProjectionDto;
import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.RelationshipProjection;
import com.client.insights.response.ClientAllDetailsResponse;
import com.client.insights.service.ClientDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Operation(summary = "Fetch client data by contact code")
    @GetMapping (value = "/clientsByContactCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CpmContactDto> getClientData(@RequestParam String contactCode) {
        // Logic to fetch client data based on the clientId
        if (contactCode == null || contactCode.isEmpty()) {
            throw new ClientNotFoundException("Client ID not found");
        }
        System.out.println("Fetching data for client ID: " + contactCode);
        return clientDetailsService.getClientDetailsByContactCode(contactCode);
    }

    @Operation(summary = "Fetch combined client data and all related data by contact Code")
    @GetMapping (value = "/clientsCombinedDataById")
    public ClientAllDetailsResponse getClientDetailedDataByContactCode(@RequestParam String contactCode) {
        // Logic to fetch client data based on the clientId
        try {
            if (contactCode == null || contactCode.isEmpty()) {
                throw new ClientNotFoundException("Client ID not found");
            }
            System.out.println("Fetching data for client ID and also all related data for that client: " + contactCode);
            return clientDetailsService.getDetailsForClient(contactCode);
        } catch (Exception e){
            System.out.println("Error occurred while fetching client data: " + e.getMessage());
            logger.error(e.getMessage());
            logger.error("Error occurred while fetching client data: ", e);
        }
        return null;
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

    @Operation(summary = "Fetch clients by client team member name only")
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

    @Operation(summary = "Fetch clients by client team member name and role")
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
    @GetMapping (value = "/clientsByConnectedApplicationName", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ApplicationConnectionDto>> getClientDetailsByConnectedApplication(@RequestParam String applicationName) {
        // Logic to fetch client data based on the clientId
        if (applicationName == null || applicationName.isEmpty()) {
            throw new ClientNotFoundException("Not found");
        }
        System.out.println("Fetching clients for application name: " + applicationName);
        List<ApplicationConnectionDto> clientDetailsByConnectedApplication = clientDetailsService.getClientDetailsByConnectedApplication(applicationName);
        return ResponseEntity.ok(clientDetailsByConnectedApplication);
    }

    @Operation(summary = "Fetch clients by relationship name")
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
