package com.poc.boldconnect.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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


    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String financialInstituteCode;


    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String financialInstName;




    @ApiModelProperty(required = true, hidden = true)
    private String accountTitleName;


    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    private String displayAccountNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    @ApiModelProperty(required = true, hidden = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate = null;

    @ApiModelProperty(required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime modifiedDate = null;

    private String lastUpdated;


    @NotBlank
    @ApiModelProperty(required = true)
    private String dataProviderCode;






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




}
