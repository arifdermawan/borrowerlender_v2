package com.lenderborrower.useraccountservices.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lenderborrower.useraccountservices.dao.IAccountDao;
import com.lenderborrower.useraccountservices.dao.IMemberDao;
import com.lenderborrower.useraccountservices.error.NotFoundException;
import com.lenderborrower.useraccountservices.model.Account;
import com.lenderborrower.useraccountservices.request.AccountRequest;
import com.lenderborrower.useraccountservices.utils.Utility;


@Service
public class AccountServices implements IAccountServices {
	
	@Autowired
	private IMemberDao memberDao;
	
	@Autowired
	private IAccountDao serviceDao;

	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return serviceDao.getAllAccount();
	}

	@Override
	public List<Account> getAccountByMemberId(Integer Id) {
		// TODO Auto-generated method stub
		List<Account> listAccount = serviceDao.getListAccountByMemberId(Id);
		return listAccount;
	}

	@Override
	public Account getAccountById(Integer id) {
		// TODO Auto-generated method stub
		Account account = serviceDao.getAccount(id);
		if (account == null) {
			throw new NotFoundException("Account id : " + id.toString());
		}
		return account;
	}
	
	@Override
	public Integer checkAccountStatus(Integer id,Integer idMember) {
		// TODO Auto-generated method stub
		Integer account = serviceDao.getAccountIsActive(id,idMember);
		return account;
	}

	@Override
	public String addAccount(AccountRequest request) {
		// TODO Auto-generated method stub
		String kodeAkun = Utility.randomAlphaNumeric(7);
		Integer member = memberDao.getCountMemberById(request.getIdMember());
		if (member == 0) {
			throw new NotFoundException("Member id : " + request.getIdMember());
		}
		Account account = new Account(0, null, null, kodeAkun, 1, request.getIdMember());
		serviceDao.createAccount(account);
		return account.getKodeAkun();
	}

	@Override
	public String updateAccount(Integer id, Integer isActive) {
		// TODO Auto-generated method stub
		Integer member = serviceDao.getCountAccountById(id);
		if (member == 0) {
			throw new NotFoundException("Account id : " + id);
		}
		serviceDao.updateAccount(id, isActive);
		return id.toString();
	}

}
