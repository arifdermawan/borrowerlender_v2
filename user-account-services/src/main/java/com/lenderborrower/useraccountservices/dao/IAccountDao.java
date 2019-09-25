package com.lenderborrower.useraccountservices.dao;

import java.util.List;

import com.lenderborrower.useraccountservices.model.Account;

public interface IAccountDao {
	List<Account> getAllAccount();
	List<Account> getListAccountByMemberId(Integer Id);
	Account getAccount(Integer accountId);
	void createAccount(Account acccount);
	void updateAccount(Integer id, Integer isActive);
	Integer getCountAccountById(Integer id);
}
