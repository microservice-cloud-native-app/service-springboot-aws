package com.poc.boldconnect.model.request;

import com.poc.boldconnect.model.domain.Account;

//TODO modify ServiceRequest to contain your domain objects
public class ServiceRequest {
	private Account account = null;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
