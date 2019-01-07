
package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "areaCode",
    "countryCallingCode",
    "exchangeNumber",
    "extension",
    "fullPhoneNumber",
    "lastUpdatedDate",
    "localNumber",
    "phoneType",
    "verificationStatusIndicator",
    "preferenceType",
    "phoneConsent",
    "verificationCode",
    "unlistedPhoneIndicator"
})
public class Phone {

    @JsonProperty("areaCode")
    private String areaCode;
    @JsonProperty("countryCallingCode")
    private String countryCallingCode;
    @JsonProperty("exchangeNumber")
    private String exchangeNumber;
    @JsonProperty("extension")
    private String extension;
    @JsonProperty("fullPhoneNumber")
    private String fullPhoneNumber;
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    @JsonProperty("localNumber")
    private String localNumber;
    @JsonProperty("phoneType")
    private String phoneType;
    @JsonProperty("verificationStatusIndicator")
    private String verificationStatusIndicator;
    @JsonProperty("preferenceType")
    private String preferenceType;
    @JsonProperty("phoneConsent")
    private String phoneConsent;
    @JsonProperty("verificationCode")
    private String verificationCode;
    @JsonProperty("unlistedPhoneIndicator")
    private String unlistedPhoneIndicator;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("areaCode")
    public String getAreaCode() {
        return areaCode;
    }

    @JsonProperty("areaCode")
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    @JsonProperty("countryCallingCode")
    public String getCountryCallingCode() {
        return countryCallingCode;
    }

    @JsonProperty("countryCallingCode")
    public void setCountryCallingCode(String countryCallingCode) {
        this.countryCallingCode = countryCallingCode;
    }

    @JsonProperty("exchangeNumber")
    public String getExchangeNumber() {
        return exchangeNumber;
    }

    @JsonProperty("exchangeNumber")
    public void setExchangeNumber(String exchangeNumber) {
        this.exchangeNumber = exchangeNumber;
    }

    @JsonProperty("extension")
    public String getExtension() {
        return extension;
    }

    @JsonProperty("extension")
    public void setExtension(String extension) {
        this.extension = extension;
    }

    @JsonProperty("fullPhoneNumber")
    public String getFullPhoneNumber() {
        return fullPhoneNumber;
    }

    @JsonProperty("fullPhoneNumber")
    public void setFullPhoneNumber(String fullPhoneNumber) {
        this.fullPhoneNumber = fullPhoneNumber;
    }

    @JsonProperty("lastUpdatedDate")
    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @JsonProperty("lastUpdatedDate")
    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @JsonProperty("localNumber")
    public String getLocalNumber() {
        return localNumber;
    }

    @JsonProperty("localNumber")
    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    @JsonProperty("phoneType")
    public String getPhoneType() {
        return phoneType;
    }

    @JsonProperty("phoneType")
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    @JsonProperty("verificationStatusIndicator")
    public String getVerificationStatusIndicator() {
        return verificationStatusIndicator;
    }

    @JsonProperty("verificationStatusIndicator")
    public void setVerificationStatusIndicator(String verificationStatusIndicator) {
        this.verificationStatusIndicator = verificationStatusIndicator;
    }

    @JsonProperty("preferenceType")
    public String getPreferenceType() {
        return preferenceType;
    }

    @JsonProperty("preferenceType")
    public void setPreferenceType(String preferenceType) {
        this.preferenceType = preferenceType;
    }

    @JsonProperty("phoneConsent")
    public String getPhoneConsent() {
        return phoneConsent;
    }

    @JsonProperty("phoneConsent")
    public void setPhoneConsent(String phoneConsent) {
        this.phoneConsent = phoneConsent;
    }

    @JsonProperty("verificationCode")
    public String getVerificationCode() {
        return verificationCode;
    }

    @JsonProperty("verificationCode")
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @JsonProperty("unlistedPhoneIndicator")
    public String getUnlistedPhoneIndicator() {
        return unlistedPhoneIndicator;
    }

    @JsonProperty("unlistedPhoneIndicator")
    public void setUnlistedPhoneIndicator(String unlistedPhoneIndicator) {
        this.unlistedPhoneIndicator = unlistedPhoneIndicator;
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
        return new HashCodeBuilder().append(areaCode).append(countryCallingCode).append(exchangeNumber).append(extension).append(fullPhoneNumber).append(lastUpdatedDate).append(localNumber).append(phoneType).append(verificationStatusIndicator).append(preferenceType).append(phoneConsent).append(verificationCode).append(unlistedPhoneIndicator).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Phone) == false) {
            return false;
        }
        Phone rhs = ((Phone) other);
        return new EqualsBuilder().append(areaCode, rhs.areaCode).append(countryCallingCode, rhs.countryCallingCode).append(exchangeNumber, rhs.exchangeNumber).append(extension, rhs.extension).append(fullPhoneNumber, rhs.fullPhoneNumber).append(lastUpdatedDate, rhs.lastUpdatedDate).append(localNumber, rhs.localNumber).append(phoneType, rhs.phoneType).append(verificationStatusIndicator, rhs.verificationStatusIndicator).append(preferenceType, rhs.preferenceType).append(phoneConsent, rhs.phoneConsent).append(verificationCode, rhs.verificationCode).append(unlistedPhoneIndicator, rhs.unlistedPhoneIndicator).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
