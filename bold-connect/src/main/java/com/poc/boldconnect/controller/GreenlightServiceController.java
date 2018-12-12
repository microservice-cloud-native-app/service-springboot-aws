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
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.poc.boldconnect.bl.ParameterValidator;
import com.poc.boldconnect.bl.AccountLookup;
import com.poc.boldconnect.model.request.ServiceRequest;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.util.CommonUtils;
import com.poc.boldconnect.model.domain.Account;


@RestController
public class GreenlightServiceController {
    private static Logger LOG = LoggerFactory.getLogger(ServiceController.class);
    public static final String DOMAIN = "/service/v1/boldConnect/";
    public static final String ACCOUNT_RESOURCE_NAME = DOMAIN + "connectedAccount/";
    public static final String ID_RESOURCE_NAME = DOMAIN + "correlationId/";
    public static final String UUID_KEY = "uuid";
    public static final String ACCOUNT_NUMBER_KEY = "accountNumber";
    private ParameterValidator parameterValidator = new ParameterValidator();
    private HttpHeaders responseHeaders = new HttpHeaders();

    // TODO write your own API to POST/GET, etc..
	//Stub
    @ApiOperation(value = "Create an account", nickname = "createAccount", response = Account.class,
            notes = "sample payload json - {  \"account\" : {    \"accountNumber\": \"161640\",    \"description\": \"Saving\",    \"code\": \"EA\"\t}}")
    @ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = Account.class), @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = ErrorResponse.class),
            @ApiResponse(code = 300, message = "MULTIPLE_CHOICES", response = ErrorResponse.class) })
    @RequestMapping(value = ACCOUNT_RESOURCE_NAME, method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
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
            LOG.error("UUID: " + uuid + ", actionBody: " + actionBody + ", method: /" + DOMAIN + ", exception", e);
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(e, responseHeaders, HttpStatus.MULTIPLE_CHOICES);
        }
    }

	//Stub
    @ApiOperation(value = "Lookup a greenlight account", nickname = "greenlightAccountLookup", response = GreenlightAccount.class);
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Account.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = ACCOUNT_RESOURCE_NAME, method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> getGreenlightAccount(
        	@ApiParam(
            		name = UUID_KEY, 
            		value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking. It is recommended to use the output from Java UUID class or an equivalent", 
            		defaultValue ="a7d1e304-83a9-4413-af97-62615e57eae66807840" ) 
                	@RequestHeader(value = UUID_KEY, required = true) String uuid, 
        	@ApiParam(
            		name = ACCOUNT_NUMBER_KEY, 
            		value = "The Connected Account Number", 
            		defaultValue ="a7d1e304-83a9-4413-af97-62615e57eae66807840" ) 
                	@RequestHeader(value = ACCOUNT_NUMBER_KEY, required = true) String accountNumber, 
      {
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
        	//Stub
            @ApiOperation(value = "Get a correlationID", nickname = "createCorrelationId", response = String.class)
            @ApiResponses({ @ApiResponse(code = 201, message = "CREATED", response = Account.class), @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = ErrorResponse.class),
                    @ApiResponse(code = 300, message = "MULTIPLE_CHOICES", response = ErrorResponse.class) })
            @RequestMapping(value = ID_RESOURCE_NAME, method = RequestMethod.Get, produces = { MediaType.APPLICATION_JSON_VALUE })
            public ResponseEntity<?> getCorrelationId(@RequestHeader(value = "uuid", required = true) String uuid) {
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
                    LOG.error("UUID: " + uuid + ", actionBody: " + actionBody + ", method: /" + DOMAIN + ", exception", e);
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setMessage("Look on message properties file and global exception file for error binding");
                    return new ResponseEntity<>(e, responseHeaders, HttpStatus.MULTIPLE_CHOICES);
                }
            }

}