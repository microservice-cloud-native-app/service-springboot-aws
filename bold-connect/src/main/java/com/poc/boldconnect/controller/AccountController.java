package com.poc.boldconnect.controller;

import com.poc.boldconnect.dao.BoldConnectDao;
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
public class AccountController {

    private static Logger LOG = LoggerFactory.getLogger(AccountController.class);
    public static final String RESOURCE_NAME = "/service/v1/boldConnect/accounts";
    public static final String UUID = "uuid";

    private final BoldConnectDao boldConnectDao;

    @Autowired
    public AccountController(BoldConnectDao boldConnectDao) {
        this.boldConnectDao = boldConnectDao;

    }

    @ApiOperation(value = "Lookup an account", nickname = "accountLookup", response = AccountRequest.class,
            notes = "mock account data response ")
    @ApiResponses({ @ApiResponse(code = 200, message = "OK", response = AccountRequest.class), @ApiResponse(code = 404, message = "NOT_FOUND", response = ErrorResponse.class), })
    @RequestMapping(value = RESOURCE_NAME , method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> lookupAccount(@RequestHeader(value = "uuid", required = true) String uuid, @RequestParam(required = false) String accountNumberValue) {
        LOG.debug("---  Beginning Action ---");

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        String json = CommonUtils.getInputFromFileUsingStream("AccountRequests.json");
        final AccountRequest accountRequest = CommonUtils.convertJSONToObject(json, AccountRequest.class);

        if (null != accountRequest) {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setData(accountRequest.getAccounts());
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
                                                    @RequestBody @Valid AccountRequest request,
                                                    @ApiParam(name = "empowerId", value = "empowerId", required = true) @RequestHeader(value = "empowerId", required = false) String empowerId,
                                                    @ApiParam(name = "accessToken", value = "accessToken", defaultValue = "abbb4837-8343-418c-93d8-77a8519dff9e") @RequestHeader(value = "accessToken", required = false) String accessToken,
                                                    @ApiParam(name = "businessCode", value = "business code ", defaultValue = "GCB") @RequestHeader(value = "businessCode", required = false) String businessCode,
                                                    @ApiParam(name = "countryCode", value = "Country code, example US", defaultValue = "US") @RequestHeader(value = "countryCode", required = false) String countryCode,
                                                    @ApiParam(name = "channelId", value = "channelId, example CNV", defaultValue = "CNV") @RequestHeader(value = "channelId", required = false) String channelId,
                                                    @ApiParam(name = "Accept-Language", value = "Accept-Language, example en-US", defaultValue = "en-US") @RequestHeader(value = "Accept-Language", required = false) String acceptLanguage,
                                                    @ApiParam(name = "Accept", value = "Accept, example application/json", defaultValue = "application/json") @RequestHeader(value = "Accept", required = false) String accept,
                                                    @ApiParam(name = "Authorization", value = "Authorization", defaultValue = "some authorization token") @RequestHeader(value = "Authorization", required = false) String authorization,
                                                    @ApiParam(name = "client_id", value = "client_id", defaultValue = "client_id") @RequestHeader(value = "client_id", required = false) String clientId,
                                                    @ApiParam(name = "sid", value = "sid", defaultValue = "abbb4837-8343-418c-93d8-77a8519dff9e") @RequestHeader(value = "sid", required = false) String sid

    ) {
        LOG.info("---  Beginning Action --- insertOrUpdateAccounts for empowerId [{}] , UUID [{}]", empowerId, uuid);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(UUID, uuid);

        final String json = CommonUtils.convertObjectToJson(request);
        LOG.info("json = {} ", json);

        List<Account> accounts = request.getAccounts();
        boldConnectDao.saveAccounts(accounts);
        PersistAccountResponse persistAccountResponse = new PersistAccountResponse();
        return new ResponseEntity<>(persistAccountResponse, responseHeaders, HttpStatus.OK);

    }


}