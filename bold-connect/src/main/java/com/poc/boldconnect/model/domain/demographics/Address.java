
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
    "streetNumber",
    "streetName",
    "buildingName",
    "unitNumber",
    "addressType",
    "city",
    "countryCode",
    "countryName",
    "lastUpdatedDate",
    "postalCode",
    "state",
    "addressId",
    "postalBoxNumber",
    "careOf",
    "internalLocationNumber",
    "startDate",
    "endDate"
})
public class Address {

    @JsonProperty("streetNumber")
    private String streetNumber;
    @JsonProperty("streetName")
    private String streetName;
    @JsonProperty("buildingName")
    private String buildingName;
    @JsonProperty("unitNumber")
    private String unitNumber;
    @JsonProperty("addressType")
    private String addressType;
    @JsonProperty("city")
    private String city;
    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("lastUpdatedDate")
    private String lastUpdatedDate;
    @JsonProperty("postalCode")
    private String postalCode;
    @JsonProperty("state")
    private String state;
    @JsonProperty("addressId")
    private String addressId;
    @JsonProperty("postalBoxNumber")
    private String postalBoxNumber;
    @JsonProperty("careOf")
    private String careOf;
    @JsonProperty("internalLocationNumber")
    private String internalLocationNumber;
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("streetNumber")
    public String getStreetNumber() {
        return streetNumber;
    }

    @JsonProperty("streetNumber")
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @JsonProperty("streetName")
    public String getStreetName() {
        return streetName;
    }

    @JsonProperty("streetName")
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @JsonProperty("buildingName")
    public String getBuildingName() {
        return buildingName;
    }

    @JsonProperty("buildingName")
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @JsonProperty("unitNumber")
    public String getUnitNumber() {
        return unitNumber;
    }

    @JsonProperty("unitNumber")
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @JsonProperty("addressType")
    public String getAddressType() {
        return addressType;
    }

    @JsonProperty("addressType")
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("lastUpdatedDate")
    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    @JsonProperty("lastUpdatedDate")
    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @JsonProperty("postalCode")
    public String getPostalCode() {
        return postalCode;
    }

    @JsonProperty("postalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("addressId")
    public String getAddressId() {
        return addressId;
    }

    @JsonProperty("addressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @JsonProperty("postalBoxNumber")
    public String getPostalBoxNumber() {
        return postalBoxNumber;
    }

    @JsonProperty("postalBoxNumber")
    public void setPostalBoxNumber(String postalBoxNumber) {
        this.postalBoxNumber = postalBoxNumber;
    }

    @JsonProperty("careOf")
    public String getCareOf() {
        return careOf;
    }

    @JsonProperty("careOf")
    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    @JsonProperty("internalLocationNumber")
    public String getInternalLocationNumber() {
        return internalLocationNumber;
    }

    @JsonProperty("internalLocationNumber")
    public void setInternalLocationNumber(String internalLocationNumber) {
        this.internalLocationNumber = internalLocationNumber;
    }

    @JsonProperty("startDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
        return new HashCodeBuilder().append(streetNumber).append(streetName).append(buildingName).append(unitNumber).append(addressType).append(city).append(countryCode).append(countryName).append(lastUpdatedDate).append(postalCode).append(state).append(addressId).append(postalBoxNumber).append(careOf).append(internalLocationNumber).append(startDate).append(endDate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Address) == false) {
            return false;
        }
        Address rhs = ((Address) other);
        return new EqualsBuilder().append(streetNumber, rhs.streetNumber).append(streetName, rhs.streetName).append(buildingName, rhs.buildingName).append(unitNumber, rhs.unitNumber).append(addressType, rhs.addressType).append(city, rhs.city).append(countryCode, rhs.countryCode).append(countryName, rhs.countryName).append(lastUpdatedDate, rhs.lastUpdatedDate).append(postalCode, rhs.postalCode).append(state, rhs.state).append(addressId, rhs.addressId).append(postalBoxNumber, rhs.postalBoxNumber).append(careOf, rhs.careOf).append(internalLocationNumber, rhs.internalLocationNumber).append(startDate, rhs.startDate).append(endDate, rhs.endDate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
