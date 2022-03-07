package com.friendkeeper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendkeeper.entity.FKUser;
import com.friendkeeper.entity.Friend;

@Repository
public class FKUserDAOImpl implements FKUserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<FKUser> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query<FKUser> query = session.createQuery("from FKUser", FKUser.class);
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

	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		FKUser user = session.get(FKUser.class, id);
		for(Friend friend : user.getFriends()) {
			session.delete(friend);
		}
//		Query query = session.createQuery("delete from Friend where user_id=:userId");
//		query.setParameter("userId", id);
//		query.executeUpdate();
		session.delete(user);
	}

}
