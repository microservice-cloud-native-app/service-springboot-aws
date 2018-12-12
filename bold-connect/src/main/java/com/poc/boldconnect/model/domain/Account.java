package com.poc.boldconnect.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by GK82893 on 12/19/2016.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {
    // ids
    @NotBlank
    @ApiModelProperty(required = true)
    private String accountId;

    
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String externalAccountRefId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true)
    private String externalAccountGroupRefId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String userAccountId;

    // balances
    @ApiModelProperty(required = true, notes = "This is deprecated.  Please use availableBalance, currentBalance fields")
    @Deprecated
    private Balance balance;

    @ApiModelProperty(required = true, notes = "This is deprecated. Please use accountNumber, accountName fields")
    @Deprecated
    private Meta meta;

    // balances
    // investment account
    @ApiModelProperty("cash balance for investment accounts")
    private BigDecimal cash;
    @ApiModelProperty("margin balance for investment accounts")
    private BigDecimal marginBalance;

    // credit card
    @ApiModelProperty("credit card amount due")
    private BigDecimal amountDue;
    @ApiModelProperty("credit card minimum amount due")
    private BigDecimal minimumAmountDue;
    @ApiModelProperty("credit card balance ")
    private BigDecimal creditCardBalance;
    @ApiModelProperty("cash advance limit for credit card account")
    private BigDecimal cashAdvanceLimit;
    @ApiModelProperty("cash advance available amount for credit card account")
    private BigDecimal cashAdvanceAvailable;
    @ApiModelProperty("credit limit for credit card account")
    private BigDecimal creditLimitAmount;
    @ApiModelProperty("used credit amount for credit card account")
    private BigDecimal usedCreditAmount;
    @ApiModelProperty("available credit amount for credit card account")
    private BigDecimal availableCredit;
    @ApiModelProperty("lastStatementBalance amount for credit card account")
    private BigDecimal lastStatementBalanceAmt;
    @ApiModelProperty("credit card payment due date")
    private String paymentDueDate;


    // bank account ( savings/checking )
    @ApiModelProperty("checking/savings account available balance")
    private BigDecimal availableBalance;
    @ApiModelProperty("checking/savings account current balance")
    private BigDecimal currentBalance;

    // account details
    @ApiModelProperty(required = true)
    private String accountName;

    @ApiModelProperty(required = true)
    private String accountNumber;

    @ApiModelProperty(value = "Routing account number if available")
    private String routingNumber;

    @NotBlank
    @ApiModelProperty(required = true)
    private String accountType;
    
    @ApiModelProperty(value = "account subtype if available")
    private String accountSubType;

    @NotBlank
    @ApiModelProperty(required = true)
    private String accountStatus;

    @NotBlank
    @ApiModelProperty(required = true)
    private String countryCode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String financialInstituteCode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String financialInstName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(required = true, hidden = true)
    private String accountTitleName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String displayAccountNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private LocalDateTime createdDate = null;

    @ApiModelProperty(required = true)
    private LocalDateTime modifiedDate = null;

    private String lastUpdated;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String dataProviderCode;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String currencyCode;

    // These two properties are needed, we copy the values to FinancialInstititutionAccount level
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "Logo Url of the financial Instituition associated with the account",  hidden = true)
    private String logo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "Favicon Url of the financial Instituition associated with the account",  hidden = true)
    private String favicon;

    @ApiModelProperty(value = "This is the account Refresh Status. Coming from the 3rd party Aggregator ",allowableValues = "SUCCESS,CREDENTIAL_CHANGED, UPDATE_ERROR,CREDENTIAL_EXPIRED,ACCOUNT_NOT_FOUND,GENERIC_ERROR,LOCKED,REPORTED_CLOSED")
    private String accountRefreshStatus;
    @Data
    @NoArgsConstructor
    public final static class Balance {
        @ApiModelProperty(required = true)
        private BigDecimal available;
        @ApiModelProperty(required = true)
        private BigDecimal current;
    }

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public final static class Meta {
        private BigDecimal limit;
        @ApiModelProperty(required = true)
        private String name;
        @ApiModelProperty(required = true)
        private String number;


    }
    @ApiModelProperty("This tells us whether the account alreay exists ")
    private Boolean accountAlreadyExists;

}
