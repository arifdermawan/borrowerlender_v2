package com.lenderborrower.useraccountservices.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.lenderborrower.useraccountservices.model.Account;
import com.lenderborrower.useraccountservices.request.AccountRequest;
import com.lenderborrower.useraccountservices.response.AccountResponse;
import com.lenderborrower.useraccountservices.response.MemberResponse;
import com.lenderborrower.useraccountservices.services.IAccountServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("api/v1")
@Api(value = "Account Services",description  = "Account Service")
public class AccountController {
	
	@Autowired
	private IAccountServices accountServices;
	
	private AccountResponse response = null;
	
	
	@ApiOperation(value = "Get List Account By ID Member", response = AccountResponse.class)
	@GetMapping("account/member/{id}")
	public ResponseEntity<AccountResponse> getAccountByMemberid(
			@ApiParam(value = "Id Member", required = true) @PathVariable("id") Integer id){
		List<Account> listAccount = accountServices.getAccountByMemberId(id);
		response = new AccountResponse(HttpStatus.OK.value(),"List Account", null,listAccount);
		return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get All List Accounts", response = AccountResponse.class)
	@GetMapping("accounts")
	public ResponseEntity<AccountResponse> getAllAccounts(){
		List<Account> listAccount = accountServices.getAllAccount();
		response = new AccountResponse(HttpStatus.OK.value(),"List Account", null,listAccount);
		return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get Account By Id Akun", response = AccountResponse.class)
	@GetMapping("account/{id}")
	public ResponseEntity<AccountResponse> getAccountByKodeAkun(
			@ApiParam(value = "Id Akun", required = true) @PathVariable("id") Integer id){
		Account account = accountServices.getAccountById(id);
		response = new AccountResponse(HttpStatus.OK.value(),"Account", account,null);
		return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Get Account By Id Akun status is active", response = AccountResponse.class)
	@GetMapping("account/{id}/member/{idMember}/isactive")
	public ResponseEntity<Integer> checkAccountActive(
			@ApiParam(value = "Id Akun", required = true) @PathVariable("id") Integer id,
			@ApiParam(value = "Id Member", required = true) @PathVariable("idMember") Integer idMember){
		Integer account = accountServices.checkAccountStatus(id,idMember);
		return new ResponseEntity<Integer>(account, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Add Account", response = AccountResponse.class)
	@PostMapping("account")
	public ResponseEntity<AccountResponse> addAccount(
			@ApiParam(value = "Account Object", required = true) @RequestBody AccountRequest account){
		String kodeAkun = accountServices.addAccount(account);
		response = new AccountResponse(HttpStatus.CREATED.value(), "Sukses Add Kode Akun = " + kodeAkun, null, null);
		return new ResponseEntity<AccountResponse>(response, HttpStatus.CREATED);	
	}
	
	@ApiOperation(value = "Update Account", response = AccountResponse.class)
	@PatchMapping("account/{id}")
	public ResponseEntity<AccountResponse> updateAccount(
			@ApiParam(value = "Account Object", required = true) @PathVariable Integer id, 
			@RequestParam(name = "isActive") Integer isActive){
			String kode = accountServices.updateAccount(id, isActive);
			response = new AccountResponse(HttpStatus.OK.value(), "Sukser Update Account = " + kode, null, null);
			return new ResponseEntity<AccountResponse>(response, HttpStatus.OK);
	}
}
