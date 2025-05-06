package com.client.insights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.client.insights.entity.ContactProjection}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactProjectionDto implements Serializable {
    private final UUID rowId;
    private final Boolean isActive;
    private final String no;
    private final Integer type;
    private final String companyName;
    private final String contactName;
    private final UUID employeeId;
    private final String clientManager;
    private final LocalDate nextDueDate;
    private final String searchStringNew;
    private final String contactCode;
    private final Long contactCodeAsLong;
    private final Integer contactState;
    private final String sortString;
    private final UUID orgUnitId;
    private final String displayName;
    private final String contactProfession;
    private final String contactBusiness;
    private final String urlAvatar;
    private final LocalDate authorizedClientStartDate;
    private final LocalDate authorizedClientEndDate;
    private final String authorizedClientEndDateReason;
    private final String alias;
    private final String searchStringWithAlias;
    private final String clientManagerAlias;
    private final UUID firmOrgStructure;
    private final UUID contactId;
    private final Boolean isDeleted;

    public ContactProjectionDto(UUID rowId, Boolean isActive, String no, Integer type, String companyName, String contactName, UUID employeeId, String clientManager, LocalDate nextDueDate, String searchStringNew, String contactCode, Long contactCodeAsLong, Integer contactState, String sortString, UUID orgUnitId, String displayName, String contactProfession, String contactBusiness, String urlAvatar, LocalDate authorizedClientStartDate, LocalDate authorizedClientEndDate, String authorizedClientEndDateReason, String alias, String searchStringWithAlias, String clientManagerAlias, UUID firmOrgStructure, UUID contactId, Boolean isDeleted) {
        this.rowId = rowId;
        this.isActive = isActive;
        this.no = no;
        this.type = type;
        this.companyName = companyName;
        this.contactName = contactName;
        this.employeeId = employeeId;
        this.clientManager = clientManager;
        this.nextDueDate = nextDueDate;
        this.searchStringNew = searchStringNew;
        this.contactCode = contactCode;
        this.contactCodeAsLong = contactCodeAsLong;
        this.contactState = contactState;
        this.sortString = sortString;
        this.orgUnitId = orgUnitId;
        this.displayName = displayName;
        this.contactProfession = contactProfession;
        this.contactBusiness = contactBusiness;
        this.urlAvatar = urlAvatar;
        this.authorizedClientStartDate = authorizedClientStartDate;
        this.authorizedClientEndDate = authorizedClientEndDate;
        this.authorizedClientEndDateReason = authorizedClientEndDateReason;
        this.alias = alias;
        this.searchStringWithAlias = searchStringWithAlias;
        this.clientManagerAlias = clientManagerAlias;
        this.firmOrgStructure = firmOrgStructure;
        this.contactId = contactId;
        this.isDeleted = isDeleted;
    }

    public UUID getRowId() {
        return rowId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public String getNo() {
        return no;
    }

    public Integer getType() {
        return type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getClientManager() {
        return clientManager;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public String getSearchStringNew() {
        return searchStringNew;
    }

    public String getContactCode() {
        return contactCode;
    }

    public Long getContactCodeAsLong() {
        return contactCodeAsLong;
    }

    public Integer getContactState() {
        return contactState;
    }

    public String getSortString() {
        return sortString;
    }

    public UUID getOrgUnitId() {
        return orgUnitId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getContactProfession() {
        return contactProfession;
    }

    public String getContactBusiness() {
        return contactBusiness;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public LocalDate getAuthorizedClientStartDate() {
        return authorizedClientStartDate;
    }

    public LocalDate getAuthorizedClientEndDate() {
        return authorizedClientEndDate;
    }

    public String getAuthorizedClientEndDateReason() {
        return authorizedClientEndDateReason;
    }

    public String getAlias() {
        return alias;
    }

    public String getSearchStringWithAlias() {
        return searchStringWithAlias;
    }

    public String getClientManagerAlias() {
        return clientManagerAlias;
    }

    public UUID getFirmOrgStructure() {
        return firmOrgStructure;
    }

    public UUID getContactId() {
        return contactId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public static Map<String, String> headers = new LinkedHashMap<>() {{
        put("contactCode", "Contact Code");
        put("companyName", "Company Name");
        put("contactName", "Contact Name");
        put("clientManager", "Client Manager");
        put("clientManagerAlias", "Client Manager Alias");
        put("nextDueDate", "Next Due Date");
        put("displayName", "Display Name");
        put("contactProfession", "Contact Profession");
        put("contactBusiness", "Contact Business");
        put("authorizedClientStartDate", "Authorized Client Start Date");
        put("authorizedClientEndDate", "Authorized Client End Date");
        put("authorizedClientEndDateReason", "Authorized Client End Date Reason");
        put("alias", "Alias");
    }};
}