package com.poc.boldconnect.bl;

import com.poc.boldconnect.exception.ServiceException;
import com.poc.boldconnect.model.domain.Account;

// TODO write your own business logic classes that are used by the ServiceController
public class AccountLookup {
    public Account lookupAccountByAccountNumber(String accountNumber) throws ServiceException {
        Account account = null;
        if ("161640".equals(accountNumber)) {
            account = new Account();
            account.setAccountNumber("161640");
            account.setDescription("Saving from DB");
            account.setCode("EA");
            return account;
        } else {
            return account;
        }
        //TODO if business logic failed then reuturn ServiceException
        //throw new ServiceException("Cannot find account. accountNumber="+accountNumber);
    }
}
