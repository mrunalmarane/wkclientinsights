package com.client.insights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * DTO for {@link com.client.insights.entity.CpmContact}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CpmContactDto implements Serializable {
    private final UUID rowId;
    private final String companyNameOrPersonName;
    private final String legalEntityLegalForm;
    private final UUID firmOrgStructure;
    private final UUID primaryRelationshipId;
    private final UUID profileId;
    private final String personSurname;
    private final String legalEntityBusinessId;
    private final String orgNumber;
    private final UUID memberId;
    private final String personNiNo;
    private final Boolean isDeleted;
    private final String personNumber;
    private final Boolean isActive;
    private final Integer version;
    private final LocalDate personBirthday;
    private final String personFirstName;
    private final String personTaxRef;
    private final String legalEntityTaxRef;
    private final String personSocialSecurityNo;
    private final UUID legalEntityLegalFormType;
    private final String personProfession;
    private final String customLegalEntityLegalForm;
    private final String contactCode;
    private final UUID responsibleEmployee;
    private final Integer birthdaySort;
    private final String legalEntityBusiness;
    private final LocalDate legalEntityFoundingDate;
    private final Integer type;
    private final String email;
    private final String alias;
    private final Integer state;
    private final String responsibleEmployeeName;

    public CpmContactDto(UUID rowId, String companyNameOrPersonName, String legalEntityLegalForm, UUID firmOrgStructure, UUID primaryRelationshipId, UUID profileId, String personSurname, String legalEntityBusinessId, String orgNumber, UUID memberId, String personNiNo, Boolean isDeleted, String personNumber, Boolean isActive, Integer version, LocalDate personBirthday, String personFirstName, String personTaxRef, String legalEntityTaxRef, String personSocialSecurityNo, UUID legalEntityLegalFormType, String personProfession, String customLegalEntityLegalForm, String contactCode, UUID responsibleEmployee, Integer birthdaySort, String legalEntityBusiness, LocalDate legalEntityFoundingDate, Integer type, String email, String alias, Integer state, String responsibleEmployeeName) {
        this.rowId = rowId;
        this.companyNameOrPersonName = companyNameOrPersonName;
        this.legalEntityLegalForm = legalEntityLegalForm;
        this.firmOrgStructure = firmOrgStructure;
        this.primaryRelationshipId = primaryRelationshipId;
        this.profileId = profileId;
        this.personSurname = personSurname;
        this.legalEntityBusinessId = legalEntityBusinessId;
        this.orgNumber = orgNumber;
        this.memberId = memberId;
        this.personNiNo = personNiNo;
        this.isDeleted = isDeleted;
        this.personNumber = personNumber;
        this.isActive = isActive;
        this.version = version;
        this.personBirthday = personBirthday;
        this.personFirstName = personFirstName;
        this.personTaxRef = personTaxRef;
        this.legalEntityTaxRef = legalEntityTaxRef;
        this.personSocialSecurityNo = personSocialSecurityNo;
        this.legalEntityLegalFormType = legalEntityLegalFormType;
        this.personProfession = personProfession;
        this.customLegalEntityLegalForm = customLegalEntityLegalForm;
        this.contactCode = contactCode;
        this.responsibleEmployee = responsibleEmployee;
        this.birthdaySort = birthdaySort;
        this.legalEntityBusiness = legalEntityBusiness;
        this.legalEntityFoundingDate = legalEntityFoundingDate;
        this.type = type;
        this.email = email;
        this.alias = alias;
        this.state = state;
        this.responsibleEmployeeName = responsibleEmployeeName;
    }

    public UUID getRowId() {
        return rowId;
    }

    public String getCompanyNameOrPersonName() {
        return companyNameOrPersonName;
    }

    public String getLegalEntityLegalForm() {
        return legalEntityLegalForm;
    }

    public UUID getFirmOrgStructure() {
        return firmOrgStructure;
    }

    public UUID getPrimaryRelationshipId() {
        return primaryRelationshipId;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public String getLegalEntityBusinessId() {
        return legalEntityBusinessId;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public String getPersonNiNo() {
        return personNiNo;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Integer getVersion() {
        return version;
    }

    public LocalDate getPersonBirthday() {
        return personBirthday;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonTaxRef() {
        return personTaxRef;
    }

    public String getLegalEntityTaxRef() {
        return legalEntityTaxRef;
    }

    public String getPersonSocialSecurityNo() {
        return personSocialSecurityNo;
    }

    public UUID getLegalEntityLegalFormType() {
        return legalEntityLegalFormType;
    }

    public String getPersonProfession() {
        return personProfession;
    }

    public String getCustomLegalEntityLegalForm() {
        return customLegalEntityLegalForm;
    }

    public String getContactCode() {
        return contactCode;
    }

    public UUID getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public Integer getBirthdaySort() {
        return birthdaySort;
    }

    public String getLegalEntityBusiness() {
        return legalEntityBusiness;
    }

    public LocalDate getLegalEntityFoundingDate() {
        return legalEntityFoundingDate;
    }

    public Integer getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getAlias() {
        return alias;
    }

    public Integer getState() {
        return state;
    }

    public String getResponsibleEmployeeName() {
        return responsibleEmployeeName;
    }

    public static Map<String, String> headers = new LinkedHashMap<>() {{
        put("companyNameOrPersonName", "Company Name");
        put("legalEntityLegalForm", "Legal Entity");
        put("firmOrgStructure", "Firm Org");
        put("personSurname", "Last Name");
        put("personFirstName", "First Name");
        put("orgNumber", "Org Number");
        put("personNiNo", "Person Ni Number");
        put("personNumber", "Person Number");
        put("personBirthday", "Birthday");
        put("personTaxRef", "Person Tax Ref");
        put("legalEntityTaxRef", "Legal Entity Tax Ref");
        put("personProfession", "Profession");
        put("contactCode", "Contact Code");
        put("legalEntityBusiness", "Legal Entity Business");
        put("legalEntityFoundingDate", "Legal Entity Founding date");
        put("email", "Email");
        put("alias", "Alias");
        put("responsibleEmployeeName", "Responsible Employee");
    }};
}