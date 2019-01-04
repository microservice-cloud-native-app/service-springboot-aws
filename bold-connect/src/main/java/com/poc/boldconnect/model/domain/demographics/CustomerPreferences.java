
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "prefferedRmLanguageCode",
    "prefferedVoiceLanguageCode",
    "prefferedOthersLanguageCode",
    "prefferedMailLanguageCode"
})
public class CustomerPreferences {

    @JsonProperty("prefferedRmLanguageCode")
    private String prefferedRmLanguageCode;
    @JsonProperty("prefferedVoiceLanguageCode")
    private String prefferedVoiceLanguageCode;
    @JsonProperty("prefferedOthersLanguageCode")
    private String prefferedOthersLanguageCode;
    @JsonProperty("prefferedMailLanguageCode")
    private String prefferedMailLanguageCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("prefferedRmLanguageCode")
    public String getPrefferedRmLanguageCode() {
        return prefferedRmLanguageCode;
    }

    @JsonProperty("prefferedRmLanguageCode")
    public void setPrefferedRmLanguageCode(String prefferedRmLanguageCode) {
        this.prefferedRmLanguageCode = prefferedRmLanguageCode;
    }

    @JsonProperty("prefferedVoiceLanguageCode")
    public String getPrefferedVoiceLanguageCode() {
        return prefferedVoiceLanguageCode;
    }

    @JsonProperty("prefferedVoiceLanguageCode")
    public void setPrefferedVoiceLanguageCode(String prefferedVoiceLanguageCode) {
        this.prefferedVoiceLanguageCode = prefferedVoiceLanguageCode;
    }

    @JsonProperty("prefferedOthersLanguageCode")
    public String getPrefferedOthersLanguageCode() {
        return prefferedOthersLanguageCode;
    }

    @JsonProperty("prefferedOthersLanguageCode")
    public void setPrefferedOthersLanguageCode(String prefferedOthersLanguageCode) {
        this.prefferedOthersLanguageCode = prefferedOthersLanguageCode;
    }

    @JsonProperty("prefferedMailLanguageCode")
    public String getPrefferedMailLanguageCode() {
        return prefferedMailLanguageCode;
    }

    @JsonProperty("prefferedMailLanguageCode")
    public void setPrefferedMailLanguageCode(String prefferedMailLanguageCode) {
        this.prefferedMailLanguageCode = prefferedMailLanguageCode;
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
        return new HashCodeBuilder().append(prefferedRmLanguageCode).append(prefferedVoiceLanguageCode).append(prefferedOthersLanguageCode).append(prefferedMailLanguageCode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerPreferences) == false) {
            return false;
        }
        CustomerPreferences rhs = ((CustomerPreferences) other);
        return new EqualsBuilder().append(prefferedRmLanguageCode, rhs.prefferedRmLanguageCode).append(prefferedVoiceLanguageCode, rhs.prefferedVoiceLanguageCode).append(prefferedOthersLanguageCode, rhs.prefferedOthersLanguageCode).append(prefferedMailLanguageCode, rhs.prefferedMailLanguageCode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
