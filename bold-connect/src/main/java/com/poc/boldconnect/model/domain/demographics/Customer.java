
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
    "bankCustomer",
    "creditCardCustomer"
})
public class Customer {

    @JsonProperty("bankCustomer")
    private BankCustomer bankCustomer;
    @JsonProperty("creditCardCustomer")
    private CreditCardCustomer creditCardCustomer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("bankCustomer")
    public BankCustomer getBankCustomer() {
        return bankCustomer;
    }

    @JsonProperty("bankCustomer")
    public void setBankCustomer(BankCustomer bankCustomer) {
        this.bankCustomer = bankCustomer;
    }

    @JsonProperty("creditCardCustomer")
    public CreditCardCustomer getCreditCardCustomer() {
        return creditCardCustomer;
    }

    @JsonProperty("creditCardCustomer")
    public void setCreditCardCustomer(CreditCardCustomer creditCardCustomer) {
        this.creditCardCustomer = creditCardCustomer;
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
        return new HashCodeBuilder().append(bankCustomer).append(creditCardCustomer).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Customer) == false) {
            return false;
        }
        Customer rhs = ((Customer) other);
        return new EqualsBuilder().append(bankCustomer, rhs.bankCustomer).append(creditCardCustomer, rhs.creditCardCustomer).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
