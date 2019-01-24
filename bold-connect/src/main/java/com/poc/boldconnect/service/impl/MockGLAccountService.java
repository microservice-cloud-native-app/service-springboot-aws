package com.poc.boldconnect.service.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.domain.GLAccounts;
import com.poc.boldconnect.service.GLAccountService;
import com.poc.boldconnect.util.CommonUtils;

@Component
public class MockGLAccountService implements GLAccountService {

	@Override
	public GLAccounts getAccounts(String userAcctId, HttpHeaders responseHeaders) {
        String json = CommonUtils.getInputFromFileUsingStream("gl-accounts.json");
        return CommonUtils.convertJSONToObject(json, GLAccounts.class);
	}

}
