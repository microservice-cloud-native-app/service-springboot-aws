package com.poc.boldconnect.delegate;

import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.domain.GLAccounts;
import com.poc.boldconnect.model.response.GLAccountResponse;
import com.poc.boldconnect.util.CommonUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LedgerGLAccountDelegate {
    public ResponseEntity<?> fetchAccounts(String userAcctId, HttpHeaders responseHeaders) {

        String json = CommonUtils.getInputFromFileUsingStream("gl-accounts.json");
        GLAccounts glAccounts = CommonUtils.convertJSONToObject(json, GLAccounts.class);
        GLAccountResponse glAccountResponse = new GLAccountResponse();
        glAccountResponse.setData(glAccounts);
        glAccountResponse.setCode(200);
        glAccountResponse.setMessage("Data Retrieved");
        return new ResponseEntity<>(glAccountResponse, responseHeaders, HttpStatus.OK);
    }
}
