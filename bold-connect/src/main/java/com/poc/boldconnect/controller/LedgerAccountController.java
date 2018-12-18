package com.poc.boldconnect.controller;

import com.poc.boldconnect.dao.AccountDao;
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


@RestController
public class LedgerAccountController {

    private static Logger LOG = LoggerFactory.getLogger(LedgerAccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/accounts";
    public static final String UUID = "uuid";

    private final AccountDao accountDao;

    @Autowired
    public LedgerAccountController(AccountDao accountDao) {
        this.accountDao = accountDao;

    }

    @ApiOperation(value = "Lookup an account", nickname = "accountLookup", response = AccountRequest.class,
            notes = "mock account data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = AccountRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccount(@RequestHeader(value = "uuid", required = true) String uuid, @RequestHeader(required = true) String userAcctNumber) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        if(userAcctNumber==null || userAcctNumber.isEmpty()){
            throw new ClientSideException("userAcctNumber is null or empty in header");
        }

        List<Account> accounts = accountDao.getAccounts(userAcctNumber);

        if (null != accounts && !accounts.isEmpty()) {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setData(accounts);
            return new ResponseEntity<>(accountResponse, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Save account data ", nickname = "insertOrUpdateAccounts", response = PersistAccountResponse.class)
    @ApiResponses({@ApiResponse(code = 200, message = "OK", response = PersistAccountResponse.class),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class),
            @ApiResponse(code = 500, message = "INTERNAL_SERVER_ERROR", response = ErrorResponse.class)})
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST, produces = {
            MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> insertOrUpdateAccounts(@ApiParam(name = "uuid", value = "A 128 bit universally unique identifier (UUID) that you generate for every request and is used for tracking.", defaultValue = "f4b14e1c-0d80-11e7-93ae-92361f002671") @RequestHeader(value = "uuid") String uuid,
                                                    @RequestBody @Valid AccountRequest request


    ) {
        LOG.info("---  Beginning Action --- insertOrUpdateAccounts for  UUID [{}]",  uuid);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        final String json = CommonUtils.convertObjectToJson(request);
        LOG.info("json = {} ", json);

        List<Account> accounts = request.getAccounts();
        accountDao.saveAccounts(accounts);
        PersistAccountResponse persistAccountResponse = new PersistAccountResponse();
        persistAccountResponse.setCode(200);
        persistAccountResponse.setMessage("Data Save Successful");
        return new ResponseEntity<>(persistAccountResponse, responseHeaders, HttpStatus.OK);

    }


}