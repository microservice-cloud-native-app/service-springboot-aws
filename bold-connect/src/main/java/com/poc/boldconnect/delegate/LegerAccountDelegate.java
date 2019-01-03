package com.poc.boldconnect.delegate;

import com.poc.boldconnect.controller.LedgerTransactionController;
import com.poc.boldconnect.dao.LedgerAccountDao;
import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.response.AccountResponse;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.PersistAccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LegerAccountDelegate {

    private final LedgerAccountDao ledgerAccountDao;

    private static Logger LOG = LoggerFactory.getLogger(LegerAccountDelegate.class);

    public LegerAccountDelegate(LedgerAccountDao ledgerAccountDao) {
        this.ledgerAccountDao = ledgerAccountDao;
    }

    public ResponseEntity<?> fetchAccounts(String userAcctId, HttpHeaders responseHeaders){

        List<Account> accounts = ledgerAccountDao.getAccounts(userAcctId);

        if (null != accounts && !accounts.isEmpty()) {
            AccountResponse accountResponse = new AccountResponse();
            accountResponse.setData(accounts);
            accountResponse.setCode(200);
            accountResponse.setMessage("Data Fetch Success");
            LOG.info("Success Response for userId {}",userAcctId);
            return new ResponseEntity<>(accountResponse, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("No Record found");
            errorResponse.setCode(404);
            LOG.info("Error Response for userId {}",userAcctId);
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> saveAccounts(List<Account> accounts,HttpHeaders responseHeaders){

        ledgerAccountDao.saveAccounts(accounts);
        PersistAccountResponse persistAccountResponse = new PersistAccountResponse();
        persistAccountResponse.setCode(200);
        persistAccountResponse.setMessage("Data Save Successful");
        LOG.info("Data saved");
        return new ResponseEntity<>(persistAccountResponse, responseHeaders, HttpStatus.OK);
    }
}
