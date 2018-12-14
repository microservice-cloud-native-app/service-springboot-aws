package com.poc.boldconnect.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by rd82846 on 11/25/2016.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionLocation {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int locationId;
    @ApiModelProperty(value = "Address line 1")
    private String addressLine1;
    @ApiModelProperty(value = "Address line 2")
    private String addressLine2;
    @ApiModelProperty(value = "City where transaction took place")
    private String city;
    @ApiModelProperty(value = "State where transaction took place")
    private String stateName;
    @ApiModelProperty(value = "Country where transaction took place")
    private String countryCode;
    @ApiModelProperty(value = "Zipcode where transaction took place")
    private Integer zipCode;
    @ApiModelProperty(value = "Longitude where transaction took place")
    private Double longitude;
    @ApiModelProperty(value = "Latitude where transaction took place")
    private Double latitude;
}
