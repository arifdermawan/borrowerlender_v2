package com.lenderborrower.useraccountservices.services;

import java.util.List;

import com.lenderborrower.useraccountservices.model.Account;
import com.lenderborrower.useraccountservices.request.AccountRequest;

public interface IAccountServices {
	List<Account> getAllAccount();
	List<Account> getAccountByMemberId(Integer id);
	Account getAccountById(Integer id);
	String addAccount(AccountRequest request);
	String updateAccount(Integer id, Integer isActive);
}
