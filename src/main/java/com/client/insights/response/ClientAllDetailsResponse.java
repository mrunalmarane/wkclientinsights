package com.client.insights.response;

import com.client.insights.entity.ApplicationConnection;
import com.client.insights.entity.ClientTeamProjection;
import com.client.insights.entity.CpmContact;
import com.client.insights.entity.Relationship;
import com.client.insights.entity.RelationshipProjection;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;


@Schema(name = "ClientAllDetailsResponse")
public class ClientAllDetailsResponse {


    List<ApplicationConnection> applicationConnection;
    List<ClientTeamProjection> clientTeamProjection;
    CpmContact cpmContact;
    List<RelationshipProjection> relationshipProjections;

    public List<ApplicationConnection> getApplicationConnection() {
        return applicationConnection;
    }

    public void setApplicationConnection(List<ApplicationConnection> applicationConnection) {
        this.applicationConnection = applicationConnection;
    }

    public List<ClientTeamProjection> getClientTeamProjection() {
        return clientTeamProjection;
    }

    public void setClientTeamProjection(List<ClientTeamProjection> clientTeamProjection) {
        this.clientTeamProjection = clientTeamProjection;
    }

    public CpmContact getCpmContact() {
        return cpmContact;
    }

    public void setCpmContact(CpmContact cpmContact) {
        this.cpmContact = cpmContact;
    }

    public List<RelationshipProjection> getRelationshipProjections() {
        return relationshipProjections;
    }

    public void setRelationship(List<RelationshipProjection> relationshipProjections) {
        this.relationshipProjections = relationshipProjections;
    }
}
