package com.client.insights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * DTO for {@link com.client.insights.entity.ClientTeamProjection}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientTeamProjectionDto implements Serializable {
    private final UUID rowId;
    private final UUID clientId;
    private final String contactName;
    private final String companyName;
    private final String contactAvatar;
    private final String contactDisplayName;
    private final Integer contactType;
    private final UUID employeeId;
    private final String employeeName;
    private final UUID roleId;
    private final String roleName;
    private final String searchString;
    private final String searchStringWithAlias;
    private final Long employeeNumber;
    private final String employeeStringNo;
    private final String employeeAvatar;
    private final String employeeAlias;
    private final String contactAlias;
    private final Boolean isDeleted;

    public ClientTeamProjectionDto(UUID rowId, UUID clientId, String contactName, String companyName, String contactAvatar, String contactDisplayName, Integer contactType, UUID employeeId, String employeeName, UUID roleId, String roleName, String searchString, String searchStringWithAlias, Long employeeNumber, String employeeStringNo, String employeeAvatar, String employeeAlias, String contactAlias, Boolean isDeleted) {
        this.rowId = rowId;
        this.clientId = clientId;
        this.contactName = contactName;
        this.companyName = companyName;
        this.contactAvatar = contactAvatar;
        this.contactDisplayName = contactDisplayName;
        this.contactType = contactType;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.searchString = searchString;
        this.searchStringWithAlias = searchStringWithAlias;
        this.employeeNumber = employeeNumber;
        this.employeeStringNo = employeeStringNo;
        this.employeeAvatar = employeeAvatar;
        this.employeeAlias = employeeAlias;
        this.contactAlias = contactAlias;
        this.isDeleted = isDeleted;
    }

    public UUID getRowId() {
        return rowId;
    }

    public UUID getClientId() {
        return clientId;
    }

    public String getContactName() {
        return contactName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getContactAvatar() {
        return contactAvatar;
    }

    public String getContactDisplayName() {
        return contactDisplayName;
    }

    public Integer getContactType() {
        return contactType;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getSearchString() {
        return searchString;
    }

    public String getSearchStringWithAlias() {
        return searchStringWithAlias;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public String getEmployeeStringNo() {
        return employeeStringNo;
    }

    public String getEmployeeAvatar() {
        return employeeAvatar;
    }

    public String getEmployeeAlias() {
        return employeeAlias;
    }

    public String getContactAlias() {
        return contactAlias;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public static Map<String, String> headers = new LinkedHashMap<>() {{
        put("contactName", "Contact Name");
        put("contactAlias", "Contact Alias");
        put("companyName", "Company Name");
        put("contactDisplayName", "Contact Display Name");
        put("employeeName", "Employee Name");
        put("employeeAlias", "Employee Alias");
        put("roleName", "Role Name");
        put("employeeStringNo", "Employee Number");
    }};
}