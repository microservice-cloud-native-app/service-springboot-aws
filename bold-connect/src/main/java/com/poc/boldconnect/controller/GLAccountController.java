package com.poc.boldconnect.controller;

import com.poc.boldconnect.delegate.LedgerGLAccountDelegate;
import com.poc.boldconnect.delegate.LedgerTransactionDelegate;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.request.TransactionRequest;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.GLAccountResponse;
import io.swagger.annotations.ApiOperation;
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
public class GLAccountController {


    private static Logger LOG = LoggerFactory.getLogger(GLAccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/gl/accounts";
    public static final String UUID = "uuid";

    private final LedgerGLAccountDelegate ledgerGLAccountDelegate;

    @Autowired
    public GLAccountController(LedgerGLAccountDelegate LedgerGLAccountDelegate) {
        this.ledgerGLAccountDelegate = LedgerGLAccountDelegate;
    }

    @ApiOperation(value = "Lookup an accounts", nickname = "transactionLookup", response = GLAccount.class,
            notes = "mock accounts data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = GLAccountResponse.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccounts(@RequestHeader(value = "uuid", required = true) String uuid,
                                            @RequestHeader(required = true) String userAcctId) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAcctId==null || userAcctId.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        return ledgerGLAccountDelegate.fetchAccounts(userAcctId,responseHeaders);
    }

}
