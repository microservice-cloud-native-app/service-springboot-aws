package com.poc.boldconnect.controller;

import com.poc.boldconnect.delegate.CustomerDemoInfoDelegate;
import com.poc.boldconnect.delegate.LedgerGLAccountDelegate;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.domain.demographics.CustomerInfo;
import com.poc.boldconnect.model.response.CustomerInfoResponse;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.GLAccountResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDemographicsController {


    private static Logger LOG = LoggerFactory.getLogger(CustomerDemographicsController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/customer/info";
    public static final String UUID = "uuid";

    private final CustomerDemoInfoDelegate customerDemoInfoDelegate;

    @Autowired
    public CustomerDemographicsController(CustomerDemoInfoDelegate customerDemoInfoDelegate) {
        this.customerDemoInfoDelegate = customerDemoInfoDelegate;
    }

    @ApiOperation(value = "Lookup an customer's demographic Info", nickname = "demoLookup", response = CustomerInfo.class,
            notes = "mock accounts data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = CustomerInfoResponse.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccounts(@ApiParam(name = "uuid", value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671")@RequestHeader(value = "uuid", required = true) String uuid,
                                            @RequestHeader(required = true) String userAccountId) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAccountId==null || userAccountId.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        return customerDemoInfoDelegate.fetchDemographicDetails(userAccountId,responseHeaders);
    }


}
