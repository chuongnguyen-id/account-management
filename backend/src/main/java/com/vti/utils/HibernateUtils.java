package com.vti.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;


public class HibernateUtils {
	private final static SessionFactory FACTORY;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		cfg.addAnnotatedClass(Account.class);
		cfg.addAnnotatedClass(Department.class);
		cfg.addAnnotatedClass(Position.class);
		cfg.addAnnotatedClass(GroupAccount.class);
//		cfg.addAnnotatedClass(Group.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();

		FACTORY = cfg.buildSessionFactory(registry);
	}
	

	public static SessionFactory getFactory() {
		return FACTORY;
	}
}
