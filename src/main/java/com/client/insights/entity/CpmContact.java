package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Where;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "cpm_contact", schema = "cpm")
public class CpmContact {
    @Id
    @Column(name = "rowid")
    private UUID rowId;

    @Column(name = "companynameorpersonname")
    private String companyNameOrPersonName;

    @Column(name = "legalentitylegalform")
    private String legalEntityLegalForm;

    @Column(name = "firmorgstructure")
    private UUID firmOrgStructure;

    @Column(name = "primaryrelationshipid")
    private UUID primaryRelationshipId;

    @Column(name = "profileid")
    private UUID profileId;

    @Column(name = "personsurname")
    private String personSurname;

    @Column(name = "legalentitybusinessid")
    private String legalEntityBusinessId;

    @Column(name = "orgnumber")
    private String orgNumber;

    @Column(name = "memberid")
    private UUID memberId;

    @Column(name = "personnino")
    private String personNiNo;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    @Column(name = "personnumber")
    private String personNumber;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "version")
    private Integer version;

    @Column(name = "personbirthday")
    private LocalDate personBirthday;

    @Column(name = "dynamiccolumns")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> dynamicColumns;

    @Column(name = "personfirstname")
    private String personFirstName;

    @Column(name = "persontaxref")
    private String personTaxRef;

    @Column(name = "legalentitytaxref")
    private String legalEntityTaxRef;

    @Column(name = "personsocialsecurityno")
    private String personSocialSecurityNo;

    @Column(name = "legalentitylegalformtype")
    private UUID legalEntityLegalFormType;

    @Column(name = "personprofession")
    private String personProfession;

    @Column(name = "customlegalentitylegalform")
    private String customLegalEntityLegalForm;

    @Column(name = "contactcode")
    private String contactCode;

    @Column(name = "responsibleemployee")
    private UUID responsibleEmployee;

    @Column(name = "birthdaysort")
    private Integer birthdaySort;

    @Column(name = "legalentitybusiness")
    private String legalEntityBusiness;

    @Column(name = "legalentityfoundingdate")
    private LocalDate legalEntityFoundingDate;

    @Column(name = "type")
    private Integer type;

    @Column(name = "email")
    private String email;

    @Column(name = "alias")
    private String alias;

    @Column(name = "state")
    private Integer state;

    @Transient
    private String responsibleEmployeeName;

    public UUID getRowId() {
        return rowId;
    }

    public void setRowId(UUID rowId) {
        this.rowId = rowId;
    }

    public String getCompanyNameOrPersonName() {
        return companyNameOrPersonName;
    }

    public void setCompanyNameOrPersonName(String companynameorpersonname) {
        this.companyNameOrPersonName = companynameorpersonname;
    }

    public String getLegalEntityLegalForm() {
        return legalEntityLegalForm;
    }

    public void setLegalEntityLegalForm(String legalentitylegalform) {
        this.legalEntityLegalForm = legalentitylegalform;
    }

    public UUID getFirmOrgStructure() {
        return firmOrgStructure;
    }

    public void setFirmOrgStructure(UUID firmorgstructure) {
        this.firmOrgStructure = firmorgstructure;
    }

    public UUID getPrimaryRelationshipId() {
        return primaryRelationshipId;
    }

    public void setPrimaryRelationshipId(UUID primaryrelationshipid) {
        this.primaryRelationshipId = primaryrelationshipid;
    }

    public UUID getProfileId() {
        return profileId;
    }

    public void setProfileId(UUID profileid) {
        this.profileId = profileid;
    }

    public String getPersonSurname() {
        return personSurname;
    }

    public void setPersonSurname(String personsurname) {
        this.personSurname = personsurname;
    }

    public String getLegalEntityBusinessId() {
        return legalEntityBusinessId;
    }

    public void setLegalEntityBusinessId(String legalentitybusinessid) {
        this.legalEntityBusinessId = legalentitybusinessid;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgnumber) {
        this.orgNumber = orgnumber;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberid) {
        this.memberId = memberid;
    }

    public String getPersonNiNo() {
        return personNiNo;
    }

    public void setPersonNiNo(String personnino) {
        this.personNiNo = personnino;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isdeleted) {
        this.isDeleted = isdeleted;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personnumber) {
        this.personNumber = personnumber;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isactive) {
        this.isActive = isactive;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDate getPersonBirthday() {
        return personBirthday;
    }

    public void setPersonBirthday(LocalDate personbirthday) {
        this.personBirthday = personbirthday;
    }

    public Map<String, Object> getDynamicColumns() {
        return dynamicColumns;
    }

    public void setDynamicColumns(Map<String, Object> dynamiccolumns) {
        this.dynamicColumns = dynamiccolumns;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personfirstname) {
        this.personFirstName = personfirstname;
    }

    public String getPersonTaxRef() {
        return personTaxRef;
    }

    public void setPersonTaxRef(String persontaxref) {
        this.personTaxRef = persontaxref;
    }

    public String getLegalEntityTaxRef() {
        return legalEntityTaxRef;
    }

    public void setLegalEntityTaxRef(String legalentitytaxref) {
        this.legalEntityTaxRef = legalentitytaxref;
    }

    public String getPersonSocialSecurityNo() {
        return personSocialSecurityNo;
    }

    public void setPersonSocialSecurityNo(String personsocialsecurityno) {
        this.personSocialSecurityNo = personsocialsecurityno;
    }

    public UUID getLegalEntityLegalFormType() {
        return legalEntityLegalFormType;
    }

    public void setLegalEntityLegalFormType(UUID legalentitylegalformtype) {
        this.legalEntityLegalFormType = legalentitylegalformtype;
    }

    public String getPersonProfession() {
        return personProfession;
    }

    public void setPersonProfession(String personprofession) {
        this.personProfession = personprofession;
    }

    public String getCustomLegalEntityLegalForm() {
        return customLegalEntityLegalForm;
    }

    public void setCustomLegalEntityLegalForm(String customlegalentitylegalform) {
        this.customLegalEntityLegalForm = customlegalentitylegalform;
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactcode) {
        this.contactCode = contactcode;
    }

    public UUID getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public void setResponsibleEmployee(UUID responsibleemployee) {
        this.responsibleEmployee = responsibleemployee;
    }

    public Integer getBirthdaySort() {
        return birthdaySort;
    }

    public void setBirthdaySort(Integer birthdaysort) {
        this.birthdaySort = birthdaysort;
    }

    public String getLegalEntityBusiness() {
        return legalEntityBusiness;
    }

    public void setLegalEntityBusiness(String legalentitybusiness) {
        this.legalEntityBusiness = legalentitybusiness;
    }

    public LocalDate getLegalEntityFoundingDate() {
        return legalEntityFoundingDate;
    }

    public void setLegalEntityFoundingDate(LocalDate legalentityfoundingdate) {
        this.legalEntityFoundingDate = legalentityfoundingdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getResponsibleEmployeeName() {
        return responsibleEmployeeName;
    }

    public void setResponsibleEmployeeName(String responsibleEmployeeName) {
        this.responsibleEmployeeName = responsibleEmployeeName;
    }

}