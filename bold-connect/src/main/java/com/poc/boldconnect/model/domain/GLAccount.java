package com.poc.boldconnect.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public class GLAccount {

    @NotBlank
    @ApiModelProperty(notes = "An opaque unique ID used to identify this account to the API", readOnly = true)
    private String id;

    @ApiModelProperty(notes = "Name of account holder (child).")
    private String name;

    @ApiModelProperty(notes = "Reference to optional custom image selected by the customer for this card")
    @JsonProperty("Image_url")
     private String image_url;

    @ApiModelProperty(notes ="The last four digits of the card number.")
    private String acct_last_four;

    @ApiModelProperty(notes ="Total available balance on card in cents")
    private BigDecimal available_balance;

    @ApiModelProperty(notes = "Balance available to spend in cents")
    private BigDecimal spend;

    @ApiModelProperty(notes ="Balance available to save in cents.")
    private BigDecimal save;

    @ApiModelProperty(notes ="Balance available to give in cents.")
    private BigDecimal give;

    @ApiModelProperty(notes = "Balance available to earn in cents.")
    private BigDecimal earn;
}
