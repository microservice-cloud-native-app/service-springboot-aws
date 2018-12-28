package com.poc.boldconnect.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

/**
 * Created by rd82846 on 11/16/2016.
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Transaction {

	@ApiModelProperty(value = "Id of the transaction", required = true)
	private String transactionId;

	@ApiModelProperty(value = "user account id (empower id) of the transaction", required = true)
	private String userAccountId;

	@ApiModelProperty(value = "account id associated with the transaction", required = true)
	private String accountId;

	@ApiModelProperty(value = "Account Category Type of the transaction", required = true)
	private String accountCategoryType;

	@ApiModelProperty(value = "The transaction amount", required = true)
	private BigDecimal transactionAmount;

	// category related fields
	@ApiModelProperty(value = "Category code of the transaction", required = true)
	private String transactionCategoryCode;

	@ApiModelProperty(value = "Category name of the transaction", required = true)
	private String transactionCategoryName;

	@JsonIgnore
	private String userLevelCatCode;

	@JsonIgnore
	private String transactionCategorySyn;

	@ApiModelProperty(value = "The date of the transaction", required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;

	@ApiModelProperty(value = "The type of the transaction ", required = true, allowableValues = "DEBIT, CREDIT")
	private String transactionType;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private String transactionCode;

	@ApiModelProperty(value = "Transaction description", required = true)
	private String transactionMemoDesc;

	@ApiModelProperty(value = "The date of the transaction")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate transactionPostingDate;

	@ApiModelProperty(value = "Status of the transaction ", required = true, allowableValues = "PENDING,BILLED,UNBILLED")
	private String transactionStatus;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private String externalAccountRefId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private String externalTransactionRefId;

	@ApiModelProperty(value = "The time of the transaction")
	private String transactionTime;

	@ApiModelProperty(value = "Merchant id of the transaction")
	private Merchant merchant;

	@ApiModelProperty(value = "Day of Week of the transaction", allowableValues = "MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY")
	private String transactionDayOfWeek;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private BigDecimal runningBalanceAmount;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private int locationId;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	private String sourceTimeZone;

	@ApiModelProperty(value = "Currency code of transaction")
	private String transactionCurrencyCode;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdDate;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@ApiModelProperty(hidden = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime modifiedDate;

	@ApiModelProperty(value = "Transaction location ")
	private TransactionLocation transactionLocation;

	@JsonIgnore
	private YearMonth transactionMonth;

	@ApiModelProperty(value = "This field is used for discarding a particular transactions", allowableValues = "Y,N")
	private String discardTransactionFlag;

	@ApiModelProperty(value = "This field is used for representing a particular transaction as NEED/WANT/GOAL ", allowableValues = "W,N,G")
	private String nwgCategoryFlag;

	@ApiModelProperty(value = "This field is used for discarding a particular transactions", allowableValues = "Y,N",hidden=true)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String categorizedTransactionFlag;

	@ApiModelProperty(value = "This is the external category code coming in from the aggregator", hidden=true)
	private String externalCategoryCode;

	@Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	@NoArgsConstructor
	public static class Merchant {
		@ApiModelProperty(value = "Citi Merchant id of the transaction")
		private Integer merchantId;
		//@ApiModelProperty(value = "Merchant id of the transaction of the 3rd party aggregator")
		//private String externalRefId;
		@ApiModelProperty(value = "Merchant Name of the transaction")
		private String name;
		//private String merchantLevelCategoryCode;
		//private String description;
		//@ApiModelProperty(value = "Description about the merchant")


	}
	@ApiModelProperty(value = "This is the transaction Classification Code",allowableValues = "SP,IN,NL")
	private String transactionClassificationCode;


	@ApiModelProperty(hidden = true)
	private String dataProviderCode;

	@ApiModelProperty(value = "Maps to isDeleted property in Yodlee transactions object")
	private Boolean isDeleted;




}
