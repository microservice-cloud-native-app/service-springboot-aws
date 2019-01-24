package com.poc.boldconnect.service;

import org.springframework.http.HttpHeaders;

import com.poc.boldconnect.model.domain.GLAccounts;

public interface GLAccountService {
	public GLAccounts getAccounts(String userAcctId, HttpHeaders responseHeaders);
}
