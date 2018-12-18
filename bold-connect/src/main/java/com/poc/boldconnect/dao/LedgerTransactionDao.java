package com.poc.boldconnect.dao;

import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.domain.Transaction;

import java.util.List;

public interface LedgerTransactionDao {

    void saveTransactions(List<Transaction> accounts);

    List<Transaction> getTransactions(String userAccountId);
}
