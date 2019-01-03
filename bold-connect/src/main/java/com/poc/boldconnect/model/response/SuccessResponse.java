package com.poc.boldconnect.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by GK82893 on 12/20/2016.
 */
@Data
public class SuccessResponse<T> {
    @ApiModelProperty(required = true)
    private T data;
    private String message;
    @ApiModelProperty(required = true)
    private int code;
}

