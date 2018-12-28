package com.poc.boldconnect.controller;

import com.poc.boldconnect.dao.LedgerTransactionDao;
import com.poc.boldconnect.delegate.LedgerTransactionDelegate;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.domain.Transaction;
import com.poc.boldconnect.model.request.TransactionRequest;
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

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class LedgerTransactionController {


    private static Logger LOG = LoggerFactory.getLogger(LedgerTransactionController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/transactions";
    public static final String UUID = "uuid";

    private final LedgerTransactionDelegate ledgerTransactionDelegate;

    @Autowired
    public LedgerTransactionController(LedgerTransactionDelegate ledgerTransactionDelegate) {
        this.ledgerTransactionDelegate = ledgerTransactionDelegate;
    }

    @ApiOperation(value = "Lookup an transaction", nickname = "transactionLookup", response = TransactionRequest.class,
            notes = "mock transaction data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TransactionRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupTransactions(@RequestHeader(value = "uuid", required = true) String uuid,
                                                @RequestHeader(required = true) String userAccountId) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAccountId==null || userAccountId.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        return ledgerTransactionDelegate.fetchTransactions(userAccountId,responseHeaders);
    }

    @ApiOperation(value = "Save transaction details", nickname = "transactionSave", response = TransactionRequest.class,
            notes = "mock transaction data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = TransactionRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> saveTransactions(@ApiParam(name = "uuid", value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671")
                                                  @RequestHeader(value = "uuid", required = true) String uuid,
                                                  @RequestBody TransactionRequest transactionRequest,
                                               @RequestHeader(required = true) String userAccountId) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        final String json = CommonUtils.convertObjectToJson(transactionRequest);
        LOG.info("json = {} ", json);
        LOG.info("transactionRequest {}",transactionRequest);

        List<Transaction> txns = transactionRequest.getTransactions();
        List<Transaction> transactions = null;
        if (txns != null) {

            transactions = txns.stream().filter(transaction -> userAccountId.equals(transaction.getUserAccountId())).collect(Collectors.toList());
            if (transactions == null || transactions.isEmpty()) {
                throw new ClientSideException("Please check your input. Header in input and payload should match");
            }
        }

        return ledgerTransactionDelegate.saveTransactions(transactions,responseHeaders);

    }
}
