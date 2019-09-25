package com.lenderborrower.useraccountservices.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.lenderborrower.useraccountservices.model.Account;


@JsonInclude(JsonInclude.Include.NON_NULL) 
public class AccountResponse extends BaseResponse{
	 private Account account;
	 private List<Account> accounts;
	 
	public AccountResponse(Integer httpCode, String message, Account account, List<Account> accounts) {
		super(httpCode, message);
		this.account = account;
		this.accounts = accounts;
	}
	public Account getAccount() {
		return account;
	}
	public List<Account> getAccounts() {
		return accounts;
	}	
}
