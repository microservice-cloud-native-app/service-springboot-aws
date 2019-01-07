package com.poc.boldconnect.delegate;

import com.poc.boldconnect.model.domain.demographics.CustomerInfo;
import com.poc.boldconnect.model.response.CustomerInfoResponse;
import com.poc.boldconnect.util.CommonUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerDemoInfoDelegate {

    public ResponseEntity<?> fetchDemographicDetails(String userAcctId, HttpHeaders responseHeaders) {

        String json = CommonUtils.getInputFromFileUsingStream("schema/customer-demographics.json");
        CustomerInfo customerInfo = CommonUtils.convertJSONToObject(json, CustomerInfo.class);
        CustomerInfoResponse glAccountResponse = new CustomerInfoResponse();
        glAccountResponse.setData(customerInfo);
        glAccountResponse.setCode(200);
        glAccountResponse.setMessage("Data Retrieved");
        return new ResponseEntity<>(glAccountResponse, responseHeaders, HttpStatus.OK);
    }
}


