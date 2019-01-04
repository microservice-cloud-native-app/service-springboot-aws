
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cardsDetails",
    "responseCode",
    "responseText"
})
public class CreditCardCustomer {

    @JsonProperty("cardsDetails")
    private List<CardsDetail> cardsDetails = new ArrayList<CardsDetail>();
    @JsonProperty("responseCode")
    private String responseCode;
    @JsonProperty("responseText")
    private String responseText;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cardsDetails")
    public List<CardsDetail> getCardsDetails() {
        return cardsDetails;
    }

    @JsonProperty("cardsDetails")
    public void setCardsDetails(List<CardsDetail> cardsDetails) {
        this.cardsDetails = cardsDetails;
    }

    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }

    @JsonProperty("responseCode")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("responseText")
    public String getResponseText() {
        return responseText;
    }

    @JsonProperty("responseText")
    public void setResponseText(String responseText) {
        this.responseText = responseText;
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
        return new HashCodeBuilder().append(cardsDetails).append(responseCode).append(responseText).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CreditCardCustomer) == false) {
            return false;
        }
        CreditCardCustomer rhs = ((CreditCardCustomer) other);
        return new EqualsBuilder().append(cardsDetails, rhs.cardsDetails).append(responseCode, rhs.responseCode).append(responseText, rhs.responseText).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
