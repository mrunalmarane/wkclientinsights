package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "contactprojection", schema = "cpm")
public class ContactProjection {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "no")
    private String no;

    @Column(name = "type")
    private Integer type;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "contactname", length = Integer.MAX_VALUE)
    private String contactName;

    @Column(name = "employeeid")
    private UUID employeeId;

    @Column(name = "clientmanager", length = Integer.MAX_VALUE)
    private String clientManager;

    @Column(name = "nextduedate")
    private LocalDate nextDueDate;

    @Column(name = "searchstringnew", length = Integer.MAX_VALUE)
    private String searchStringNew;

    @Column(name = "contactcode")
    private String contactCode;

    @Column(name = "contactcodeaslong")
    private Long contactCodeAsLong;

    @Column(name = "contactstate")
    private Integer contactState;

    @Column(name = "sortstring", length = Integer.MAX_VALUE)
    private String sortString;

    @Column(name = "orgunitid")
    private UUID orgUnitId;

    @Column(name = "displayname", length = 1285)
    private String displayName;

    @Column(name = "contactprofession")
    private String contactProfession;

    @Column(name = "contactbusiness")
    private String contactBusiness;

    @Column(name = "urlavatar")
    private String urlAvatar;

    @Column(name = "authorizedclientstartdate")
    private LocalDate authorizedClientStartDate;

    @Column(name = "authorizedclientenddate")
    private LocalDate authorizedClientEndDate;

    @Column(name = "authorizedclientenddatereason", length = Integer.MAX_VALUE)
    private String authorizedClientEndDateReason;

    @Column(name = "alias", length = Integer.MAX_VALUE)
    private String alias;

    @Column(name = "searchstringwithalias", length = Integer.MAX_VALUE)
    private String searchStringWithAlias;

    @Column(name = "clientmanageralias", length = Integer.MAX_VALUE)
    private String clientManagerAlias;

    @Column(name = "firmorgstructure")
    private UUID firmOrgStructure;

    @Column(name = "contactid")
    private UUID contactId;

    @ColumnDefault("false")
    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted = false;

    public UUID getRowId() {
        return rowId;
    }

    public void setRowId(UUID rowid) {
        this.rowId = rowid;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isactive) {
        this.isActive = isactive;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyname) {
        this.companyName = companyname;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactname) {
        this.contactName = contactname;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeid) {
        this.employeeId = employeeid;
    }

    public String getClientManager() {
        return clientManager;
    }

    public void setClientManager(String clientmanager) {
        this.clientManager = clientmanager;
    }

    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextduedate) {
        this.nextDueDate = nextduedate;
    }

    public String getSearchStringNew() {
        return searchStringNew;
    }

    public void setSearchStringNew(String searchstringnew) {
        this.searchStringNew = searchstringnew;
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactcode) {
        this.contactCode = contactcode;
    }

    public Long getContactCodeAsLong() {
        return contactCodeAsLong;
    }

    public void setContactCodeAsLong(Long contactcodeaslong) {
        this.contactCodeAsLong = contactcodeaslong;
    }

    public Integer getContactState() {
        return contactState;
    }

    public void setContactState(Integer contactstate) {
        this.contactState = contactstate;
    }

    public String getSortString() {
        return sortString;
    }

    public void setSortString(String sortstring) {
        this.sortString = sortstring;
    }

    public UUID getOrgUnitId() {
        return orgUnitId;
    }

    public void setOrgUnitId(UUID orgunitid) {
        this.orgUnitId = orgunitid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayname) {
        this.displayName = displayname;
    }

    public String getContactProfession() {
        return contactProfession;
    }

    public void setContactProfession(String contactprofession) {
        this.contactProfession = contactprofession;
    }

    public String getContactBusiness() {
        return contactBusiness;
    }

    public void setContactBusiness(String contactbusiness) {
        this.contactBusiness = contactbusiness;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlavatar) {
        this.urlAvatar = urlavatar;
    }

    public LocalDate getAuthorizedClientStartDate() {
        return authorizedClientStartDate;
    }

    public void setAuthorizedClientStartDate(LocalDate authorizedclientstartdate) {
        this.authorizedClientStartDate = authorizedclientstartdate;
    }

    public LocalDate getAuthorizedClientEndDate() {
        return authorizedClientEndDate;
    }

    public void setAuthorizedClientEndDate(LocalDate authorizedclientenddate) {
        this.authorizedClientEndDate = authorizedclientenddate;
    }

    public String getAuthorizedClientEndDateReason() {
        return authorizedClientEndDateReason;
    }

    public void setAuthorizedClientEndDateReason(String authorizedclientenddatereason) {
        this.authorizedClientEndDateReason = authorizedclientenddatereason;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSearchStringWithAlias() {
        return searchStringWithAlias;
    }

    public void setSearchStringWithAlias(String searchstringwithalias) {
        this.searchStringWithAlias = searchstringwithalias;
    }

    public String getClientManagerAlias() {
        return clientManagerAlias;
    }

    public void setClientManagerAlias(String clientmanageralias) {
        this.clientManagerAlias = clientmanageralias;
    }

    public UUID getFirmOrgStructure() {
        return firmOrgStructure;
    }

    public void setFirmOrgStructure(UUID firmorgstructure) {
        this.firmOrgStructure = firmorgstructure;
    }

    public UUID getContactId() {
        return contactId;
    }

    public void setContactId(UUID contactid) {
        this.contactId = contactid;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isdeleted) {
        this.isDeleted = isdeleted;
    }
}
