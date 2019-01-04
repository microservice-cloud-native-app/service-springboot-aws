package com.poc.boldconnect.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ErrorResponse {

    @ApiModelProperty(required = true)
    private int code;
    @ApiModelProperty(required = true)
    private String message;
    @JsonIgnore
    private Object exception;
}