package com.poc.boldconnect.dao;

import com.poc.boldconnect.model.domain.Account;

import java.util.List;

public interface BoldConnectDao {

     void saveAccounts(List<Account> accounts);

     List<Account> getAccounts(String userAccountId);
}
