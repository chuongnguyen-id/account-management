package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.GroupAccount;
import com.vti.utils.HibernateUtils;

public class GroupAccountRepository {
	@SuppressWarnings("unchecked")
	public List<GroupAccount> getAllGroupAccount() {
		Session session = null;
		
		try {
			session = HibernateUtils.getFactory().openSession();
			
			String hqlQuery = "FROM GroupAccount";
			
			Query<GroupAccount> query = session.createQuery(hqlQuery);
			
			List<GroupAccount> listGroupAccount = query.list();
			
			return listGroupAccount;
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createGroupAccount(GroupAccount joinDateNew) {
		Session session = null;
		
		try {
			session = HibernateUtils.getFactory().openSession();
			
			session.save(joinDateNew);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
