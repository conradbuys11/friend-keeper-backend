package com.friendkeeper.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendkeeper.entity.Friend;

@Repository
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Friend> getFriends() {
		Session session = sessionFactory.getCurrentSession();
		Query<Friend> query = session.createQuery("from Friend", Friend.class);
		List<Friend> friends = query.getResultList();
		return friends;
	}

	@Override
	public Friend getFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Friend.class, id);
	}

	@Override
	public void saveFriend(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(friend);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteFriend(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Friend where id=:friendId");
		query.setParameter("friendId", id);
		query.executeUpdate();
	}

}
