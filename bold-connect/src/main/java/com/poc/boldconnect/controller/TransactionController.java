package com.poc.boldconnect.controller;

import com.poc.boldconnect.dao.TransactionDao;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.domain.Transaction;
import com.poc.boldconnect.model.request.AccountRequest;
import com.poc.boldconnect.model.request.TransactionRequest;
import com.poc.boldconnect.model.response.AccountResponse;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.PersistTransactionResponse;
import com.poc.boldconnect.model.response.TransactionResponse;
import com.poc.boldconnect.util.CommonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class TransactionController {


    private static Logger LOG = LoggerFactory.getLogger(TransactionController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/transactions";
    public static final String UUID = "uuid";

    private final TransactionDao transactionDao;

    @Autowired
    public TransactionController(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    @ApiOperation(value = "Lookup an transaction", nickname = "transactionLookup", response = TransactionRequest.class,
            notes = "mock transaction data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TransactionRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupTransactions(@RequestHeader(value = "uuid", required = true) String uuid, @RequestHeader(required = true) String userAcctNumber) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAcctNumber==null || userAcctNumber.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        List<Transaction> transactions =  transactionDao.getTransactions(userAcctNumber);
        if (null != transactions && !transactions.isEmpty()) {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setData(transactions);
            transactionResponse.setCode(200);
            return new ResponseEntity<>(transactionResponse, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Save transaction details", nickname = "transactionSave", response = TransactionRequest.class,
            notes = "mock transaction data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TransactionRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> saveTransactions(@ApiParam(name = "uuid", value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671")
                                                  @RequestHeader(value = "uuid", required = true) String uuid,
                                                  @RequestBody TransactionRequest transactionRequest) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        final String json = CommonUtils.convertObjectToJson(transactionRequest);
        LOG.info("json = {} ", json);
        LOG.info("transactionRequest {}",transactionRequest);

        transactionDao.saveTransactions(transactionRequest.getTransactions());
        PersistTransactionResponse persistTransactionResponse = new PersistTransactionResponse();
        persistTransactionResponse.setData(true);
        persistTransactionResponse.setCode(200);
        persistTransactionResponse.setMessage("Data Save Successful");
        return new ResponseEntity<>(persistTransactionResponse, responseHeaders, HttpStatus.OK);

    }
}
