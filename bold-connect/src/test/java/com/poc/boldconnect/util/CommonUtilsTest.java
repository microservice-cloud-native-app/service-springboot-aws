package com.poc.boldconnect.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.net.URISyntaxException;

import com.poc.boldconnect.model.domain.Account;
import com.poc.boldconnect.model.domain.Transaction;
import com.poc.boldconnect.model.request.TransactionRequest;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.poc.boldconnect.Application;

public class CommonUtilsTest {
	// TODO fix this for marshalling your own SampleRequest.json's


    @Test
    public void testJsonToPojo() {

        String inputFromFileUsingStream = CommonUtils.getInputFromFileUsingStream("accounts-dbResponse.json");
        Account account = CommonUtils.convertJSONToObject(inputFromFileUsingStream, Account.class);
        assertThat(account, CoreMatchers.notNullValue());
        assertThat(account.getAccountId(),CoreMatchers.notNullValue());
    }
    @Test
    public void testTransactionJsonToPojo() {

        String inputFromFileUsingStream = CommonUtils.getInputFromFileUsingStream("transactions-valid.json");
        TransactionRequest transactionRequest = CommonUtils.convertJSONToObject(inputFromFileUsingStream, TransactionRequest.class);
        assertThat(transactionRequest, CoreMatchers.notNullValue());
        assertThat(transactionRequest.getTransactions(),CoreMatchers.notNullValue());
    }
}
