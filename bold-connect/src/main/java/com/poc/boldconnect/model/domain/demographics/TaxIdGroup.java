
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxId",
    "taxIdType",
    "taxIdCertifyFlag"
})
public class TaxIdGroup {

    @JsonProperty("taxId")
    private String taxId;
    @JsonProperty("taxIdType")
    private String taxIdType;
    @JsonProperty("taxIdCertifyFlag")
    private String taxIdCertifyFlag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("taxId")
    public String getTaxId() {
        return taxId;
    }

    @JsonProperty("taxId")
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @JsonProperty("taxIdType")
    public String getTaxIdType() {
        return taxIdType;
    }

    @JsonProperty("taxIdType")
    public void setTaxIdType(String taxIdType) {
        this.taxIdType = taxIdType;
    }

    @JsonProperty("taxIdCertifyFlag")
    public String getTaxIdCertifyFlag() {
        return taxIdCertifyFlag;
    }

    @JsonProperty("taxIdCertifyFlag")
    public void setTaxIdCertifyFlag(String taxIdCertifyFlag) {
        this.taxIdCertifyFlag = taxIdCertifyFlag;
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
        return new HashCodeBuilder().append(taxId).append(taxIdType).append(taxIdCertifyFlag).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxIdGroup) == false) {
            return false;
        }
        TaxIdGroup rhs = ((TaxIdGroup) other);
        return new EqualsBuilder().append(taxId, rhs.taxId).append(taxIdType, rhs.taxIdType).append(taxIdCertifyFlag, rhs.taxIdCertifyFlag).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
