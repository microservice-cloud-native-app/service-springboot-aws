package com.poc.boldconnect.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    protected static final String GL_API_URL = "https://api.poc.greenlighttest.com";
    protected static final String ACCOUNTS_RESOURCE_PATH = "/accounts";
    protected static final String CORRELATION_ID_PARAM = "?correlation_id=";
    protected static final String API_KEY = "x-api-key";
    protected static final String API_VALUE = "CXOw9Qoxni2rC0FsRrYye8r2sN5SSJXn9Ya8jwxM";
    protected static final String CONTENT_TYPE = "Content-Type";
    protected static final String CONTENT_TYPE_VALUE = "application/json";
    protected Map<String,String> correlationIdMap;

    @Autowired
    private RestTemplate restTemplate;
    
    protected String getCorrelationUrl(String correlationId) {
    	return GL_API_URL + ACCOUNTS_RESOURCE_PATH + CORRELATION_ID_PARAM + correlationId;
    }

    protected String getGLAccountIdUrl(String greenlightAccountId) {
    	return GL_API_URL + ACCOUNTS_RESOURCE_PATH + "/" + greenlightAccountId;
    }
    
    /** Return the correlationId (pseudo user id that is shared with Greenlight that corresponds to this user
     * In the POC, Greenlight has only implemented 3 correlation ids, corresponding to the 3 use cases they want to test
     * so we are keeping those 3 ids in a map.
     * Future design is to keep the ids in a data store, and this method should pull the correlation id based on the user account id
     * @param userAcctId
     * @return
     */
    protected String getCorrelationId(String userAcctId) {
    	String answer = getCorrelationIdMap().get(userAcctId);
    	if(answer == null) {
    		LOG.debug("couldn't find user id: " + userAcctId);
    		answer = "abc789"; //For the POC default out the correlation id in case of client error
    	}
    	LOG.debug("correlationId: " + answer);
    	return answer;
    } 

	@Override
	public GLAccounts getAccounts(String userAcctId, String greenlightAccountId, HttpHeaders responseHeaders) {
		String url;
		if(greenlightAccountId == null || greenlightAccountId.isEmpty()) {
			url = getCorrelationUrl(getCorrelationId(userAcctId));
		} else {
			url = getGLAccountIdUrl(greenlightAccountId);
		}
		responseHeaders.set(API_KEY, API_VALUE);
		responseHeaders.set(CONTENT_TYPE, CONTENT_TYPE_VALUE);
        return callGlApi(url,responseHeaders);
	}
	
	/** The Greenlight Api returns an array of GLAccount, but we were expecting a GLAccounts object which wraps the array
	 * For now we'll just massage their return value to match our expectation (so the iOS team doesn't need to change their parsing)
	 * In the future, it may make sense to ask Greenlight to return the accounts within a wrapper
	 * 
	 * @param response
	 * @return
	 */
	protected GLAccounts massageApiResponse(ResponseEntity<GLAccount[]> response) {
        GLAccount[] accountArray= response.getBody();
        GLAccounts answer = new GLAccounts();
        if(accountArray != null && accountArray.length > 0) {
        	answer.setAccounts(Arrays.asList(accountArray));
        } else {
        	answer.setAccounts(new ArrayList<GLAccount>());
        }
        return answer;
	}
	
	protected GLAccounts callGlApi(String url, HttpHeaders responseHeaders) {
	    try {
		    HttpEntity<?> entity = new HttpEntity<>(null, responseHeaders);
	        ResponseEntity<GLAccount[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, GLAccount[].class);
	        return massageApiResponse(response);
	        
	    } catch (HttpClientErrorException | HttpServerErrorException e) {
	        LOG.error("GL Account Service failed with  :: statuscode -    " + e.getStatusCode() + " :: and responsebodyasstring" + e.getResponseBodyAsString());
	        return null;
	    }
	}

	public Map<String, String> getCorrelationIdMap() {
		if(correlationIdMap == null) {
			initializeCorrelationIdMap();
		}
		return correlationIdMap;
	}
	
	protected Map<String, String> initializeCorrelationIdMap() {
		correlationIdMap = new HashMap<String, String>();
		correlationIdMap.put("1", "abc123");
		correlationIdMap.put("2", "abc456");
		correlationIdMap.put("3", "abc789");
		return correlationIdMap;
	}

	public void setCorrelationIdMap(Map<String, String> correlationIdMap) {
		this.correlationIdMap = correlationIdMap;
	}
}
