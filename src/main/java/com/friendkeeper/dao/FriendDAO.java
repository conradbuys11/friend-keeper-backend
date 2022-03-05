package com.friendkeeper.dao;

import java.util.List;

import com.friendkeeper.entity.Friend;

public interface FriendDAO {
	public List<Friend> getFriends();
	public Friend getFriend(int id);
	public void saveFriend(Friend friend);
	public void deleteFriend(int id);
}
