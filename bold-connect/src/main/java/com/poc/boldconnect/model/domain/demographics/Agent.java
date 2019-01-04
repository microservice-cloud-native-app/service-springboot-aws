
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agentId",
    "teamId",
    "teamName",
    "agentAvatar",
    "agentRole",
    "firstName",
    "lastName",
    "displayName",
    "preferredName",
    "agentTypeCode",
    "designation",
    "biography",
    "biographyAvailableFlag",
    "phoneNumber",
    "emailAddress",
    "subAgent"
})
public class Agent {

    @JsonProperty("agentId")
    private String agentId;
    @JsonProperty("teamId")
    private String teamId;
    @JsonProperty("teamName")
    private String teamName;
    @JsonProperty("agentAvatar")
    private String agentAvatar;
    @JsonProperty("agentRole")
    private String agentRole;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("preferredName")
    private String preferredName;
    @JsonProperty("agentTypeCode")
    private String agentTypeCode;
    @JsonProperty("designation")
    private String designation;
    @JsonProperty("biography")
    private String biography;
    @JsonProperty("biographyAvailableFlag")
    private String biographyAvailableFlag;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("subAgent")
    private SubAgent subAgent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("agentId")
    public String getAgentId() {
        return agentId;
    }

    @JsonProperty("agentId")
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    @JsonProperty("teamId")
    public String getTeamId() {
        return teamId;
    }

    @JsonProperty("teamId")
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    @JsonProperty("teamName")
    public String getTeamName() {
        return teamName;
    }

    @JsonProperty("teamName")
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @JsonProperty("agentAvatar")
    public String getAgentAvatar() {
        return agentAvatar;
    }

    @JsonProperty("agentAvatar")
    public void setAgentAvatar(String agentAvatar) {
        this.agentAvatar = agentAvatar;
    }

    @JsonProperty("agentRole")
    public String getAgentRole() {
        return agentRole;
    }

    @JsonProperty("agentRole")
    public void setAgentRole(String agentRole) {
        this.agentRole = agentRole;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("preferredName")
    public String getPreferredName() {
        return preferredName;
    }

    @JsonProperty("preferredName")
    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    @JsonProperty("agentTypeCode")
    public String getAgentTypeCode() {
        return agentTypeCode;
    }

    @JsonProperty("agentTypeCode")
    public void setAgentTypeCode(String agentTypeCode) {
        this.agentTypeCode = agentTypeCode;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("designation")
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @JsonProperty("biography")
    public String getBiography() {
        return biography;
    }

    @JsonProperty("biography")
    public void setBiography(String biography) {
        this.biography = biography;
    }

    @JsonProperty("biographyAvailableFlag")
    public String getBiographyAvailableFlag() {
        return biographyAvailableFlag;
    }

    @JsonProperty("biographyAvailableFlag")
    public void setBiographyAvailableFlag(String biographyAvailableFlag) {
        this.biographyAvailableFlag = biographyAvailableFlag;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("subAgent")
    public SubAgent getSubAgent() {
        return subAgent;
    }

    @JsonProperty("subAgent")
    public void setSubAgent(SubAgent subAgent) {
        this.subAgent = subAgent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(agentId).append(teamId).append(teamName).append(agentAvatar).append(agentRole).append(firstName).append(lastName).append(displayName).append(preferredName).append(agentTypeCode).append(designation).append(biography).append(biographyAvailableFlag).append(phoneNumber).append(emailAddress).append(subAgent).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Agent) == false) {
            return false;
        }
        Agent rhs = ((Agent) other);
        return new EqualsBuilder().append(agentId, rhs.agentId).append(teamId, rhs.teamId).append(teamName, rhs.teamName).append(agentAvatar, rhs.agentAvatar).append(agentRole, rhs.agentRole).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(displayName, rhs.displayName).append(preferredName, rhs.preferredName).append(agentTypeCode, rhs.agentTypeCode).append(designation, rhs.designation).append(biography, rhs.biography).append(biographyAvailableFlag, rhs.biographyAvailableFlag).append(phoneNumber, rhs.phoneNumber).append(emailAddress, rhs.emailAddress).append(subAgent, rhs.subAgent).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
