package com.poc.boldconnect.model.domain.demographics;

import com.poc.boldconnect.util.CommonUtils;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Matches;

public class CustomerDemographicsTest {

    @Test
    public void test_customerDemographicDataModel() {

        String json = CommonUtils.getInputFromFileUsingStream("schema/customer-demographics.json");
        CustomerInfo customer = CommonUtils.convertJSONToObject(json, CustomerInfo.class);
        Assert.assertThat(customer, Matchers.notNullValue());
        Assert.assertThat(customer.getCustomer().getBankCustomer(),Matchers.notNullValue());
        Assert.assertThat(customer.getCustomer().getCreditCardCustomer(), Matchers.notNullValue());
        Assert.assertThat(customer.getCustomer().getBankCustomer().getFirstName(), CoreMatchers.notNullValue());
    }
}
