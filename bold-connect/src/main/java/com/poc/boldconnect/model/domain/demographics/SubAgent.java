
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "agentType",
    "firstName",
    "lastName",
    "emailAddress",
    "aoSOEID"
})
public class SubAgent {

    @JsonProperty("agentType")
    private String agentType;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("aoSOEID")
    private String aoSOEID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("agentType")
    public String getAgentType() {
        return agentType;
    }

    @JsonProperty("agentType")
    public void setAgentType(String agentType) {
        this.agentType = agentType;
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

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("aoSOEID")
    public String getAoSOEID() {
        return aoSOEID;
    }

    @JsonProperty("aoSOEID")
    public void setAoSOEID(String aoSOEID) {
        this.aoSOEID = aoSOEID;
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
        return new HashCodeBuilder().append(agentType).append(firstName).append(lastName).append(emailAddress).append(aoSOEID).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SubAgent) == false) {
            return false;
        }
        SubAgent rhs = ((SubAgent) other);
        return new EqualsBuilder().append(agentType, rhs.agentType).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(emailAddress, rhs.emailAddress).append(aoSOEID, rhs.aoSOEID).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
