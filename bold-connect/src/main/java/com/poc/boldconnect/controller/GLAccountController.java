package com.poc.boldconnect.controller;

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

import com.poc.boldconnect.delegate.LedgerGLAccountDelegate;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.GLAccountResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class GLAccountController {


    private static Logger LOG = LoggerFactory.getLogger(GLAccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/gl/accounts";
    public static final String UUID = "uuid";
    public static final String MOCK = "mock";

    private final LedgerGLAccountDelegate ledgerGLAccountDelegate;

    @Autowired
    public GLAccountController(LedgerGLAccountDelegate LedgerGLAccountDelegate) {
        this.ledgerGLAccountDelegate = LedgerGLAccountDelegate;
    }

    @ApiOperation(value = "Lookup an accounts", nickname = "accountsLookup", response = GLAccount.class,
            notes = "Returns GL Account data via an API call to Greenlight. Can be mocked to avoid the API call using the 'mock' parameter.")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = GLAccountResponse.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccounts(
    		@ApiParam(name = "uuid", required=true, value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671")@RequestHeader(value = "uuid", required = true) String uuid,
    		@ApiParam(name = "userAccountId", required=true, value = "The user account for which you are looking up Greenlight accounts") @RequestHeader(value = "userAccountId", required = true) String userAccountId,
    		@ApiParam(name = "mock", required=false, value = "Indicate whether you want to go out to the Greenlight api, or want a mocked value", defaultValue = "false")@RequestHeader(value = "mock", required = false) String mock,
			@ApiParam(name = "greenlightAccountId", required=false, value = "The greenlight account for which you want data. If empty, this will return all greenlight accounts for this userAccountId", defaultValue="48c5b071-398e-4fc6-a900-d2d73e09f778") @RequestHeader(value = "greenlightAccountId", required = false) String greenlightAccountId)
    {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        boolean mockValue = true;
        if(mock != null) {
        	mockValue = mock.equalsIgnoreCase("true");
        }
        responseHeaders.set(UUID, uuid);
        responseHeaders.set(MOCK, "" + mockValue);

        if(userAccountId==null || userAccountId.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        return ledgerGLAccountDelegate.fetchAccounts(userAccountId, greenlightAccountId, mockValue,responseHeaders);
    }

}
