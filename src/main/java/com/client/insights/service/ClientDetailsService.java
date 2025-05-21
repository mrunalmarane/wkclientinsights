package com.client.insights.service;

import com.client.insights.dto.ApplicationConnectionDto;
import com.client.insights.dto.ClientTeamProjectionDto;
import com.client.insights.dto.ContactProjectionDto;
import com.client.insights.dto.CpmContactDto;
import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.ClientTeamProjection;
import com.client.insights.entity.ContactProjection;
import com.client.insights.entity.CpmContact;
import com.client.insights.entity.EmployeeProjection;
import com.client.insights.entity.RelationshipProjection;
import com.client.insights.mapper.ApplicationConnectionDtoMapper;
import com.client.insights.mapper.ClientTeamProjectionDtoMapper;
import com.client.insights.mapper.ContactProjectionDtoMapper;
import com.client.insights.mapper.CpmContactDtoMapper;
import com.client.insights.repository.ApplicationConnectionRepository;
import com.client.insights.repository.ClientTeamProjectionRepository;
import com.client.insights.repository.ContactProjectionRepository;
import com.client.insights.repository.CpmContactRepository;
import com.client.insights.repository.EmployeeProjectionRepository;
import com.client.insights.repository.RelationshipProjectionRepository;
import com.client.insights.response.ClientAllDetailsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
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

    @Autowired
    private ApplicationConnectionDtoMapper appConnectionDtoMapper;

    public static final UUID ADDISON = UUID.fromString("5aefeb06-bcb2-43b3-9c79-c4f14588e02e");
    public static final UUID AKTE = UUID.fromString("b95e5aa6-8d2f-4225-8b47-b2cd03f0ed91");

    public byte[] execute(String prompt) throws JsonProcessingException {
        System.out.println("Executing with prompt: " + prompt);
        StringBuilder aiResponse = fabService.execute(prompt);
        if (aiResponse != null) {
            // Process the response as needed
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = null;
            try {
                rootNode = objectMapper.readTree(String.valueOf(aiResponse));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

            String content = rootNode.path("output").path("payload").path("content").asText();

            Map<String, String> allCsv = extractCsvFromJson(content);
            try {
                return fileService.writeCsvToExcelMultipleSheets(allCsv);
            } catch (IOException e) {
                throw new RuntimeException("Error generating Excel file", e);
            }

        } else {
            System.out.println("Failed to fetch API response.");
            return fileService.createNoDataExcel();
        }
    }

    private static Map<String, String> extractCsvFromJson(String json) {
        Map<String, String> allCsv = new HashMap<>();
        String[] parts;
        if (json.contains("|")) {
            parts = json.split("\\|");
            for (String part : parts) {
                String[] internalParts = part.split("::");
                String sheetName = internalParts[0];
                allCsv.put(sheetName, internalParts[1].replaceAll("\\\\n", "\n").replaceAll("\\\\\"", "\"").trim());
            }
            return allCsv;
        }

        allCsv.put("Client Data", json.replaceAll("\\\\n", "\n").replaceAll("\\\\\"", "\"").trim());

        return allCsv;
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

    public List<ApplicationConnectionDto> getClientDetailsByConnectedApplication(String applicationName) {
        UUID applicationId = null;
        if (applicationName.compareToIgnoreCase("Addison") == 0) {
            applicationId = ADDISON;
        } else if (applicationName.compareToIgnoreCase("Akte") == 0) {
            applicationId = AKTE;
        }
        List<ApplicationConnection> connectedApplicationList = applicationConnectionRepository.findAllByConnectedApplicationIdAndIsDeletedFalse(applicationId);
        // Manually map additional fields
        connectedApplicationList.forEach(app -> {
            contactRepository.findById(app.getClientId()).ifPresent(contact -> {
                app.setName(applicationName);
                app.setClientName(contact.getCompanyNameOrPersonName());
                app.setContactCode(contact.getContactCode());
            });
        });
        return appConnectionDtoMapper.toDtoList(connectedApplicationList);
    }

    public List<RelationshipProjection> getClientDetailsByRelationshipName(String relationshipName) {
        return relationshipProjectionRepository.findByAliasContainingIgnoreCase(relationshipName);//TODO
    }

    public ClientAllDetailsResponse getDetailsForClient(String contactId) {
        UUID contactIdUUID = null;
        if(Objects.equals(contactId, "123")) {
            contactIdUUID = UUID.fromString("0382bec3-49d3-49d9-94c7-32a8ab3f224d");
        } else if (Objects.equals(contactId, "456")) {
            contactIdUUID = UUID.fromString("f12f4838-ade5-4f0b-86f0-d13c822ecbc7");
        }

        //UUID contactIdUUID = UUID.fromString(contactId);
        Optional<CpmContact> contact = contactRepository.findById(contactIdUUID);
        if (contact.isPresent()) {
            System.out.println("Contact found: " + contact.get());
        } else {
            System.out.println("Contact not found");
        }

        List<ClientTeamProjection> clientTeamProjections = clientTeamProjectionRepository.findByClientId(contactIdUUID);
        List<ApplicationConnection> applicationConnections = applicationConnectionRepository.findAllByClientId(contactIdUUID);
        List<RelationshipProjection> relationshipProjections = relationshipProjectionRepository.findByViewerContactId(contactIdUUID);

        ClientAllDetailsResponse response = new ClientAllDetailsResponse();
        response.setApplicationConnection(applicationConnections);
        response.setClientTeamProjection(clientTeamProjections);
        response.setCpmContact(contact.get());
        response.setRelationship(relationshipProjections);

        return response;
    }

}
