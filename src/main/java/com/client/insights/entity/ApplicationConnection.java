package com.client.insights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import java.util.UUID;

@Entity
@Table(name = "applicationconnection", schema = "cpm")
public class ApplicationConnection {
    @Id
    @Column(name = "rowid", nullable = false)
    private UUID rowId;

    @Column(name = "name")
    private String name;

    @Column(name = "clientid")
    private UUID clientId;

    @Column(name = "externalclientid")
    private UUID externalClientId;

    @Column(name = "connectedapplicationid")
    private UUID connectedApplicationId;

    @Column(name = "subscriptionstate")
    private Integer subscriptionState;

    @ColumnDefault("false")
    @Column(name = "isdeleted", nullable = false)
    private Boolean isDeleted = false;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "version")
    private Integer version;

    @Transient
    private String contactCode;

    @Transient
    private String clientName;

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

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientid) {
        this.clientId = clientid;
    }

    public UUID getExternalClientId() {
        return externalClientId;
    }

    public void setExternalClientId(UUID externalclientid) {
        this.externalClientId = externalclientid;
    }

    public UUID getConnectedApplicationId() {
        return connectedApplicationId;
    }

    public void setConnectedApplicationId(UUID connectedapplicationid) {
        this.connectedApplicationId = connectedapplicationid;
    }

    public Integer getSubscriptionState() {
        return subscriptionState;
    }

    public void setSubscriptionState(Integer subscriptionstate) {
        this.subscriptionState = subscriptionstate;
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

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}