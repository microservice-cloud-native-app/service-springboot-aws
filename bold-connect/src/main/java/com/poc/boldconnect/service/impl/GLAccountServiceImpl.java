package com.poc.boldconnect.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.poc.boldconnect.model.domain.GLAccount;
import com.poc.boldconnect.model.domain.GLAccounts;
import com.poc.boldconnect.service.GLAccountService;

@Component
public class GLAccountServiceImpl implements GLAccountService {

    private static Logger LOG = LoggerFactory.getLogger(GLAccountServiceImpl.class);
    protected static final String GLAccountServiceUrl = "https://api.poc.greenlighttest.com";
    protected static final String resource = "/accounts";
    protected static final String CORRELATION_ID_PARAM = "?correlation_id=";
    protected static final String POC_CORRELATION_ID = "abc123";
    protected static final String API_KEY = "x-api-key";
    protected static final String API_KEY_VALUE = "CXOw9Qoxni2rC0FsRrYye8r2sN5SSJXn9Ya8jwxM";
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String CONTENT_TYPE_VALUE = "application/json";

    @Autowired
    private RestTemplate restTemplate;
    
    protected String getCorrelationUrl(String correlationId) {
    	return GLAccountServiceUrl + resource + CORRELATION_ID_PARAM + correlationId;
    }

    protected String getGLAccountIdUrl(String greenlightAccountId) {
    	return GLAccountServiceUrl + resource + "/" + greenlightAccountId;
    }
    
    /** Return the correlationId (pseudo user id that is shared with Greenlight that corresponds to this user
     * In the POC, Greenlight has not yet implemented correlation id, so we just mock one
     * @param userAcctId
     * @return
     */
    protected String getCorrelationId(String userAcctId) {
    	return POC_CORRELATION_ID; 
    }

	@Override
	public GLAccounts getAccounts(String userAcctId, String greenlightAccountId, HttpHeaders responseHeaders) {
		String url;
		if(greenlightAccountId == null || greenlightAccountId.isEmpty()) {
			url = getCorrelationUrl(getCorrelationId(userAcctId));
		} else {
			url = getGLAccountIdUrl(greenlightAccountId);
		}
		responseHeaders.set(API_KEY, API_KEY_VALUE);
		responseHeaders.set(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        return callGlApi(url,responseHeaders);
	}
	
	protected GLAccounts callGlApi(String url, HttpHeaders responseHeaders) {
	    try {
		    HttpEntity<?> entity = new HttpEntity<>(null, responseHeaders);
	        ResponseEntity<GLAccount[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, GLAccount[].class);
	        GLAccount[] accountArray= response.getBody();
	        GLAccounts answer = new GLAccounts();
	        answer.setAccounts(Arrays.asList(accountArray));
	        return answer;
	        
	    } catch (HttpClientErrorException | HttpServerErrorException e) {
	        LOG.error("GL Account Service failed with  :: statuscode -    " + e.getStatusCode() + " :: and responsebodyasstring" + e.getResponseBodyAsString());
	        return null;
	    }
	}
}
