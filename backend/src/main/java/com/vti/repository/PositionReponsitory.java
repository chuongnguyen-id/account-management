package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;

public class PositionReponsitory {
	@SuppressWarnings("unchecked")
	public List<Position> getAllPositions() {
		Session session = null;
		
		try {
			session = HibernateUtils.getFactory().openSession();
			
			String hqlQuery = "FROM Position";
			
			Query<Position> query = session.createQuery(hqlQuery);
			
			List<Position> listPositions = query.list();
			
			return listPositions;
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void createPosition(Position positionNameNew) {
		Session session = null;
		
		try {
			session = HibernateUtils.getFactory().openSession();
			
			session.save(positionNameNew);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
