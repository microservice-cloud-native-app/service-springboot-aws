package com.poc.boldconnect.model.response;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;


@Data
public class ErrorResponse {

    @ApiModelProperty(required = true)
    private int code;
    @ApiModelProperty(required = true)
    private String message;
    @JsonIgnore
    private Object exception;
}