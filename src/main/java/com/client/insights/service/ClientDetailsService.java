package com.client.insights.service;

import com.client.insights.FABService;
import com.client.insights.dto.ClientTeamProjectionDto;
import com.client.insights.dto.ContactProjectionDto;
import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.ClientTeamProjection;
import com.client.insights.entity.ContactProjection;
import com.client.insights.entity.CpmContact;
import com.client.insights.entity.EmployeeProjection;
import com.client.insights.entity.RelationshipProjection;
import com.client.insights.mapper.ClientTeamProjectionDtoMapper;
import com.client.insights.mapper.ContactProjectionDtoMapper;
import com.client.insights.mapper.CpmContactDtoMapper;
import com.client.insights.repository.ApplicationConnectionRepository;
import com.client.insights.repository.ClientTeamProjectionRepository;
import com.client.insights.repository.ContactProjectionRepository;
import com.client.insights.repository.CpmContactRepository;
import com.client.insights.repository.EmployeeProjectionRepository;
import com.client.insights.repository.RelationshipProjectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private EmployeeProjectionRepository employeeProjectionRepository;

    @Autowired
    private CpmContactDtoMapper contactDtoMapper;

    @Autowired
    private ContactProjectionDtoMapper contactProjectionDtoMapper;

    @Autowired
    private ClientTeamProjectionDtoMapper clientTeamProjectionDtoMapper;

    public static final UUID ADDISON = UUID.fromString("5aefeb06-bcb2-43b3-9c79-c4f14588e02e");
    public static final UUID AKTE = UUID.fromString("b95e5aa6-8d2f-4225-8b47-b2cd03f0ed91");

    public void execute(String prompt) {
        StringBuilder aiResponse = new StringBuilder("");//fabService.execute(prompt);
        if (aiResponse != null) {
            // Process the response as needed
            System.out.println("Fetched AI Response: " + aiResponse);

            /*String contactCode = "10005";
            List<CpmContactDto> clientCodeDetails = getClientDetailsByContactCode(contactCode);

            String companyName = "Klimbim";
            List<ContactProjectionDto> companyNameDetails = getClientDetailsByCompanyName(companyName);*/

            String clientTeamMemberName = "Anna";
            List<ClientTeamProjectionDto> clientTeamMemberList = getClientDetailsByClientTeamMember(clientTeamMemberName);

            fileService.exportToExcel(clientTeamMemberList, CpmContactDto.headers, ClientTeamProjectionDto.class);

            // Write the response to an Excel file
            //fileService.exportToExcel(companyNameDetails, ContactProjectionDto.headers, ContactProjectionDto.class);

            // Write the response to a PDF file
            //fileService.writeResponseToPdf(aiResponse.toString());
        } else {
            System.out.println("Failed to fetch API response.");
        }
    }

    public List<CpmContactDto> getClientDetailsByContactCode(String contactCode) {
        List<CpmContact> cpmContactList = contactRepository.findAllByContactCodeContaining(contactCode);
        // Manually map additional fields
        cpmContactList.forEach(contact -> {
            contact.setResponsibleEmployeeName(employeeProjectionRepository.findById(contact.getResponsibleEmployee())
                    .map(EmployeeProjection::getFullname)
                    .orElse("Unknown"));
        });
        return contactDtoMapper.toDtoList(cpmContactList);
    }

    public List<ContactProjectionDto> getClientDetailsByCompanyName(String companyName) {
        List<ContactProjection> cpmContactList = contactProjectionRepository.findContactProjectionByCompanyNameIsContainingIgnoreCase(companyName);
        return contactProjectionDtoMapper.toDtoList(cpmContactList);
    }

    public List<ClientTeamProjectionDto> getClientDetailsByClientTeamMember(String memberName) {
        List<ClientTeamProjection> clientTeamProjectionList = clientTeamProjectionRepository.findByEmployeeNameContainsIgnoreCaseOrEmployeeAliasIsContainingIgnoreCase(memberName, memberName);
        return clientTeamProjectionDtoMapper.toDtoList(clientTeamProjectionList);
    }

    public List<ClientTeamProjectionDto> getClientDetailsByClientTeamMemberNameAndRoleName(String memberName, String roleName) {
        List<ClientTeamProjection> projectionList = clientTeamProjectionRepository.searchWithRoleFilter(memberName, memberName, roleName);
        return clientTeamProjectionDtoMapper.toDtoList(projectionList);
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
