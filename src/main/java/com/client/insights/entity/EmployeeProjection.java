package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employeeprojection", schema = "cpm")
public class EmployeeProjection {
    @Id
    @Column(name = "rowid")
    private UUID id;

    @Column(name = "fullname", length = Integer.MAX_VALUE)
    private String fullname;

    @Column(name = "alias", length = Integer.MAX_VALUE)
    private String alias;

    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;

    @Size(max = 255)
    @Column(name = "middlename")
    private String middlename;

    @Size(max = 255)
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "employeenumber")
    private Long employeenumber;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "birthdaysort")
    private Integer birthdaysort;

    @Column(name = "relationids")
    private List<UUID> relationids;

    @Column(name = "orgunitid")
    private UUID orgunitid;

    @Size(max = 255)
    @Column(name = "orgunitname")
    private String orgunitname;

    @Column(name = "hiringdate")
    private LocalDate hiringdate;

    @Column(name = "terminationdate")
    private LocalDate terminationdate;

    @Column(name = "addresstype")
    private UUID addresstype;

    @Column(name = "addressline", length = Integer.MAX_VALUE)
    private String addressline;

    @Column(name = "phonetype1")
    private UUID phonetype1;

    @Size(max = 255)
    @Column(name = "phonenumber1")
    private String phonenumber1;

    @Column(name = "phonetype2")
    private UUID phonetype2;

    @Size(max = 255)
    @Column(name = "phonenumber2")
    private String phonenumber2;

    @Column(name = "searchstring", length = Integer.MAX_VALUE)
    private String searchstring;

    @Column(name = "searchstringwithalias", length = Integer.MAX_VALUE)
    private String searchstringwithalias;

    @Column(name = "employeeisactive")
    private Boolean employeeisactive;

    @Size(max = 255)
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "emailtype")
    private UUID emailtype;

    @Size(max = 255)
    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "employeestringno")
    private String employeestringno;

    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @Size(max = 255)
    @Column(name = "lastnameprefix")
    private String lastnameprefix;

    @Column(name = "isavailableindocuware")
    private Boolean isavailableindocuware;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getEmployeenumber() {
        return employeenumber;
    }

    public void setEmployeenumber(Long employeenumber) {
        this.employeenumber = employeenumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Integer getBirthdaysort() {
        return birthdaysort;
    }

    public void setBirthdaysort(Integer birthdaysort) {
        this.birthdaysort = birthdaysort;
    }

    public List<UUID> getRelationids() {
        return relationids;
    }

    public void setRelationids(List<UUID> relationids) {
        this.relationids = relationids;
    }

    public UUID getOrgunitid() {
        return orgunitid;
    }

    public void setOrgunitid(UUID orgunitid) {
        this.orgunitid = orgunitid;
    }

    public String getOrgunitname() {
        return orgunitname;
    }

    public void setOrgunitname(String orgunitname) {
        this.orgunitname = orgunitname;
    }

    public LocalDate getHiringdate() {
        return hiringdate;
    }

    public void setHiringdate(LocalDate hiringdate) {
        this.hiringdate = hiringdate;
    }

    public LocalDate getTerminationdate() {
        return terminationdate;
    }

    public void setTerminationdate(LocalDate terminationdate) {
        this.terminationdate = terminationdate;
    }

    public UUID getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(UUID addresstype) {
        this.addresstype = addresstype;
    }

    public String getAddressline() {
        return addressline;
    }

    public void setAddressline(String addressline) {
        this.addressline = addressline;
    }

    public UUID getPhonetype1() {
        return phonetype1;
    }

    public void setPhonetype1(UUID phonetype1) {
        this.phonetype1 = phonetype1;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public UUID getPhonetype2() {
        return phonetype2;
    }

    public void setPhonetype2(UUID phonetype2) {
        this.phonetype2 = phonetype2;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getSearchstring() {
        return searchstring;
    }

    public void setSearchstring(String searchstring) {
        this.searchstring = searchstring;
    }

    public String getSearchstringwithalias() {
        return searchstringwithalias;
    }

    public void setSearchstringwithalias(String searchstringwithalias) {
        this.searchstringwithalias = searchstringwithalias;
    }

    public Boolean getEmployeeisactive() {
        return employeeisactive;
    }

    public void setEmployeeisactive(Boolean employeeisactive) {
        this.employeeisactive = employeeisactive;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public UUID getEmailtype() {
        return emailtype;
    }

    public void setEmailtype(UUID emailtype) {
        this.emailtype = emailtype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeestringno() {
        return employeestringno;
    }

    public void setEmployeestringno(String employeestringno) {
        this.employeestringno = employeestringno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastnameprefix() {
        return lastnameprefix;
    }

    public void setLastnameprefix(String lastnameprefix) {
        this.lastnameprefix = lastnameprefix;
    }

    public Boolean getIsavailableindocuware() {
        return isavailableindocuware;
    }

    public void setIsavailableindocuware(Boolean isavailableindocuware) {
        this.isavailableindocuware = isavailableindocuware;
    }

}