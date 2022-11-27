package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.fillter.AccountSearchFillter;
import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

@Deprecated
@Repository
public class AccountRepository implements IAccountRepository{

	public List<Account> getAllAccounts(AccountSearchFillter fillter) {
		Session session = null;

		try {

			session = HibernateUtils.getFactory().openSession();

			String hqlQuery = "FROM Account";
			
			if(fillter.getUserName() != null) {
				hqlQuery =  String.format("FROM Account A WHERE A.userName='%s'", fillter.getUserName());
			}
			
			Query<Account> query = session.createQuery(hqlQuery);

			List<Account> listAccounts = query.list();
			return listAccounts;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByID(int id) {
		Session session = null;

		try {

			session = HibernateUtils.getFactory().openSession();

			String hqlQuery = "FROM Account A WHERE A.id = " + id;

			Query<Account> query = session.createQuery(hqlQuery);

			Account account = query.getSingleResult();
			
			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

//	public void updateAccountByID(int id, String userNameNew, String fullNameNew, String emailNew) {
//		Session session = null;
//
//		try {
//
//			session = HibernateUtils.getFactory().openSession();
//
//			String hqlQuery = "UPDATE Account A SET A.userName = ?1 , A.fullName = ?2, A.email = ?3 WHERE A.id = ?4";
//
//			Query<Account> query = session.createQuery(hqlQuery);
//
//			query.setParameter(1, userNameNew);
//			query.setParameter(2, fullNameNew);
//			query.setParameter(3, emailNew);
//			query.setParameter(4, id);
//
//			session.beginTransaction();
//			int count = query.executeUpdate();
//			session.getTransaction().commit();
//
//			if (count > 0) {
//				System.out.println("Update Completed!");
//			} else {
//				System.out.println("Update Failed!");
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	public Account deleteAccountByID(int id) {
		Session session = null;

		try {

			session = HibernateUtils.getFactory().openSession();

			String hqlQuery = "DELETE FROM Account A WHERE A.id = " + id;

			Query<Account> query = session.createQuery(hqlQuery);

			session.beginTransaction();
			int count = query.executeUpdate();
			session.getTransaction().commit();

			if (count > 0) {
				System.out.println("Delete Completed!");
			} else {
				System.out.println("Delete Failed!");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

//	public Account createAccount(String userNameNew, String fullNameNew, String emailNew) {
//
//		Session session = HibernateUtils.getFactory().openSession();
//
//		Account account = new Account();
//
//		account.setUserName(userNameNew);
//		account.setFullName(fullNameNew);
//		account.setEmail(emailNew);
//		account.setCreateDate(new Date());
//
//		session.save(account);
//		session.close();
//
//		System.out.println("Create Completed!");
//		return account;
//	}
	
	public void updateAccount(Account account) {
		Session session = null;

		try {

			// get session
			session = HibernateUtils.getFactory().openSession();
			session.beginTransaction();
			
			// update
			session.update(account);
			session.getTransaction().commit();

			if (account != null) {
				System.out.println("Update Completed!");
			} else {
				System.out.println("Update Failed!");
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createAccount(Account account) {
		Session session = null;

		try {
			// get session
			session = HibernateUtils.getFactory().openSession();

			// create
			session.save(account);

			System.out.println("Create Completed!");

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	public Account getAccountByName(String userName) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getFactory().openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account WHERE userName = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", userName);

			// get result
			Account account = query.uniqueResult();

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public boolean existsByUserName(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteAccounts(List<Integer> ids) {
		// TODO Auto-generated method stub
		
	}
}
