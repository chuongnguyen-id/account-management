package com.vti.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.vti.repository.IAccountRepository;

public class AccountUserNameNotExistsValidator implements ConstraintValidator<AccountUserNameNotExists, String>{

	@Autowired
	private IAccountRepository repository;

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return repository.existsByUserName(userName);
	}
	
}
