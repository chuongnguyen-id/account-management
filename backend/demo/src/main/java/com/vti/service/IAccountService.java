package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.form.AccountForm;
import com.vti.entity.Account;

public interface IAccountService extends UserDetailsService {

//	public List<Account> getAllAccounts(String userName);
	
//	public List<Account> getAllAccounts(AccountSearchFillter fillter);
	
	public Account getAccountByID(int id);

	public Account deleteAccountByID(int id);

	public void updateAccount(int id, AccountForm form) throws Exception;

	public Account createAccount(AccountForm form) throws Exception;

	public Account getAccountByUserName(String userName);

	public Page<Account> getAllAccounts(Pageable pageable, AccountSearchFillter fillter);

	public void deleteAccounts(List<Integer> ids);



}
