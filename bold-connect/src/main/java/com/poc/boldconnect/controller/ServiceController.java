package com.poc.boldconnect.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.poc.boldconnect.bl.ParameterValidator;
import com.poc.boldconnect.bl.AccountLookup;
import com.poc.boldconnect.model.request.ServiceRequest;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.util.CommonUtils;
import com.poc.boldconnect.model.domain.Account;


@RestController
public class ServiceController {
    private static Logger LOG = LoggerFactory.getLogger(ServiceController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/";
    public static final String UUID = "uuid";
    private ParameterValidator parameterValidator = new ParameterValidator();
    private HttpHeaders responseHeaders = new HttpHeaders();

    // TODO write your own API to POST/GET, etc..
    @ApiOperation(value = "Create an account", nickname = "createAccount", response = Account.class,
            notes = "sample payload json - {  \"account\" : {    \"accountNumber\": \"161640\",    \"description\": \"Saving\",    \"code\": \"EA\"\t}}")
    @ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = Account.class), @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = ErrorResponse.class),
            @ApiResponse(code = 300, message = "MULTIPLE_CHOICES", response = ErrorResponse.class) })
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> createAccount(@RequestHeader(value = "uuid", required = true) String uuid, @RequestBody String actionBody) {
        LOG.debug("---  Beginning Action ---");
        responseHeaders.set(UUID, uuid);
        LOG.info(actionBody);
        // TODO Write your own BL here to deal with the request.
        //TODO below Try Catch block need to remove once BL - Business Logic code ready
        //TODO below Try Catch is only for dummy data returned from file system
        try {
            ServiceRequest request = (ServiceRequest) CommonUtils.convertJSONToObject(actionBody, ServiceRequest.class);
            parameterValidator.validateAccountId(request.getAccount().getAccountNumber());
            return new ResponseEntity<>(request.getAccount(), responseHeaders, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("UUID: " + uuid + ", actionBody: " + actionBody + ", method: /" + RESOURCE_NAME + ", exception", e);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(e, responseHeaders, HttpStatus.MULTIPLE_CHOICES);
        }
    }

    @ApiOperation(value = "Lookup an account", nickname = "accountLookup", response = Account.class,
            notes = "use 161640 as input account number ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Account.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME + "{accountNumberValue}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccount(@RequestHeader(value = "uuid", required = true) String uuid, @PathVariable String accountNumberValue) {
        LOG.debug("---  Beginning Action ---");
        responseHeaders.set(UUID, uuid);
        Account account = new AccountLookup().lookupAccountByAccountNumber(accountNumberValue);
        if (null != account) {
            return new ResponseEntity<>(account, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }
}