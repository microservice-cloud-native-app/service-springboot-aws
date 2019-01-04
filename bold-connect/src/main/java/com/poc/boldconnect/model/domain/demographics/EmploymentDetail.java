
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
    "employmentStatus",
    "employerName",
    "employmentStartDate",
    "employmentEndDate",
    "annualBaseSalaryAmount",
    "jobDescription",
    "jobTitle",
    "globalEmployeeId",
    "employeeLevel",
    "address"
})
public class EmploymentDetail {

    @JsonProperty("employmentStatus")
    private String employmentStatus;
    @JsonProperty("employerName")
    private String employerName;
    @JsonProperty("employmentStartDate")
    private String employmentStartDate;
    @JsonProperty("employmentEndDate")
    private String employmentEndDate;
    @JsonProperty("annualBaseSalaryAmount")
    private String annualBaseSalaryAmount;
    @JsonProperty("jobDescription")
    private String jobDescription;
    @JsonProperty("jobTitle")
    private String jobTitle;
    @JsonProperty("globalEmployeeId")
    private String globalEmployeeId;
    @JsonProperty("employeeLevel")
    private String employeeLevel;
    @JsonProperty("address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("employmentStatus")
    public String getEmploymentStatus() {
        return employmentStatus;
    }

    @JsonProperty("employmentStatus")
    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    @JsonProperty("employerName")
    public String getEmployerName() {
        return employerName;
    }

    @JsonProperty("employerName")
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    @JsonProperty("employmentStartDate")
    public String getEmploymentStartDate() {
        return employmentStartDate;
    }

    @JsonProperty("employmentStartDate")
    public void setEmploymentStartDate(String employmentStartDate) {
        this.employmentStartDate = employmentStartDate;
    }

    @JsonProperty("employmentEndDate")
    public String getEmploymentEndDate() {
        return employmentEndDate;
    }

    @JsonProperty("employmentEndDate")
    public void setEmploymentEndDate(String employmentEndDate) {
        this.employmentEndDate = employmentEndDate;
    }

    @JsonProperty("annualBaseSalaryAmount")
    public String getAnnualBaseSalaryAmount() {
        return annualBaseSalaryAmount;
    }

    @JsonProperty("annualBaseSalaryAmount")
    public void setAnnualBaseSalaryAmount(String annualBaseSalaryAmount) {
        this.annualBaseSalaryAmount = annualBaseSalaryAmount;
    }

    @JsonProperty("jobDescription")
    public String getJobDescription() {
        return jobDescription;
    }

    @JsonProperty("jobDescription")
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @JsonProperty("jobTitle")
    public String getJobTitle() {
        return jobTitle;
    }

    @JsonProperty("jobTitle")
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @JsonProperty("globalEmployeeId")
    public String getGlobalEmployeeId() {
        return globalEmployeeId;
    }

    @JsonProperty("globalEmployeeId")
    public void setGlobalEmployeeId(String globalEmployeeId) {
        this.globalEmployeeId = globalEmployeeId;
    }

    @JsonProperty("employeeLevel")
    public String getEmployeeLevel() {
        return employeeLevel;
    }

    @JsonProperty("employeeLevel")
    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(Address address) {
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
        return new HashCodeBuilder().append(employmentStatus).append(employerName).append(employmentStartDate).append(employmentEndDate).append(annualBaseSalaryAmount).append(jobDescription).append(jobTitle).append(globalEmployeeId).append(employeeLevel).append(address).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EmploymentDetail) == false) {
            return false;
        }
        EmploymentDetail rhs = ((EmploymentDetail) other);
        return new EqualsBuilder().append(employmentStatus, rhs.employmentStatus).append(employerName, rhs.employerName).append(employmentStartDate, rhs.employmentStartDate).append(employmentEndDate, rhs.employmentEndDate).append(annualBaseSalaryAmount, rhs.annualBaseSalaryAmount).append(jobDescription, rhs.jobDescription).append(jobTitle, rhs.jobTitle).append(globalEmployeeId, rhs.globalEmployeeId).append(employeeLevel, rhs.employeeLevel).append(address, rhs.address).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
