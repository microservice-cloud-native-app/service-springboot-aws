
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
    "baseCin",
    "cin",
    "customerId",
    "customerSinceDate",
    "customerCategoryType",
    "customerSegment",
    "customerStatus",
    "fullName",
    "firstName",
    "lastName",
    "middleName",
    "localName",
    "title",
    "suffix",
    "maidenName",
    "thirdPartyDataSharingIndicator",
    "housingOwnershipType",
    "annualIncome",
    "annualIncomeUpdateDate",
    "ipbCustomerFlag",
    "gebCustomerFlag",
    "promotionalOfferFlag",
    "citiKYC",
    "primarySIC",
    "incomeDetails",
    "identificationDocumentDetails",
    "customerPreferences",
    "taxIdGroup",
    "email",
    "phone",
    "address",
    "debitCardDetails",
    "employmentDetails",
    "customerDemographics",
    "agent",
    "responseCode",
    "responseText",
    "rmEngagementMode"
})
public class BankCustomer {

    @JsonProperty("baseCin")
    private String baseCin;
    @JsonProperty("cin")
    private String cin;
    @JsonProperty("customerId")
    private String customerId;
    @JsonProperty("customerSinceDate")
    private String customerSinceDate;
    @JsonProperty("customerCategoryType")
    private String customerCategoryType;
    @JsonProperty("customerSegment")
    private String customerSegment;
    @JsonProperty("customerStatus")
    private String customerStatus;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("localName")
    private String localName;
    @JsonProperty("title")
    private String title;
    @JsonProperty("suffix")
    private String suffix;
    @JsonProperty("maidenName")
    private String maidenName;
    @JsonProperty("thirdPartyDataSharingIndicator")
    private String thirdPartyDataSharingIndicator;
    @JsonProperty("housingOwnershipType")
    private String housingOwnershipType;
    @JsonProperty("annualIncome")
    private String annualIncome;
    @JsonProperty("annualIncomeUpdateDate")
    private String annualIncomeUpdateDate;
    @JsonProperty("ipbCustomerFlag")
    private Boolean ipbCustomerFlag;
    @JsonProperty("gebCustomerFlag")
    private Boolean gebCustomerFlag;
    @JsonProperty("promotionalOfferFlag")
    private Boolean promotionalOfferFlag;
    @JsonProperty("citiKYC")
    private String citiKYC;
    @JsonProperty("primarySIC")
    private String primarySIC;
    @JsonProperty("incomeDetails")
    private List<IncomeDetail> incomeDetails = new ArrayList<IncomeDetail>();
    @JsonProperty("identificationDocumentDetails")
    private List<IdentificationDocumentDetail> identificationDocumentDetails = new ArrayList<IdentificationDocumentDetail>();
    @JsonProperty("customerPreferences")
    private CustomerPreferences customerPreferences;
    @JsonProperty("taxIdGroup")
    private TaxIdGroup taxIdGroup;
    @JsonProperty("email")
    private List<Email> email = new ArrayList<Email>();
    @JsonProperty("phone")
    private List<Phone> phone = new ArrayList<Phone>();
    @JsonProperty("address")
    private List<Address> address = new ArrayList<Address>();
    @JsonProperty("debitCardDetails")
    private List<DebitCardDetail> debitCardDetails = new ArrayList<DebitCardDetail>();
    @JsonProperty("employmentDetails")
    private List<EmploymentDetail> employmentDetails = new ArrayList<EmploymentDetail>();
    @JsonProperty("customerDemographics")
    private CustomerDemographics customerDemographics;
    @JsonProperty("agent")
    private List<Agent> agent = new ArrayList<Agent>();
    @JsonProperty("responseCode")
    private String responseCode;
    @JsonProperty("responseText")
    private String responseText;
    @JsonProperty("rmEngagementMode")
    private String rmEngagementMode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("baseCin")
    public String getBaseCin() {
        return baseCin;
    }

    @JsonProperty("baseCin")
    public void setBaseCin(String baseCin) {
        this.baseCin = baseCin;
    }

    @JsonProperty("cin")
    public String getCin() {
        return cin;
    }

    @JsonProperty("cin")
    public void setCin(String cin) {
        this.cin = cin;
    }

    @JsonProperty("customerId")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("customerId")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("customerSinceDate")
    public String getCustomerSinceDate() {
        return customerSinceDate;
    }

    @JsonProperty("customerSinceDate")
    public void setCustomerSinceDate(String customerSinceDate) {
        this.customerSinceDate = customerSinceDate;
    }

    @JsonProperty("customerCategoryType")
    public String getCustomerCategoryType() {
        return customerCategoryType;
    }

    @JsonProperty("customerCategoryType")
    public void setCustomerCategoryType(String customerCategoryType) {
        this.customerCategoryType = customerCategoryType;
    }

    @JsonProperty("customerSegment")
    public String getCustomerSegment() {
        return customerSegment;
    }

    @JsonProperty("customerSegment")
    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    @JsonProperty("customerStatus")
    public String getCustomerStatus() {
        return customerStatus;
    }

    @JsonProperty("customerStatus")
    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
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

    @JsonProperty("localName")
    public String getLocalName() {
        return localName;
    }

    @JsonProperty("localName")
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("suffix")
    public String getSuffix() {
        return suffix;
    }

    @JsonProperty("suffix")
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @JsonProperty("maidenName")
    public String getMaidenName() {
        return maidenName;
    }

    @JsonProperty("maidenName")
    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    @JsonProperty("thirdPartyDataSharingIndicator")
    public String getThirdPartyDataSharingIndicator() {
        return thirdPartyDataSharingIndicator;
    }

    @JsonProperty("thirdPartyDataSharingIndicator")
    public void setThirdPartyDataSharingIndicator(String thirdPartyDataSharingIndicator) {
        this.thirdPartyDataSharingIndicator = thirdPartyDataSharingIndicator;
    }

    @JsonProperty("housingOwnershipType")
    public String getHousingOwnershipType() {
        return housingOwnershipType;
    }

    @JsonProperty("housingOwnershipType")
    public void setHousingOwnershipType(String housingOwnershipType) {
        this.housingOwnershipType = housingOwnershipType;
    }

    @JsonProperty("annualIncome")
    public String getAnnualIncome() {
        return annualIncome;
    }

    @JsonProperty("annualIncome")
    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    @JsonProperty("annualIncomeUpdateDate")
    public String getAnnualIncomeUpdateDate() {
        return annualIncomeUpdateDate;
    }

    @JsonProperty("annualIncomeUpdateDate")
    public void setAnnualIncomeUpdateDate(String annualIncomeUpdateDate) {
        this.annualIncomeUpdateDate = annualIncomeUpdateDate;
    }

    @JsonProperty("ipbCustomerFlag")
    public Boolean getIpbCustomerFlag() {
        return ipbCustomerFlag;
    }

    @JsonProperty("ipbCustomerFlag")
    public void setIpbCustomerFlag(Boolean ipbCustomerFlag) {
        this.ipbCustomerFlag = ipbCustomerFlag;
    }

    @JsonProperty("gebCustomerFlag")
    public Boolean getGebCustomerFlag() {
        return gebCustomerFlag;
    }

    @JsonProperty("gebCustomerFlag")
    public void setGebCustomerFlag(Boolean gebCustomerFlag) {
        this.gebCustomerFlag = gebCustomerFlag;
    }

    @JsonProperty("promotionalOfferFlag")
    public Boolean getPromotionalOfferFlag() {
        return promotionalOfferFlag;
    }

    @JsonProperty("promotionalOfferFlag")
    public void setPromotionalOfferFlag(Boolean promotionalOfferFlag) {
        this.promotionalOfferFlag = promotionalOfferFlag;
    }

    @JsonProperty("citiKYC")
    public String getCitiKYC() {
        return citiKYC;
    }

    @JsonProperty("citiKYC")
    public void setCitiKYC(String citiKYC) {
        this.citiKYC = citiKYC;
    }

    @JsonProperty("primarySIC")
    public String getPrimarySIC() {
        return primarySIC;
    }

    @JsonProperty("primarySIC")
    public void setPrimarySIC(String primarySIC) {
        this.primarySIC = primarySIC;
    }

    @JsonProperty("incomeDetails")
    public List<IncomeDetail> getIncomeDetails() {
        return incomeDetails;
    }

    @JsonProperty("incomeDetails")
    public void setIncomeDetails(List<IncomeDetail> incomeDetails) {
        this.incomeDetails = incomeDetails;
    }

    @JsonProperty("identificationDocumentDetails")
    public List<IdentificationDocumentDetail> getIdentificationDocumentDetails() {
        return identificationDocumentDetails;
    }

    @JsonProperty("identificationDocumentDetails")
    public void setIdentificationDocumentDetails(List<IdentificationDocumentDetail> identificationDocumentDetails) {
        this.identificationDocumentDetails = identificationDocumentDetails;
    }

    @JsonProperty("customerPreferences")
    public CustomerPreferences getCustomerPreferences() {
        return customerPreferences;
    }

    @JsonProperty("customerPreferences")
    public void setCustomerPreferences(CustomerPreferences customerPreferences) {
        this.customerPreferences = customerPreferences;
    }

    @JsonProperty("taxIdGroup")
    public TaxIdGroup getTaxIdGroup() {
        return taxIdGroup;
    }

    @JsonProperty("taxIdGroup")
    public void setTaxIdGroup(TaxIdGroup taxIdGroup) {
        this.taxIdGroup = taxIdGroup;
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

    @JsonProperty("debitCardDetails")
    public List<DebitCardDetail> getDebitCardDetails() {
        return debitCardDetails;
    }

    @JsonProperty("debitCardDetails")
    public void setDebitCardDetails(List<DebitCardDetail> debitCardDetails) {
        this.debitCardDetails = debitCardDetails;
    }

    @JsonProperty("employmentDetails")
    public List<EmploymentDetail> getEmploymentDetails() {
        return employmentDetails;
    }

    @JsonProperty("employmentDetails")
    public void setEmploymentDetails(List<EmploymentDetail> employmentDetails) {
        this.employmentDetails = employmentDetails;
    }

    @JsonProperty("customerDemographics")
    public CustomerDemographics getCustomerDemographics() {
        return customerDemographics;
    }

    @JsonProperty("customerDemographics")
    public void setCustomerDemographics(CustomerDemographics customerDemographics) {
        this.customerDemographics = customerDemographics;
    }

    @JsonProperty("agent")
    public List<Agent> getAgent() {
        return agent;
    }

    @JsonProperty("agent")
    public void setAgent(List<Agent> agent) {
        this.agent = agent;
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

    @JsonProperty("rmEngagementMode")
    public String getRmEngagementMode() {
        return rmEngagementMode;
    }

    @JsonProperty("rmEngagementMode")
    public void setRmEngagementMode(String rmEngagementMode) {
        this.rmEngagementMode = rmEngagementMode;
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
        return new HashCodeBuilder().append(baseCin).append(cin).append(customerId).append(customerSinceDate).append(customerCategoryType).append(customerSegment).append(customerStatus).append(fullName).append(firstName).append(lastName).append(middleName).append(localName).append(title).append(suffix).append(maidenName).append(thirdPartyDataSharingIndicator).append(housingOwnershipType).append(annualIncome).append(annualIncomeUpdateDate).append(ipbCustomerFlag).append(gebCustomerFlag).append(promotionalOfferFlag).append(citiKYC).append(primarySIC).append(incomeDetails).append(identificationDocumentDetails).append(customerPreferences).append(taxIdGroup).append(email).append(phone).append(address).append(debitCardDetails).append(employmentDetails).append(customerDemographics).append(agent).append(responseCode).append(responseText).append(rmEngagementMode).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BankCustomer) == false) {
            return false;
        }
        BankCustomer rhs = ((BankCustomer) other);
        return new EqualsBuilder().append(baseCin, rhs.baseCin).append(cin, rhs.cin).append(customerId, rhs.customerId).append(customerSinceDate, rhs.customerSinceDate).append(customerCategoryType, rhs.customerCategoryType).append(customerSegment, rhs.customerSegment).append(customerStatus, rhs.customerStatus).append(fullName, rhs.fullName).append(firstName, rhs.firstName).append(lastName, rhs.lastName).append(middleName, rhs.middleName).append(localName, rhs.localName).append(title, rhs.title).append(suffix, rhs.suffix).append(maidenName, rhs.maidenName).append(thirdPartyDataSharingIndicator, rhs.thirdPartyDataSharingIndicator).append(housingOwnershipType, rhs.housingOwnershipType).append(annualIncome, rhs.annualIncome).append(annualIncomeUpdateDate, rhs.annualIncomeUpdateDate).append(ipbCustomerFlag, rhs.ipbCustomerFlag).append(gebCustomerFlag, rhs.gebCustomerFlag).append(promotionalOfferFlag, rhs.promotionalOfferFlag).append(citiKYC, rhs.citiKYC).append(primarySIC, rhs.primarySIC).append(incomeDetails, rhs.incomeDetails).append(identificationDocumentDetails, rhs.identificationDocumentDetails).append(customerPreferences, rhs.customerPreferences).append(taxIdGroup, rhs.taxIdGroup).append(email, rhs.email).append(phone, rhs.phone).append(address, rhs.address).append(debitCardDetails, rhs.debitCardDetails).append(employmentDetails, rhs.employmentDetails).append(customerDemographics, rhs.customerDemographics).append(agent, rhs.agent).append(responseCode, rhs.responseCode).append(responseText, rhs.responseText).append(rmEngagementMode, rhs.rmEngagementMode).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
