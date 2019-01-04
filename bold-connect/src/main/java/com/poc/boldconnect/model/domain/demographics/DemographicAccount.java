
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
    "accountNumber",
    "fimp",
    "accountOpeningApplicationId",
    "componentClass",
    "bankAccountType",
    "componentStatus",
    "componentSeparatorCode",
    "branchNumber",
    "bankingRelationshipGroup",
    "taxId",
    "governingState",
    "bankingPackageNumber",
    "bankingPackageType",
    "houseHoldNumber",
    "cpbFlag",
    "accountOpenDate",
    "tanType",
    "cinPrimaryComponentFlag",
    "primaryComponentType",
    "signerType",
    "accountOwnerShipType",
    "promotionalRate",
    "promotionRateDuration",
    "promotionalExpiryDate"
})
public class DemographicAccount {

    @JsonProperty("accountNumber")
    private String accountNumber;
    @JsonProperty("fimp")
    private String fimp;
    @JsonProperty("accountOpeningApplicationId")
    private String accountOpeningApplicationId;
    @JsonProperty("componentClass")
    private String componentClass;
    @JsonProperty("bankAccountType")
    private String bankAccountType;
    @JsonProperty("componentStatus")
    private String componentStatus;
    @JsonProperty("componentSeparatorCode")
    private String componentSeparatorCode;
    @JsonProperty("branchNumber")
    private String branchNumber;
    @JsonProperty("bankingRelationshipGroup")
    private String bankingRelationshipGroup;
    @JsonProperty("taxId")
    private String taxId;
    @JsonProperty("governingState")
    private String governingState;
    @JsonProperty("bankingPackageNumber")
    private String bankingPackageNumber;
    @JsonProperty("bankingPackageType")
    private String bankingPackageType;
    @JsonProperty("houseHoldNumber")
    private String houseHoldNumber;
    @JsonProperty("cpbFlag")
    private Boolean cpbFlag;
    @JsonProperty("accountOpenDate")
    private String accountOpenDate;
    @JsonProperty("tanType")
    private String tanType;
    @JsonProperty("cinPrimaryComponentFlag")
    private Boolean cinPrimaryComponentFlag;
    @JsonProperty("primaryComponentType")
    private String primaryComponentType;
    @JsonProperty("signerType")
    private String signerType;
    @JsonProperty("accountOwnerShipType")
    private String accountOwnerShipType;
    @JsonProperty("promotionalRate")
    private String promotionalRate;
    @JsonProperty("promotionRateDuration")
    private String promotionRateDuration;
    @JsonProperty("promotionalExpiryDate")
    private String promotionalExpiryDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accountNumber")
    public String getAccountNumber() {
        return accountNumber;
    }

    @JsonProperty("accountNumber")
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @JsonProperty("fimp")
    public String getFimp() {
        return fimp;
    }

    @JsonProperty("fimp")
    public void setFimp(String fimp) {
        this.fimp = fimp;
    }

    @JsonProperty("accountOpeningApplicationId")
    public String getAccountOpeningApplicationId() {
        return accountOpeningApplicationId;
    }

    @JsonProperty("accountOpeningApplicationId")
    public void setAccountOpeningApplicationId(String accountOpeningApplicationId) {
        this.accountOpeningApplicationId = accountOpeningApplicationId;
    }

    @JsonProperty("componentClass")
    public String getComponentClass() {
        return componentClass;
    }

    @JsonProperty("componentClass")
    public void setComponentClass(String componentClass) {
        this.componentClass = componentClass;
    }

    @JsonProperty("bankAccountType")
    public String getBankAccountType() {
        return bankAccountType;
    }

    @JsonProperty("bankAccountType")
    public void setBankAccountType(String bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    @JsonProperty("componentStatus")
    public String getComponentStatus() {
        return componentStatus;
    }

    @JsonProperty("componentStatus")
    public void setComponentStatus(String componentStatus) {
        this.componentStatus = componentStatus;
    }

    @JsonProperty("componentSeparatorCode")
    public String getComponentSeparatorCode() {
        return componentSeparatorCode;
    }

    @JsonProperty("componentSeparatorCode")
    public void setComponentSeparatorCode(String componentSeparatorCode) {
        this.componentSeparatorCode = componentSeparatorCode;
    }

    @JsonProperty("branchNumber")
    public String getBranchNumber() {
        return branchNumber;
    }

    @JsonProperty("branchNumber")
    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    @JsonProperty("bankingRelationshipGroup")
    public String getBankingRelationshipGroup() {
        return bankingRelationshipGroup;
    }

    @JsonProperty("bankingRelationshipGroup")
    public void setBankingRelationshipGroup(String bankingRelationshipGroup) {
        this.bankingRelationshipGroup = bankingRelationshipGroup;
    }

    @JsonProperty("taxId")
    public String getTaxId() {
        return taxId;
    }

    @JsonProperty("taxId")
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @JsonProperty("governingState")
    public String getGoverningState() {
        return governingState;
    }

    @JsonProperty("governingState")
    public void setGoverningState(String governingState) {
        this.governingState = governingState;
    }

    @JsonProperty("bankingPackageNumber")
    public String getBankingPackageNumber() {
        return bankingPackageNumber;
    }

    @JsonProperty("bankingPackageNumber")
    public void setBankingPackageNumber(String bankingPackageNumber) {
        this.bankingPackageNumber = bankingPackageNumber;
    }

    @JsonProperty("bankingPackageType")
    public String getBankingPackageType() {
        return bankingPackageType;
    }

    @JsonProperty("bankingPackageType")
    public void setBankingPackageType(String bankingPackageType) {
        this.bankingPackageType = bankingPackageType;
    }

    @JsonProperty("houseHoldNumber")
    public String getHouseHoldNumber() {
        return houseHoldNumber;
    }

    @JsonProperty("houseHoldNumber")
    public void setHouseHoldNumber(String houseHoldNumber) {
        this.houseHoldNumber = houseHoldNumber;
    }

    @JsonProperty("cpbFlag")
    public Boolean getCpbFlag() {
        return cpbFlag;
    }

    @JsonProperty("cpbFlag")
    public void setCpbFlag(Boolean cpbFlag) {
        this.cpbFlag = cpbFlag;
    }

    @JsonProperty("accountOpenDate")
    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    @JsonProperty("accountOpenDate")
    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

    @JsonProperty("tanType")
    public String getTanType() {
        return tanType;
    }

    @JsonProperty("tanType")
    public void setTanType(String tanType) {
        this.tanType = tanType;
    }

    @JsonProperty("cinPrimaryComponentFlag")
    public Boolean getCinPrimaryComponentFlag() {
        return cinPrimaryComponentFlag;
    }

    @JsonProperty("cinPrimaryComponentFlag")
    public void setCinPrimaryComponentFlag(Boolean cinPrimaryComponentFlag) {
        this.cinPrimaryComponentFlag = cinPrimaryComponentFlag;
    }

    @JsonProperty("primaryComponentType")
    public String getPrimaryComponentType() {
        return primaryComponentType;
    }

    @JsonProperty("primaryComponentType")
    public void setPrimaryComponentType(String primaryComponentType) {
        this.primaryComponentType = primaryComponentType;
    }

    @JsonProperty("signerType")
    public String getSignerType() {
        return signerType;
    }

    @JsonProperty("signerType")
    public void setSignerType(String signerType) {
        this.signerType = signerType;
    }

    @JsonProperty("accountOwnerShipType")
    public String getAccountOwnerShipType() {
        return accountOwnerShipType;
    }

    @JsonProperty("accountOwnerShipType")
    public void setAccountOwnerShipType(String accountOwnerShipType) {
        this.accountOwnerShipType = accountOwnerShipType;
    }

    @JsonProperty("promotionalRate")
    public String getPromotionalRate() {
        return promotionalRate;
    }

    @JsonProperty("promotionalRate")
    public void setPromotionalRate(String promotionalRate) {
        this.promotionalRate = promotionalRate;
    }

    @JsonProperty("promotionRateDuration")
    public String getPromotionRateDuration() {
        return promotionRateDuration;
    }

    @JsonProperty("promotionRateDuration")
    public void setPromotionRateDuration(String promotionRateDuration) {
        this.promotionRateDuration = promotionRateDuration;
    }

    @JsonProperty("promotionalExpiryDate")
    public String getPromotionalExpiryDate() {
        return promotionalExpiryDate;
    }

    @JsonProperty("promotionalExpiryDate")
    public void setPromotionalExpiryDate(String promotionalExpiryDate) {
        this.promotionalExpiryDate = promotionalExpiryDate;
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
        return new HashCodeBuilder().append(accountNumber).append(fimp).append(accountOpeningApplicationId).append(componentClass).append(bankAccountType).append(componentStatus).append(componentSeparatorCode).append(branchNumber).append(bankingRelationshipGroup).append(taxId).append(governingState).append(bankingPackageNumber).append(bankingPackageType).append(houseHoldNumber).append(cpbFlag).append(accountOpenDate).append(tanType).append(cinPrimaryComponentFlag).append(primaryComponentType).append(signerType).append(accountOwnerShipType).append(promotionalRate).append(promotionRateDuration).append(promotionalExpiryDate).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DemographicAccount) == false) {
            return false;
        }
        DemographicAccount rhs = ((DemographicAccount) other);
        return new EqualsBuilder().append(accountNumber, rhs.accountNumber).append(fimp, rhs.fimp).append(accountOpeningApplicationId, rhs.accountOpeningApplicationId).append(componentClass, rhs.componentClass).append(bankAccountType, rhs.bankAccountType).append(componentStatus, rhs.componentStatus).append(componentSeparatorCode, rhs.componentSeparatorCode).append(branchNumber, rhs.branchNumber).append(bankingRelationshipGroup, rhs.bankingRelationshipGroup).append(taxId, rhs.taxId).append(governingState, rhs.governingState).append(bankingPackageNumber, rhs.bankingPackageNumber).append(bankingPackageType, rhs.bankingPackageType).append(houseHoldNumber, rhs.houseHoldNumber).append(cpbFlag, rhs.cpbFlag).append(accountOpenDate, rhs.accountOpenDate).append(tanType, rhs.tanType).append(cinPrimaryComponentFlag, rhs.cinPrimaryComponentFlag).append(primaryComponentType, rhs.primaryComponentType).append(signerType, rhs.signerType).append(accountOwnerShipType, rhs.accountOwnerShipType).append(promotionalRate, rhs.promotionalRate).append(promotionRateDuration, rhs.promotionRateDuration).append(promotionalExpiryDate, rhs.promotionalExpiryDate).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
