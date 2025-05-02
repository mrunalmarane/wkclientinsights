package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "relationshiptype", schema = "cpm")
public class RelationshipType {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "source")
    private Integer source;

    @Column(name = "assignedgroup")
    private UUID assignedGroup;

    @Column(name = "searchstring", length = Integer.MAX_VALUE)
    private String searchString;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "version")
    private Integer version;

    public UUID getRowId() {
        return rowId;
    }

    public void setRowId(UUID rowid) {
        this.rowId = rowid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public UUID getAssignedGroup() {
        return assignedGroup;
    }

    public void setAssignedGroup(UUID assignedgroup) {
        this.assignedGroup = assignedgroup;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchstring) {
        this.searchString = searchstring;
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
}