
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "emailAddress",
    "emailStatus",
    "lastUpdatedDate",
    "preferenceType"
})
public class Email {

    @JsonProperty("emailAddress")
    private String emailAddress;
    @JsonProperty("emailStatus")
    private String emailStatus;
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    @JsonProperty("preferenceType")
    private String preferenceType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("emailAddress")
    public String getEmailAddress() {
        return emailAddress;
    }

    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @JsonProperty("emailStatus")
    public String getEmailStatus() {
        return emailStatus;
    }

    @JsonProperty("emailStatus")
    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    @JsonProperty("lastUpdatedDate")
    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @JsonProperty("lastUpdatedDate")
    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @JsonProperty("preferenceType")
    public String getPreferenceType() {
        return preferenceType;
    }

    @JsonProperty("preferenceType")
    public void setPreferenceType(String preferenceType) {
        this.preferenceType = preferenceType;
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
        return new HashCodeBuilder().append(emailAddress).append(emailStatus).append(lastUpdatedDate).append(preferenceType).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Email) == false) {
            return false;
        }
        Email rhs = ((Email) other);
        return new EqualsBuilder().append(emailAddress, rhs.emailAddress).append(emailStatus, rhs.emailStatus).append(lastUpdatedDate, rhs.lastUpdatedDate).append(preferenceType, rhs.preferenceType).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
