package com.vti.specification;

import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Account;
import com.vti.entity.fillter.AccountSearchFillter;

public class AccountSpecification {

	public static Specification<Account> buildWhere(AccountSearchFillter fillter) {
		
		// where userName = 'cong'
//		Specification<Account> whereSearch = new CustomAccountSpecification(KeySp.KEY_SEARCH, fillter.getSearch());
		
		// where userName LIKE = '%a%'
		Specification<Account> whereSearchLike = new CustomAccountSpecification(KeySp.KEY_SEARCH_LIKE, fillter.getSearch());
				
		// where email LIKE = '%gmail.com'
		Specification<Account> whereEmailLike =  new CustomAccountSpecification(KeySp.KEY_EMAIL_LIKE, fillter.getEmail());
		
		Specification<Account> whereFullNameLike =  new CustomAccountSpecification(KeySp.KEY_FULLNAME_LIKE, fillter.getFullName());
		Specification<Account> whereDepartmentNameLike =  new CustomAccountSpecification(KeySp.KEY_DEPARTMENTNAME_LIKE, fillter.getDepartmentName());
		Specification<Account> whereCreateDate =  new CustomAccountSpecification(KeySp.KEY_CREATEDATE, fillter.getCreateDate());
		// where userName = 'cong' AND email LIKE = '%gmail.com'
		return Specification.where(whereSearchLike).or(whereEmailLike).or(whereFullNameLike).or(whereCreateDate).or(whereDepartmentNameLike);
	}
	
	public interface KeySp {
//		public static final String KEY_SEARCH = "KEY_SEARCH";
		public static final String KEY_SEARCH_LIKE = "KEY_SEARCH_LIKE";
		public static final String KEY_EMAIL_LIKE = "KEY_EMAIL_LIKE";
		public static final String KEY_EMAIL = "KEY_EMAIL";
		public static final String KEY_FULLNAME_LIKE = "KEY_FULLNAME_LIKE";
		public static final String KEY_DEPARTMENTNAME_LIKE = "KEY_DEPARTMENTNAME_LIKE";
		public static final String KEY_CREATEDATE = "KEY_CREATEDATE";
	}
}
