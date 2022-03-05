package com.friendkeeper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendkeeper.entity.FKUser;

@Repository
public class FKUserDAOImpl implements FKUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<FKUser> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<FKUser> query = session.createQuery("from User", FKUser.class);
		List<FKUser> users = query.getResultList();
		return users;
	}

	@Override
	public FKUser getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(FKUser.class, id);
	}

	@Override
	public void saveUser(FKUser user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);
		query.executeUpdate();
	}

}
