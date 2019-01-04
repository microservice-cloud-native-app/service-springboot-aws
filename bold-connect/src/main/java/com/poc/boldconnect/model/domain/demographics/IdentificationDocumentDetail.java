
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "documentIdType",
    "documentId",
    "documentIssueCountry",
    "documentIdIssueDate",
    "documentIdExpiryDate"
})
public class IdentificationDocumentDetail {

    @JsonProperty("documentIdType")
    private String documentIdType;
    @JsonProperty("documentId")
    private String documentId;
    @JsonProperty("documentIssueCountry")
    private String documentIssueCountry;
    @JsonProperty("documentIdIssueDate")
    private String documentIdIssueDate;
    @JsonProperty("documentIdExpiryDate")
    private String documentIdExpiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("documentIdType")
    public String getDocumentIdType() {
        return documentIdType;
    }

    @JsonProperty("documentIdType")
    public void setDocumentIdType(String documentIdType) {
        this.documentIdType = documentIdType;
    }

    @JsonProperty("documentId")
    public String getDocumentId() {
        return documentId;
    }

    @JsonProperty("documentId")
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @JsonProperty("documentIssueCountry")
    public String getDocumentIssueCountry() {
        return documentIssueCountry;
    }

    @JsonProperty("documentIssueCountry")
    public void setDocumentIssueCountry(String documentIssueCountry) {
        this.documentIssueCountry = documentIssueCountry;
    }

    @JsonProperty("documentIdIssueDate")
    public String getDocumentIdIssueDate() {
        return documentIdIssueDate;
    }

    @JsonProperty("documentIdIssueDate")
    public void setDocumentIdIssueDate(String documentIdIssueDate) {
        this.documentIdIssueDate = documentIdIssueDate;
    }

    @JsonProperty("documentIdExpiryDate")
    public String getDocumentIdExpiryDate() {
        return documentIdExpiryDate;
    }

    @JsonProperty("documentIdExpiryDate")
    public void setDocumentIdExpiryDate(String documentIdExpiryDate) {
        this.documentIdExpiryDate = documentIdExpiryDate;
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
        return new HashCodeBuilder().append(documentIdType).append(documentId).append(documentIssueCountry).append(documentIdIssueDate).append(documentIdExpiryDate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IdentificationDocumentDetail) == false) {
            return false;
        }
        IdentificationDocumentDetail rhs = ((IdentificationDocumentDetail) other);
        return new EqualsBuilder().append(documentIdType, rhs.documentIdType).append(documentId, rhs.documentId).append(documentIssueCountry, rhs.documentIssueCountry).append(documentIdIssueDate, rhs.documentIdIssueDate).append(documentIdExpiryDate, rhs.documentIdExpiryDate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
