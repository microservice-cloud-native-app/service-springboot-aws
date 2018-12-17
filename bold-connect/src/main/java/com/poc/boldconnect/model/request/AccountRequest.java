package com.poc.boldconnect.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.poc.boldconnect.model.domain.Account;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by GK82893 on 12/27/2016.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRequest {
    @ApiModelProperty(required = true)
    private List<Account> accounts;

}
