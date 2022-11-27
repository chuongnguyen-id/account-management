package com.vti.repository;

import java.util.List;

import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.Account;

public interface IAccountRepository {

//	public List<Account> getAllAccounts(String userName);
	
	public List<Account> getAllAccounts(AccountSearchFillter fillter);
	
	public Account getAccountByID(int id);

	public Account deleteAccountByID(int id);

//	public void updateAccount(int id, AccountForm form);

	public void updateAccount(Account acc);

	public void createAccount(Account acc);

	public Account getAccountByName(String name);

	public boolean existsByUserName(String value);

	public void deleteAccounts(List<Integer> ids);
}
