package com.poc.boldconnect.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import com.poc.boldconnect.model.request.ServiceRequest;
import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.poc.boldconnect.Application;

public class CommonUtilsTest {
	// TODO fix this for marshalling your own SampleRequest.json's
    @Test
    public void givenAccountAsJSONThenConvertToAccountObject() throws URISyntaxException, JsonParseException,
            JsonMappingException, IOException {
        String json = CommonUtils.getInputFromFile(Application.class.getClassLoader().getResource("SampleRequest.json").toURI());
        ServiceRequest request = (ServiceRequest) CommonUtils.convertJSONToObject(json, ServiceRequest.class);
        Assert.assertEquals("161640", request.getAccount().getAccountNumber());
        Assert.assertEquals("Saving", request.getAccount().getDescription());
        Assert.assertEquals("EA", request.getAccount().getCode());
    }
}
