package com.poc.boldconnect.model.domain.demographics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerInfo {

    private Customer customer;
}
