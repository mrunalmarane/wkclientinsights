package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Entity
@Table(name = "clientteamprojection", schema = "cpm")
public class ClientTeamProjection {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "clientid")
    private UUID clientId;

    @Column(name = "contactname", length = Integer.MAX_VALUE)
    private String contactName;

    @Column(name = "companyname", length = Integer.MAX_VALUE)
    private String companyName;

    @Column(name = "contactavatar")
    private String contactAvatar;

    @Column(name = "contactdisplayname", length = Integer.MAX_VALUE)
    private String contactDisplayName;

    @Column(name = "contacttype")
    private Integer contactType;

    @Column(name = "employeeid")
    private UUID employeeId;

    @Column(name = "employeename", length = 1026)
    private String employeeName;

    @Column(name = "roleid")
    private UUID roleId;

    @Column(name = "rolename", length = 254)
    private String roleName;

    @Column(name = "searchstring", length = Integer.MAX_VALUE)
    private String searchString;

    @Column(name = "searchstringwithalias", length = Integer.MAX_VALUE)
    private String searchStringWithAlias;

    @Column(name = "employeenumber")
    private Long employeeNumber;

    @Column(name = "employeestringno")
    private String employeeStringNo;

    @Column(name = "employeeavatar")
    private String employeeAvatar;

    @Column(name = "employeealias")
    private String employeeAlias;

    @Column(name = "contactalias", length = Integer.MAX_VALUE)
    private String contactAlias;

    @ColumnDefault("false")
    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted = false;

    public UUID getRowId() {
        return rowId;
    }

    public void setRowId(UUID rowid) {
        this.rowId = rowid;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientid) {
        this.clientId = clientid;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactname) {
        this.contactName = contactname;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyname) {
        this.companyName = companyname;
    }

    public String getContactAvatar() {
        return contactAvatar;
    }

    public void setContactAvatar(String contactavatar) {
        this.contactAvatar = contactavatar;
    }

    public String getContactDisplayName() {
        return contactDisplayName;
    }

    public void setContactDisplayName(String contactdisplayname) {
        this.contactDisplayName = contactdisplayname;
    }

    public Integer getContactType() {
        return contactType;
    }

    public void setContactType(Integer contacttype) {
        this.contactType = contacttype;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeid) {
        this.employeeId = employeeid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeename) {
        this.employeeName = employeename;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleid) {
        this.roleId = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String rolename) {
        this.roleName = rolename;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchstring) {
        this.searchString = searchstring;
    }

    public String getSearchStringWithAlias() {
        return searchStringWithAlias;
    }

    public void setSearchStringWithAlias(String searchstringwithalias) {
        this.searchStringWithAlias = searchstringwithalias;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeenumber) {
        this.employeeNumber = employeenumber;
    }

    public String getEmployeeStringNo() {
        return employeeStringNo;
    }

    public void setEmployeeStringNo(String employeestringno) {
        this.employeeStringNo = employeestringno;
    }

    public String getEmployeeAvatar() {
        return employeeAvatar;
    }

    public void setEmployeeAvatar(String employeeavatar) {
        this.employeeAvatar = employeeavatar;
    }

    public String getEmployeeAlias() {
        return employeeAlias;
    }

    public void setEmployeeAlias(String employeealias) {
        this.employeeAlias = employeealias;
    }

    public String getContactAlias() {
        return contactAlias;
    }

    public void setContactAlias(String contactalias) {
        this.contactAlias = contactalias;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isdeleted) {
        this.isDeleted = isdeleted;
    }
}
