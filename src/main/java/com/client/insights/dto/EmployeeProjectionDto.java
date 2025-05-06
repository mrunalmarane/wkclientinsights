package com.client.insights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.client.insights.entity.EmployeeProjection}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeProjectionDto implements Serializable {
    private final UUID id;
    private final String fullname;
    private final String alias;
    @Size(max = 255)
    private final String firstname;
    @Size(max = 255)
    private final String middlename;
    @Size(max = 255)
    private final String lastname;
    private final Long employeenumber;
    private final LocalDate birthday;
    private final Integer birthdaysort;
    private final List<List<UUID>> relationids;
    private final UUID orgunitid;
    @Size(max = 255)
    private final String orgunitname;
    private final LocalDate hiringdate;
    private final LocalDate terminationdate;
    private final UUID addresstype;
    private final String addressline;
    private final UUID phonetype1;
    @Size(max = 255)
    private final String phonenumber1;
    private final UUID phonetype2;
    @Size(max = 255)
    private final String phonenumber2;
    private final String searchstring;
    private final String searchstringwithalias;
    private final Boolean employeeisactive;
    @Size(max = 255)
    private final String avatar;
    private final UUID emailtype;
    @Size(max = 255)
    private final String email;
    @Size(max = 255)
    private final String employeestringno;
    @Size(max = 255)
    private final String title;
    @Size(max = 255)
    private final String lastnameprefix;
    private final Boolean isavailableindocuware;

    public EmployeeProjectionDto(UUID id, String fullname, String alias, String firstname, String middlename, String lastname, Long employeenumber, LocalDate birthday, Integer birthdaysort, List<List<UUID>> relationids, UUID orgunitid, String orgunitname, LocalDate hiringdate, LocalDate terminationdate, UUID addresstype, String addressline, UUID phonetype1, String phonenumber1, UUID phonetype2, String phonenumber2, String searchstring, String searchstringwithalias, Boolean employeeisactive, String avatar, UUID emailtype, String email, String employeestringno, String title, String lastnameprefix, Boolean isavailableindocuware) {
        this.id = id;
        this.fullname = fullname;
        this.alias = alias;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.employeenumber = employeenumber;
        this.birthday = birthday;
        this.birthdaysort = birthdaysort;
        this.relationids = relationids;
        this.orgunitid = orgunitid;
        this.orgunitname = orgunitname;
        this.hiringdate = hiringdate;
        this.terminationdate = terminationdate;
        this.addresstype = addresstype;
        this.addressline = addressline;
        this.phonetype1 = phonetype1;
        this.phonenumber1 = phonenumber1;
        this.phonetype2 = phonetype2;
        this.phonenumber2 = phonenumber2;
        this.searchstring = searchstring;
        this.searchstringwithalias = searchstringwithalias;
        this.employeeisactive = employeeisactive;
        this.avatar = avatar;
        this.emailtype = emailtype;
        this.email = email;
        this.employeestringno = employeestringno;
        this.title = title;
        this.lastnameprefix = lastnameprefix;
        this.isavailableindocuware = isavailableindocuware;
    }

    public UUID getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAlias() {
        return alias;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getEmployeenumber() {
        return employeenumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Integer getBirthdaysort() {
        return birthdaysort;
    }

    public List<List<UUID>> getRelationids() {
        return relationids;
    }

    public UUID getOrgunitid() {
        return orgunitid;
    }

    public String getOrgunitname() {
        return orgunitname;
    }

    public LocalDate getHiringdate() {
        return hiringdate;
    }

    public LocalDate getTerminationdate() {
        return terminationdate;
    }

    public UUID getAddresstype() {
        return addresstype;
    }

    public String getAddressline() {
        return addressline;
    }

    public UUID getPhonetype1() {
        return phonetype1;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public UUID getPhonetype2() {
        return phonetype2;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public String getSearchstring() {
        return searchstring;
    }

    public String getSearchstringwithalias() {
        return searchstringwithalias;
    }

    public Boolean getEmployeeisactive() {
        return employeeisactive;
    }

    public String getAvatar() {
        return avatar;
    }

    public UUID getEmailtype() {
        return emailtype;
    }

    public String getEmail() {
        return email;
    }

    public String getEmployeestringno() {
        return employeestringno;
    }

    public String getTitle() {
        return title;
    }

    public String getLastnameprefix() {
        return lastnameprefix;
    }

    public Boolean getIsavailableindocuware() {
        return isavailableindocuware;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProjectionDto entity = (EmployeeProjectionDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.fullname, entity.fullname) &&
                Objects.equals(this.alias, entity.alias) &&
                Objects.equals(this.firstname, entity.firstname) &&
                Objects.equals(this.middlename, entity.middlename) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.employeenumber, entity.employeenumber) &&
                Objects.equals(this.birthday, entity.birthday) &&
                Objects.equals(this.birthdaysort, entity.birthdaysort) &&
                Objects.equals(this.relationids, entity.relationids) &&
                Objects.equals(this.orgunitid, entity.orgunitid) &&
                Objects.equals(this.orgunitname, entity.orgunitname) &&
                Objects.equals(this.hiringdate, entity.hiringdate) &&
                Objects.equals(this.terminationdate, entity.terminationdate) &&
                Objects.equals(this.addresstype, entity.addresstype) &&
                Objects.equals(this.addressline, entity.addressline) &&
                Objects.equals(this.phonetype1, entity.phonetype1) &&
                Objects.equals(this.phonenumber1, entity.phonenumber1) &&
                Objects.equals(this.phonetype2, entity.phonetype2) &&
                Objects.equals(this.phonenumber2, entity.phonenumber2) &&
                Objects.equals(this.searchstring, entity.searchstring) &&
                Objects.equals(this.searchstringwithalias, entity.searchstringwithalias) &&
                Objects.equals(this.employeeisactive, entity.employeeisactive) &&
                Objects.equals(this.avatar, entity.avatar) &&
                Objects.equals(this.emailtype, entity.emailtype) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.employeestringno, entity.employeestringno) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.lastnameprefix, entity.lastnameprefix) &&
                Objects.equals(this.isavailableindocuware, entity.isavailableindocuware);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullname, alias, firstname, middlename, lastname, employeenumber, birthday, birthdaysort, relationids, orgunitid, orgunitname, hiringdate, terminationdate, addresstype, addressline, phonetype1, phonenumber1, phonetype2, phonenumber2, searchstring, searchstringwithalias, employeeisactive, avatar, emailtype, email, employeestringno, title, lastnameprefix, isavailableindocuware);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "fullname = " + fullname + ", " +
                "alias = " + alias + ", " +
                "firstname = " + firstname + ", " +
                "middlename = " + middlename + ", " +
                "lastname = " + lastname + ", " +
                "employeenumber = " + employeenumber + ", " +
                "birthday = " + birthday + ", " +
                "birthdaysort = " + birthdaysort + ", " +
                "relationids = " + relationids + ", " +
                "orgunitid = " + orgunitid + ", " +
                "orgunitname = " + orgunitname + ", " +
                "hiringdate = " + hiringdate + ", " +
                "terminationdate = " + terminationdate + ", " +
                "addresstype = " + addresstype + ", " +
                "addressline = " + addressline + ", " +
                "phonetype1 = " + phonetype1 + ", " +
                "phonenumber1 = " + phonenumber1 + ", " +
                "phonetype2 = " + phonetype2 + ", " +
                "phonenumber2 = " + phonenumber2 + ", " +
                "searchstring = " + searchstring + ", " +
                "searchstringwithalias = " + searchstringwithalias + ", " +
                "employeeisactive = " + employeeisactive + ", " +
                "avatar = " + avatar + ", " +
                "emailtype = " + emailtype + ", " +
                "email = " + email + ", " +
                "employeestringno = " + employeestringno + ", " +
                "title = " + title + ", " +
                "lastnameprefix = " + lastnameprefix + ", " +
                "isavailableindocuware = " + isavailableindocuware + ")";
    }
}