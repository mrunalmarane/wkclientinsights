package com.client.insights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * DTO for {@link com.client.insights.entity.ApplicationConnection}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationConnectionDto implements Serializable {
    private final UUID rowId;
    private final String name;
    private final UUID clientId;
    private final UUID externalClientId;
    private final UUID connectedApplicationId;
    private final Integer subscriptionState;
    private final Boolean isDeleted;
    private final Boolean isActive;
    private final Integer version;
    private final String contactCode;
    private final String clientName;

    public ApplicationConnectionDto(UUID rowId, String name, UUID clientId, UUID externalClientId, UUID connectedApplicationId, Integer subscriptionState, Boolean isDeleted, Boolean isActive, Integer version, String contactCode, String clientName) {
        this.rowId = rowId;
        this.name = name;
        this.clientId = clientId;
        this.externalClientId = externalClientId;
        this.connectedApplicationId = connectedApplicationId;
        this.subscriptionState = subscriptionState;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.version = version;
        this.contactCode = contactCode;
        this.clientName = clientName;
    }

    public UUID getRowId() {
        return rowId;
    }

    public String getName() {
        return name;
    }

    public UUID getClientId() {
        return clientId;
    }

    public UUID getExternalClientId() {
        return externalClientId;
    }

    public UUID getConnectedApplicationId() {
        return connectedApplicationId;
    }

    public Integer getSubscriptionState() {
        return subscriptionState;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Integer getVersion() {
        return version;
    }

    public String getClientName() {
        return clientName;
    }

    public String getContactCode() {
        return contactCode;
    }

    public static Map<String, String> headers = new LinkedHashMap<>() {{
        put("name", "Connected Application Name");
        put("contactCode", "Client Code");
        put("clientName", "Client Name");
    }};
}