package com.client.insights.service;

import com.client.insights.FABService;
import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.ClientTeamProjection;
import com.client.insights.entity.ContactProjection;
import com.client.insights.entity.CpmContact;
import com.client.insights.entity.RelationshipProjection;
import com.client.insights.repository.ApplicationConnectionRepository;
import com.client.insights.repository.ClientTeamProjectionRepository;
import com.client.insights.repository.ContactProjectionRepository;
import com.client.insights.repository.CpmContactRepository;
import com.client.insights.repository.RelationshipProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class ClientDetailsService {

    @Autowired
    private FABService fabService;

    @Autowired
    private FileService fileService;

    @Autowired
    private CpmContactRepository contactRepository;

    @Autowired
    private ContactProjectionRepository contactProjectionRepository;

    @Autowired
    private ClientTeamProjectionRepository clientTeamProjectionRepository;

    @Autowired
    private ApplicationConnectionRepository applicationConnectionRepository;

    @Autowired
    private RelationshipProjectionRepository relationshipProjectionRepository;

    public static final UUID ADDISON = UUID.fromString("5aefeb06-bcb2-43b3-9c79-c4f14588e02e");
    public static final UUID AKTE = UUID.fromString("b95e5aa6-8d2f-4225-8b47-b2cd03f0ed91");

    public void execute(String prompt) {
        StringBuilder aiResponse = fabService.execute(prompt);
        if (aiResponse != null) {
            // Process the response as needed
            System.out.println("Fetched AI Response: " + aiResponse);

            /*String contactCode = "123";

            List<CpmContact> clientsByContactCode = contactRepository.findClientsByContactCodeContainsIgnoreCase(contactCode);
            List<CpmContact> clients = contactRepository.findAll();
            clients.forEach(System.out::println);*/

            // Write the response to a PDF file
            fileService.writeResponseToPdf(aiResponse.toString());
        } else {
            System.out.println("Failed to fetch API response.");
        }
    }

    public List<CpmContact> getClientDetailsByContactCode(String contactCode) {
        return contactRepository.findAllByContactCodeContaining(contactCode);
    }

    public List<ContactProjection> getClientDetailsByCompanyName(String companyName) {
        return contactProjectionRepository.findContactProjectionByCompanyNameIsContainingIgnoreCase(companyName);
    }

    public List<ClientTeamProjection> getClientDetailsByClientTeamMember(String memberName) {
        return clientTeamProjectionRepository.findByEmployeeNameContainsIgnoreCaseOrEmployeeAliasIsContainingIgnoreCase(memberName, memberName);
    }

    public List<ClientTeamProjection> getClientDetailsByClientTeamMemberNameAndRoleName(String memberName, String roleName) {
        return clientTeamProjectionRepository.searchWithRoleFilter(memberName, memberName, roleName);
    }

    public List<ApplicationConnection> getClientDetailsByConnectedApplication(String applicationName) {
        UUID applicationId = null;
        if (applicationName.compareToIgnoreCase("Addison") == 0) {
            applicationId = ADDISON;
        } else if (applicationName.compareToIgnoreCase("Akte") == 0) {
            applicationId = AKTE;
        }
        return applicationConnectionRepository.findAllByConnectedApplicationIdAndIsDeletedFalse(applicationId);
    }

    public List<RelationshipProjection> getClientDetailsByRelationshipName(String relationshipName) {
        return relationshipProjectionRepository.findByAliasContainingIgnoreCase(relationshipName);//TODO
    }

}
