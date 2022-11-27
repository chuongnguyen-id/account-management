package com.vti.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.form.AccountForm;
import com.vti.exception.CreateAccountException;
import com.vti.repository.AccountRepositoryV2;
import com.vti.repository.DepartmentRepositoryV2;
import com.vti.specification.AccountSpecification;

@Service
@Primary
@org.springframework.transaction.annotation.Transactional
public class AccountServiceV2 implements IAccountService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	AccountRepositoryV2 repository;
	
	@Autowired
	DepartmentRepositoryV2 departmentRepository;
	
//	@Override
//	public List<Account> getAllAccounts(AccountSearchFillter fillter) {
//		if(fillter.getUserName() != null) {
//			return repository.findAllByUserName(fillter.getUserName());
//		} else {
//			return repository.findAll();
//		}
//	}
	
//	@Override
//	public List<Account> getAllAccounts(AccountSearchFillter fillter) {
//		Specification<Account> where = AccountSpecification.buildWhere(fillter);
//		
//		if(fillter.getUserName() != null) {
//			return repository.findAllByUserName(fillter.getUserName());
//		} else {
//			return repository.findAll(where);
//		}
//	}
	
	@Override
	public Page<Account> getAllAccounts(Pageable pageable, AccountSearchFillter fillter) {
		Specification<Account> where = AccountSpecification.buildWhere(fillter);
		
//		if(fillter.getUserName() != null) {
//			return repository.findAllByUserName(fillter.getUserName());
//		} else {
		return repository.findAll(where, pageable);
//		}
	}

	@Override
	public Account getAccountByID(int id) {
		return repository.findById(id).get();
	}
	
	@Override
	public Account getAccountByUserName(String userName) {
		return repository.findByUserName(userName);
	}

	@Override
	public Account deleteAccountByID(int id) {
		repository.deleteById(id);
		return null;
	}

	@Override
	public void deleteAccounts(List<Integer> ids) {
		repository.deleteByIds(ids);
	}
	
	@Transactional
	@Override
	public void updateAccount(int id, AccountForm form) throws Exception {

		Department dp = departmentRepository.findByName(form.getDepartmentName());
		Account account = getAccountByID(id);
		account.setEmail(form.getEmail());
		account.setUserName(form.getUserName());
		account.setFullName(form.getFullName());
		account.setCreateDate(new Date());
		account.setDepartment(dp);
		
		repository.save(account);
	}

	@Transactional
	@Override
	public Account createAccount(AccountForm form) throws CreateAccountException {

		Department dp = departmentRepository.findByName(form.getDepartmentName());
		Account account = null;
		if (repository.existsByUserName(form.getUserName()) == false) {
			account = new Account();
			account.setEmail(form.getEmail());
			account.setUserName(form.getUserName());
			account.setFullName(form.getFullName());
			account.setCreateDate(new Date());
			account.setDepartment(dp);
			
			repository.save(account);
		} else {
			throw new CreateAccountException("Exist UserName!");
		}
		return account;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Account account = repository.findByUserName(userName);

		if (account == null) {
			throw new UsernameNotFoundException(userName);
		}
		
		return new User(
				account.getUserName(), 
				account.getPassword(), 
				AuthorityUtils.createAuthorityList(account.getRole().toString()));

	}

	
}
