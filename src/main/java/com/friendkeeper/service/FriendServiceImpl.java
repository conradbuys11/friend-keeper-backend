package com.friendkeeper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.friendkeeper.dao.FriendDAO;
import com.friendkeeper.entity.Friend;

public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDAO friendDAO;
	
	@Override
	@Transactional
	public List<Friend> getFriends() {
		return friendDAO.getFriends();
	}

	@Override
	@Transactional
	public Friend getFriend(int id) {
		return friendDAO.getFriend(id);
	}

	@Override
	@Transactional
	public void saveFriend(Friend friend) {
		friendDAO.saveFriend(friend);
	}

	@Override
	@Transactional
	public void deleteFriend(int id) {
		friendDAO.deleteFriend(id);
	}

}
