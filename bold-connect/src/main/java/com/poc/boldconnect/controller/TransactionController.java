package com.poc.boldconnect.controller;

import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.request.AccountRequest;
import com.poc.boldconnect.model.request.TransactionRequest;
import com.poc.boldconnect.model.response.AccountResponse;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.TransactionResponse;
import com.poc.boldconnect.util.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransactionController {


    private static Logger LOG = LoggerFactory.getLogger(AccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/transactions";
    public static final String UUID = "uuid";


    @ApiOperation(value = "Lookup an transaction", nickname = "transactionLookup", response = Account.class,
            notes = "mock transaction data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = Account.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccount(@RequestHeader(value = "uuid", required = true) String uuid) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        String json = CommonUtils.getInputFromFileUsingStream("TransactionRequests.json");
        TransactionRequest transactionRequest = (TransactionRequest)CommonUtils.convertJSONToObject(json,TransactionRequest.class);

        if (null != transactionRequest) {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setData(transactionRequest.getTransactions());
            return new ResponseEntity<>(transactionResponse, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }
}
