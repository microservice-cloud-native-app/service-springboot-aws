
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import com.poc.boldconnect.model.domain.Account;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customer",
    "accounts"
})
public class CustomerDemographics {

    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("accounts")
    private List<com.poc.boldconnect.model.domain.Account> accounts = new ArrayList<com.poc.boldconnect.model.domain.Account>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("accounts")
    public List<com.poc.boldconnect.model.domain.Account> getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
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
        return new HashCodeBuilder().append(customer).append(accounts).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CustomerDemographics) == false) {
            return false;
        }
        CustomerDemographics rhs = ((CustomerDemographics) other);
        return new EqualsBuilder().append(customer, rhs.customer).append(accounts, rhs.accounts).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
