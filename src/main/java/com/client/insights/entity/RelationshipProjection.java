package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "relationshipprojection", schema = "cpm")
public class RelationshipProjection {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "relationshipid")
    private UUID relationshipId;

    @Column(name = "viewercontactid")
    private UUID viewerContactId;

    @Column(name = "directionseenfromviewer")
    private Integer directionSeenFromViewer;

    @ColumnDefault("false")
    @Column(name = "isprimaryofviewer", nullable = false)
    private Boolean isPrimaryOfViewer = false;

    @Column(name = "currentrelationshiptypeids")
    private List<UUID> currentRelationshipTypeIds;

    @Column(name = "currentrelationshiptypenames")
    private List<String> currentRelationshipTypeNames;

    @Column(name = "currentrelationshiptypegroupids")
    private List<UUID> currentRelationshipTypeGroupIds;

    @Column(name = "currentrelationshiptypegroupnames")
    private List<String> currentRelationshipTypeGroupNames;

    @Column(name = "partnercontactid")
    private UUID partnerContactId;

    @Column(name = "partneravatar")
    private String partnerAvatar;

    @Column(name = "partnercontacttype")
    private Integer partnerContactType;

    @Column(name = "partnername", length = Integer.MAX_VALUE)
    private String partnerName;

    @Column(name = "alias", length = Integer.MAX_VALUE)
    private String alias;

    @Column(name = "partneremail")
    private String partnerEmail;

    @Column(name = "partnerphone")
    private String partnerPhone;

    @Column(name = "searchstring", length = Integer.MAX_VALUE)
    private String searchString;

    @Column(name = "searchstringwithalias", length = Integer.MAX_VALUE)
    private String searchStringWithAlias;

    @Column(name = "recalculationrequired")
    private LocalDate reCalculationRequired;

    @ColumnDefault("true")
    @Column(name = "isactive", nullable = false)
    private Boolean isActive = false;

    @Column(name = "currentcollaborationpartnerroleids")
    private List<UUID> currentCollaborationPartnerRoleIds;

    @Column(name = "currentcollaborationpartnerrolenames")
    private List<String> currentCollaborationPartnerRoleNames;

    @ColumnDefault("false")
    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted = false;

    public UUID getRowId() {
        return rowId;
    }

    public void setRowId(UUID rowid) {
        this.rowId = rowid;
    }

    public UUID getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(UUID relationshipid) {
        this.relationshipId = relationshipid;
    }

    public UUID getViewerContactId() {
        return viewerContactId;
    }

    public void setViewerContactId(UUID viewercontactid) {
        this.viewerContactId = viewercontactid;
    }

    public Integer getDirectionSeenFromViewer() {
        return directionSeenFromViewer;
    }

    public void setDirectionSeenFromViewer(Integer directionseenfromviewer) {
        this.directionSeenFromViewer = directionseenfromviewer;
    }

    public Boolean getIsPrimaryOfViewer() {
        return isPrimaryOfViewer;
    }

    public void setIsPrimaryOfViewer(Boolean isprimaryofviewer) {
        this.isPrimaryOfViewer = isprimaryofviewer;
    }

    public List<UUID> getCurrentRelationshipTypeIds() {
        return currentRelationshipTypeIds;
    }

    public void setCurrentRelationshipTypeIds(List<UUID> currentrelationshiptypeids) {
        this.currentRelationshipTypeIds = currentrelationshiptypeids;
    }

    public List<String> getCurrentRelationshipTypeNames() {
        return currentRelationshipTypeNames;
    }

    public void setCurrentRelationshipTypeNames(List<String> currentrelationshiptypenames) {
        this.currentRelationshipTypeNames = currentrelationshiptypenames;
    }

    public List<UUID> getCurrentRelationshipTypeGroupIds() {
        return currentRelationshipTypeGroupIds;
    }

    public void setCurrentRelationshipTypeGroupIds(List<UUID> currentrelationshiptypegroupids) {
        this.currentRelationshipTypeGroupIds = currentrelationshiptypegroupids;
    }

    public List<String> getCurrentRelationshipTypeGroupNames() {
        return currentRelationshipTypeGroupNames;
    }

    public void setCurrentRelationshipTypeGroupNames(List<String> currentrelationshiptypegroupnames) {
        this.currentRelationshipTypeGroupNames = currentrelationshiptypegroupnames;
    }

    public UUID getPartnerContactId() {
        return partnerContactId;
    }

    public void setPartnerContactId(UUID partnercontactid) {
        this.partnerContactId = partnercontactid;
    }

    public String getPartnerAvatar() {
        return partnerAvatar;
    }

    public void setPartnerAvatar(String partneravatar) {
        this.partnerAvatar = partneravatar;
    }

    public Integer getPartnerContactType() {
        return partnerContactType;
    }

    public void setPartnerContactType(Integer partnercontacttype) {
        this.partnerContactType = partnercontacttype;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnername) {
        this.partnerName = partnername;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPartnerEmail() {
        return partnerEmail;
    }

    public void setPartnerEmail(String partneremail) {
        this.partnerEmail = partneremail;
    }

    public String getPartnerPhone() {
        return partnerPhone;
    }

    public void setPartnerPhone(String partnerphone) {
        this.partnerPhone = partnerphone;
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

    public LocalDate getReCalculationRequired() {
        return reCalculationRequired;
    }

    public void setReCalculationRequired(LocalDate recalculationrequired) {
        this.reCalculationRequired = recalculationrequired;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isactive) {
        this.isActive = isactive;
    }

    public List<UUID> getCurrentCollaborationPartnerRoleIds() {
        return currentCollaborationPartnerRoleIds;
    }

    public void setCurrentCollaborationPartnerRoleIds(List<UUID> currentcollaborationpartnerroleids) {
        this.currentCollaborationPartnerRoleIds = currentcollaborationpartnerroleids;
    }

    public List<String> getCurrentCollaborationPartnerRoleNames() {
        return currentCollaborationPartnerRoleNames;
    }

    public void setCurrentCollaborationPartnerRoleNames(List<String> currentcollaborationpartnerrolenames) {
        this.currentCollaborationPartnerRoleNames = currentcollaborationpartnerrolenames;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isdeleted) {
        this.isDeleted = isdeleted;
    }
}
