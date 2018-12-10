package com.poc.boldconnect.model.domain;


//TODO write your own POJO domain objects in this package.
public class Account {
    String accountNumber = "";
    String description = "";
    String code = "";

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
