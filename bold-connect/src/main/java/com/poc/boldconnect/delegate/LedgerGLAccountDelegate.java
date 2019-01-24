package com.poc.boldconnect.delegate;

import com.poc.boldconnect.model.domain.GLAccounts;
import com.poc.boldconnect.model.response.GLAccountResponse;
import com.poc.boldconnect.service.impl.GLAccountServiceImpl;
import com.poc.boldconnect.service.impl.MockGLAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class LedgerGLAccountDelegate {
    private MockGLAccountService mockService;
    private GLAccountServiceImpl glAccountService;

    @Autowired
    public LedgerGLAccountDelegate(MockGLAccountService theMockService, GLAccountServiceImpl theRealService) {
        this.setMockService(theMockService);
        this.setGlAccountService(theRealService);
    }
	
	
    public ResponseEntity<?> fetchAccounts(String userAcctId, boolean mock, HttpHeaders responseHeaders) {
    	GLAccounts accounts = getAccounts(userAcctId, mock, responseHeaders);
    	return getResponse(accounts, responseHeaders);
    }
    
    protected GLAccounts getAccounts(String userAcctId, boolean mock, HttpHeaders responseHeaders) {
    	if(mock) {
    		return getMockService().getAccounts(userAcctId, responseHeaders);
    	} else {
    		return getGlAccountService().getAccounts(userAcctId, responseHeaders);
    	}
    }
    
    protected ResponseEntity<?> getResponse(GLAccounts accounts, HttpHeaders responseHeaders) {
        GLAccountResponse glAccountResponse = new GLAccountResponse();
        glAccountResponse.setData(accounts);
        glAccountResponse.setCode(200);
        glAccountResponse.setMessage("Data Retrieved");
        return new ResponseEntity<>(glAccountResponse, responseHeaders, HttpStatus.OK);
    }


	public MockGLAccountService getMockService() {
		return mockService;
	}


	public void setMockService(MockGLAccountService mockService) {
		this.mockService = mockService;
	}


	public GLAccountServiceImpl getGlAccountService() {
		return glAccountService;
	}


	public void setGlAccountService(GLAccountServiceImpl glAccountService) {
		this.glAccountService = glAccountService;
	}

}
