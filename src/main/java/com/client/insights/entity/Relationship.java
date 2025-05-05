package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "relationship", schema = "cpm")
public class Relationship {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "sourcecontactid")
    private UUID sourceContactId;

    @Column(name = "targetcontactid")
    private UUID targetContactId;

    @Column(name = "relationshiptypeidsfromallperiods")
    private List<UUID> relationshipTypeIdsFromAllPeriods;

    @Column(name = "collaborationpartnerroleids")
    private List<UUID> collaborationPartnerRoleIds;

    @ColumnDefault("false")
    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted = false;

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

    public UUID getSourceContactId() {
        return sourceContactId;
    }

    public void setSourceContactId(UUID sourcecontactid) {
        this.sourceContactId = sourcecontactid;
    }

    public UUID getTargetContactId() {
        return targetContactId;
    }

    public void setTargetContactId(UUID targetcontactid) {
        this.targetContactId = targetcontactid;
    }

    public List<UUID> getRelationshipTypeIdsFromAllPeriods() {
        return relationshipTypeIdsFromAllPeriods;
    }

    public void setRelationshipTypeIdsFromAllPeriods(List<UUID> relationshiptypeidsfromallperiods) {
        this.relationshipTypeIdsFromAllPeriods = relationshiptypeidsfromallperiods;
    }

    public List<UUID> getCollaborationPartnerRoleIds() {
        return collaborationPartnerRoleIds;
    }

    public void setCollaborationPartnerRoleIds(List<UUID> collaborationpartnerroleids) {
        this.collaborationPartnerRoleIds = collaborationpartnerroleids;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isdeleted) {
        this.isDeleted = isdeleted;
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
