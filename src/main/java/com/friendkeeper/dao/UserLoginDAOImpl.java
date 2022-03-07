package com.friendkeeper.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendkeeper.entity.UserLogin;

@Repository
public class UserLoginDAOImpl implements UserLoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public UserLogin getLogin(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserLogin.class, id);
	}

	@Override
	public void saveLogin(UserLogin login) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(login);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteLogin(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from UserLogin where id=:loginId");
		query.setParameter("loginId", id);
		query.executeUpdate();
	}

}
