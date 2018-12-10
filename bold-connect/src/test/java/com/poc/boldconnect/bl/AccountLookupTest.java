package com.poc.boldconnect.bl;

import static org.junit.Assert.assertEquals;

import com.poc.boldconnect.exception.ServiceException;
import com.poc.boldconnect.model.domain.Account;
import org.junit.Test;

// TODO write your own unit tests for classes in BL 
public class AccountLookupTest {
	@Test
	public void givenAccountLookupOfAccountNumber161640ThenReturnAccount() throws ServiceException {
		AccountLookup sut = new AccountLookup();
		Account result = sut.lookupAccountByAccountNumber("161640");
		assertEquals("161640",result.getAccountNumber());
	}

	//TODO handle ServiceException if your business login returns that
	public void givenAccountLookupOf12345ThenThrowAccountNotFoundExcpetion() {
		AccountLookup sut = new AccountLookup();
		Account result = sut.lookupAccountByAccountNumber("12345");
		assertEquals(null,result);
	}
}