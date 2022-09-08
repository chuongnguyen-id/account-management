package com.vti.specification;

import java.sql.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;
import com.vti.specification.AccountSpecification.KeySp;

public class CustomAccountSpecification implements Specification<Account>{

	String key;
	Object value;
	
	
	public CustomAccountSpecification(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}


	@Override
	public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		
		if (value == null) {
			return null;
		}
		
		switch (key) {
		case KeySp.KEY_SEARCH_LIKE:
			// where userName = 'value'
			return criteriaBuilder.like(root.get("userName"), "%"+value+"%");
		case KeySp.KEY_EMAIL_LIKE:
			// where email LIKE = '%value%'
			return criteriaBuilder.like(root.get("email"), "%"+value+"%");
		case KeySp.KEY_EMAIL:
			// where email = 'value'
			return criteriaBuilder.equal(root.get("email"), value);
		case KeySp.KEY_FULLNAME_LIKE:
			// where fullName = 'value'
			return criteriaBuilder.like(root.get("fullName"), "%"+value+"%");
		case KeySp.KEY_DEPARTMENTNAME_LIKE:
			return criteriaBuilder.like(root.get("department").get("name"), "%"+value+"%");
		case KeySp.KEY_CREATEDATE:
			return criteriaBuilder.equal(root.get("createDate").as(Date.class), value);
		}
		
		return null;
	}

}
