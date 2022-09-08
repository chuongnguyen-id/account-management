package com.vti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.form.AccountForm;
import com.vti.entity.Account;
import com.vti.repository.IAccountRepository;

@Deprecated
@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;

//	@Override
//	public List<Account> getAllAccounts(String userName) {
//		return repository.getAllAccounts(userName);
//	}

//	@Override
//	public List<Account> getAllAccounts(AccountSearchFillter fillter){
//		return repository.getAllAccounts(fillter);
//	}

	@Override
	public Account getAccountByID(int id) {
		return repository.getAccountByID(id);
	}

	@Override
	public Account deleteAccountByID(int id) {
		return repository.deleteAccountByID(id);
	}

	@Override
	public void updateAccount(int id, AccountForm form) throws Exception {
		// Step 1: Search Account by ID
		Account acc = repository.getAccountByID(id);
		if (acc == null) {
			throw new Exception("Not Found Account!");
		}

		// Step 2: update new data into new Account
		acc.setEmail(form.getEmail());
		acc.setUserName(form.getUserName());
		acc.setFullName(form.getFullName());
		acc.setCreateDate(form.getCreateDate());
		repository.updateAccount(acc);

		return;
	}

	@Override
	public Account createAccount(AccountForm form) throws Exception {
		// Step 1: Search Department by Name
		Account acc = repository.getAccountByName(form.getUserName());
		if (acc != null) {
			throw new Exception("Exist UserName!");
		}

		// Step 2: create new data into new Department
		Account account = new Account();
		account.setEmail(form.getEmail());
		account.setUserName(form.getUserName());
		account.setFullName(form.getFullName());
		account.setCreateDate(new Date());

		repository.createAccount(account);
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> getAllAccounts(Pageable pageable, AccountSearchFillter fillter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccounts(List<Integer> ids) {
		// TODO Auto-generated method stub
		
	}


}
