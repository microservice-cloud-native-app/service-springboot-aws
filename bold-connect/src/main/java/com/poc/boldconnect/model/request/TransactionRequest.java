package com.poc.boldconnect.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poc.boldconnect.model.domain.Transaction;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by rd82846 on 11/29/2016.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class TransactionRequest {
    @ApiModelProperty(required = true)
    private List<Transaction> transactions;
    @ApiModelProperty(required = true)
    private String dataProviderCode;
    @ApiModelProperty(required = true)
    private Integer userAccountId;
    @ApiModelProperty(required = true,hidden=true)
    private Boolean persistPendingTransactions;
    @ApiModelProperty(required = true,hidden=true)
    private Boolean updateTransactions;
}
