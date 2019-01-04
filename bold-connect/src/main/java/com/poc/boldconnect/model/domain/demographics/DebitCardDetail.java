
package com.poc.boldconnect.model.domain.demographics;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardPackageIndicator"
})
public class DebitCardDetail {

    @JsonProperty("cardPackageIndicator")
    private String cardPackageIndicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardPackageIndicator")
    public String getCardPackageIndicator() {
        return cardPackageIndicator;
    }

    @JsonProperty("cardPackageIndicator")
    public void setCardPackageIndicator(String cardPackageIndicator) {
        this.cardPackageIndicator = cardPackageIndicator;
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
        return new HashCodeBuilder().append(cardPackageIndicator).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DebitCardDetail) == false) {
            return false;
        }
        DebitCardDetail rhs = ((DebitCardDetail) other);
        return new EqualsBuilder().append(cardPackageIndicator, rhs.cardPackageIndicator).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
