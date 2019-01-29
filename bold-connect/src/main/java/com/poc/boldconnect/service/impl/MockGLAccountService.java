package com.poc.boldconnect.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.poc.boldconnect.model.domain.GLAccounts;
import com.poc.boldconnect.service.GLAccountService;
import com.poc.boldconnect.util.CommonUtils;

@Component
public class MockGLAccountService implements GLAccountService {
	private static final String GL_ACCOUNT = "gl-account.json";
	private static final String GL_ACCOUNTS = "gl-accounts.json";

	@Override
	public GLAccounts getAccounts(String userAcctId, String greenlightAccountId, HttpHeaders responseHeaders) {
		String fileName;
		if(greenlightAccountId == null || greenlightAccountId.isEmpty()) {
			fileName = GL_ACCOUNTS;
		} else {
			fileName = GL_ACCOUNT;
		}
        return getAccounts(fileName);
	}
	
	protected GLAccounts getAccounts(String fileName) {
        String json = CommonUtils.getInputFromFileUsingStream(fileName);
        return CommonUtils.convertJSONToObject(json, GLAccounts.class);
	}
}
