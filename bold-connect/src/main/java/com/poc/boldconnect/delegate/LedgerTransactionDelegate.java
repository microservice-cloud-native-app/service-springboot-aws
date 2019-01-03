package com.poc.boldconnect.delegate;

import com.poc.boldconnect.dao.LedgerTransactionDao;
import com.poc.boldconnect.model.domain.Transaction;
import com.poc.boldconnect.model.response.ErrorResponse;
import com.poc.boldconnect.model.response.PersistTransactionResponse;
import com.poc.boldconnect.model.response.TransactionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LedgerTransactionDelegate {

    private final LedgerTransactionDao transactionDao;

    private static Logger LOG = LoggerFactory.getLogger(LedgerTransactionDelegate.class);

    public LedgerTransactionDelegate(LedgerTransactionDao ledgerTransactionDao) {

        this.transactionDao = ledgerTransactionDao;
    }

    public ResponseEntity<?> fetchTransactions(String userAcctId, HttpHeaders responseHeaders){


        List<Transaction> transactions =  transactionDao.getTransactions(userAcctId);
        if (null != transactions && !transactions.isEmpty()) {
            TransactionResponse transactionResponse = new TransactionResponse();
            transactionResponse.setData(transactions);
            transactionResponse.setCode(200);
            LOG.info("Success Response for userId {}",userAcctId);
            return new ResponseEntity<>(transactionResponse, responseHeaders, HttpStatus.OK);
        } else {// TODO if some other error thrown handle it
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Look on message properties file and global exception file for error binding");
            LOG.info("Error Response for userId {}",userAcctId);
            return new ResponseEntity<>(errorResponse, responseHeaders, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> saveTransactions(List<Transaction> transactions,HttpHeaders responseHeaders){

        transactionDao.saveTransactions(transactions);
        PersistTransactionResponse persistTransactionResponse = new PersistTransactionResponse();
        persistTransactionResponse.setData(true);
        persistTransactionResponse.setCode(200);
        persistTransactionResponse.setMessage("Data Save Successful");
        LOG.info("Data saved");
        return new ResponseEntity<>(persistTransactionResponse, responseHeaders, HttpStatus.OK);
    }
}
