
package com.poc.boldconnect.model.domain.demographics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "creditCardNumber",
    "customerId",
    "fullName",
    "firstName",
    "lastName",
    "middleName",
    "dateOfBirth",
    "ssn",
    "citizenshipCountry",
    "securityHint",
    "securityIndicator",
    "encryptedSecurityWord",
    "email",
    "phone",
    "address"
})
public class CardsDetail {

    @JsonProperty("creditCardNumber")
    private String creditCardNumber;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("citizenshipCountry")
    private String citizenshipCountry;
    @JsonProperty("securityHint")
    private String securityHint;
    @JsonProperty("securityIndicator")
    private String securityIndicator;
    @JsonProperty("encryptedSecurityWord")
    private String encryptedSecurityWord;
    @JsonProperty("email")
    private List<Email> email = new ArrayList<Email>();
    @JsonProperty("phone")
    private List<Phone> phone = new ArrayList<Phone>();
    @JsonProperty("address")
    private List<Address> address = new ArrayList<Address>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("creditCardNumber")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    @JsonProperty("creditCardNumber")
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("fullName")
    public String getFullName() {
        return fullName;
    }

    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @JsonProperty("middleName")
    public String getMiddleName() {
        return middleName;
    }

    @JsonProperty("middleName")
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @JsonProperty("dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonProperty("dateOfBirth")
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("citizenshipCountry")
    public String getCitizenshipCountry() {
        return citizenshipCountry;
    }

    @JsonProperty("citizenshipCountry")
    public void setCitizenshipCountry(String citizenshipCountry) {
        this.citizenshipCountry = citizenshipCountry;
    }

    @JsonProperty("securityHint")
    public String getSecurityHint() {
        return securityHint;
    }

    @JsonProperty("securityHint")
    public void setSecurityHint(String securityHint) {
        this.securityHint = securityHint;
    }

    @JsonProperty("securityIndicator")
    public String getSecurityIndicator() {
        return securityIndicator;
    }

    @JsonProperty("securityIndicator")
    public void setSecurityIndicator(String securityIndicator) {
        this.securityIndicator = securityIndicator;
    }

    @JsonProperty("encryptedSecurityWord")
    public String getEncryptedSecurityWord() {
        return encryptedSecurityWord;
    }

    @JsonProperty("encryptedSecurityWord")
    public void setEncryptedSecurityWord(String encryptedSecurityWord) {
        this.encryptedSecurityWord = encryptedSecurityWord;
    }

    @JsonProperty("email")
    public List<Email> getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(List<Email> email) {
        this.email = email;
    }

    @JsonProperty("phone")
    public List<Phone> getPhone() {
        return phone;
    }

    @JsonProperty("phone")
    public void setPhone(List<Phone> phone) {
        this.phone = phone;
    }

    @JsonProperty("address")
    public List<Address> getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(List<Address> address) {
        this.address = address;
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
        return new HashCodeBuilder().append(creditCardNumber).append(customerId).append(fullName).append(firstName).append(lastName).append(middleName).append(dateOfBirth).append(ssn).append(citizenshipCountry).append(securityHint).append(securityIndicator).append(encryptedSecurityWord).append(email).append(phone).append(address).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CardsDetail) == false) {
            return false;
        }
        CardsDetail rhs = ((CardsDetail) other);
        return new EqualsBuilder().append(creditCardNumber, rhs.creditCardNumber).append(customerId, rhs.customerId).append(fullName, rhs.fullName).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(middleName, rhs.middleName).append(dateOfBirth, rhs.dateOfBirth).append(ssn, rhs.ssn).append(citizenshipCountry, rhs.citizenshipCountry).append(securityHint, rhs.securityHint).append(securityIndicator, rhs.securityIndicator).append(encryptedSecurityWord, rhs.encryptedSecurityWord).append(email, rhs.email).append(phone, rhs.phone).append(address, rhs.address).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
