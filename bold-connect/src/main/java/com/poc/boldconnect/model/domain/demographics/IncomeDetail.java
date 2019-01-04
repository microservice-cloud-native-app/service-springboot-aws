
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "incomeAmount",
    "incomeSource",
    "incomeFrequencyCode"
})
public class IncomeDetail {

    @JsonProperty("incomeAmount")
    private String incomeAmount;
    @JsonProperty("incomeSource")
    private String incomeSource;
    @JsonProperty("incomeFrequencyCode")
    private String incomeFrequencyCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("incomeAmount")
    public String getIncomeAmount() {
        return incomeAmount;
    }

    @JsonProperty("incomeAmount")
    public void setIncomeAmount(String incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    @JsonProperty("incomeSource")
    public String getIncomeSource() {
        return incomeSource;
    }

    @JsonProperty("incomeSource")
    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    @JsonProperty("incomeFrequencyCode")
    public String getIncomeFrequencyCode() {
        return incomeFrequencyCode;
    }

    @JsonProperty("incomeFrequencyCode")
    public void setIncomeFrequencyCode(String incomeFrequencyCode) {
        this.incomeFrequencyCode = incomeFrequencyCode;
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
        return new HashCodeBuilder().append(incomeAmount).append(incomeSource).append(incomeFrequencyCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IncomeDetail) == false) {
            return false;
        }
        IncomeDetail rhs = ((IncomeDetail) other);
        return new EqualsBuilder().append(incomeAmount, rhs.incomeAmount).append(incomeSource, rhs.incomeSource).append(incomeFrequencyCode, rhs.incomeFrequencyCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
