package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

	@Override
	public List<Department> getAllDepartments(String dpName) {
		Session session = null;

		try {
			// Để truy vấn csdl cần tạo ra 1 session
			session = HibernateUtils.getFactory().openSession();

			// Tạo ra câu lệnh Hibernate query
			String hqlQuery = "FROM Department";
			
			if (dpName != null) {
				hqlQuery = String.format("FROM Department D WHERE D.departmentName='%s'", dpName);
			}
			
			Query<Department> query = session.createQuery(hqlQuery);

			List<Department> listDepartments = query.list();

			return listDepartments;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public Department getDepartmentByID(int id) {
		Session session = null;

		try {

			session = HibernateUtils.getFactory().openSession();

			String hqlQuery = "FROM Department A WHERE A.id = " + id;

			Query<Department> query = session.createQuery(hqlQuery);

			Department department = query.getSingleResult();
			
			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Department deleteDepartmentByID(int id) {
		Session session = null;

		try {

			session = HibernateUtils.getFactory().openSession();

			String hqlQuery = "DELETE FROM Department A WHERE A.id = " + id;

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
	
//	public void updateDepartment(int id, String departmentNameNew) {
//		Session session = null;
//
//		try {
//
//			session = HibernateUtils.getFactory().openSession();
//
//			String hqlQuery = "UPDATE Department A SET A.departmentName = ?1 WHERE A.id = ?2";
//
//			Query<Department> query = session.createQuery(hqlQuery);
//
//			query.setParameter(1, departmentNameNew);
//			query.setParameter(2, id);
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
	
	public void updateDepartment(Department department) {
		Session session = null;

		try {

			// get session
			session = HibernateUtils.getFactory().openSession();
			session.beginTransaction();
			
			// update
			session.update(department);
			session.getTransaction().commit();

			if (department != null) {
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
	
	public void createDepartment(Department department) {
		Session session = null;

		try {
			// get session
			session = HibernateUtils.getFactory().openSession();

			// create
			session.save(department);

			System.out.println("Create Completed!");

		} finally {
			if (session != null) {
				session.close();
			}
		}

	}
	
	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = HibernateUtils.getFactory().openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE departmentName = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
