package com.poc.boldconnect.bl;

import com.poc.boldconnect.exception.ClientSideException;

public class ParameterValidator {
    private static final String REGEX_STORE = "\\d{6}";

    public void validateAccountId(String accountId) throws ClientSideException {
        if(!accountId.matches(REGEX_STORE)){
            throw new ClientSideException(String.format("Invalid account ID, does not match %s accountId=%s",REGEX_STORE,accountId));
        }
    }
}
