package com.poc.boldconnect.controller;

import com.poc.boldconnect.dao.LedgerAccountDao;
import com.poc.boldconnect.delegate.LegerAccountDelegate;
import com.poc.boldconnect.exception.ClientSideException;
import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.request.AccountRequest;
import com.poc.boldconnect.model.response.AccountResponse;
import com.poc.boldconnect.model.response.PersistAccountResponse;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.util.CommonUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class LedgerAccountController {

    private static Logger LOG = LoggerFactory.getLogger(LedgerAccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/accounts";
    public static final String UUID = "uuid";

    private final LegerAccountDelegate accountDelegate;

    @Autowired
    public LedgerAccountController(LegerAccountDelegate accountDelegate) {
        this.accountDelegate = accountDelegate;

    }

    @ApiOperation(value = "Lookup an account", nickname = "accountLookup", response = AccountRequest.class,
            notes = "mock account data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = AccountRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccount(@RequestHeader(value = "uuid", required = true) String uuid, @RequestHeader(required = true) String userAcctId) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAcctId==null || userAcctId.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        return accountDelegate.fetchAccounts(userAcctId,responseHeaders);
    }

    @ApiOperation(value = "Save account data ", nickname = "insertOrUpdateAccounts", response = PersistAccountResponse.class)
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PersistAccountResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = ErrorResponse.class)})
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> insertOrUpdateAccounts(@ApiParam(name = "uuid", value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671") @RequestHeader(value = "uuid") String uuid,
                                                    @RequestBody @Valid AccountRequest request,@RequestHeader(required = true) String userAcctId


    ) {
        LOG.info("---  Beginning Action --- insertOrUpdateAccounts for  UUID [{}]", uuid);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        final String json = CommonUtils.convertObjectToJson(request);
        LOG.info("json = {} ", json);

        List<Account> accounts = request.getAccounts();
        List<Account> collectAccts = null;
        if (accounts != null) {

            collectAccts = accounts.stream().filter(account -> userAcctId.equals(account.getUserAccountId())).collect(Collectors.toList());
            if (collectAccts == null || collectAccts.isEmpty()) {
                throw new ClientSideException("Please check your input. Header in input and payload should match");
            }
        }

        return accountDelegate.saveAccounts(collectAccts, responseHeaders);

    }


}