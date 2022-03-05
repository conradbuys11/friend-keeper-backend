package com.friendkeeper.service;

import java.util.List;

import com.friendkeeper.entity.Friend;

public interface FriendService {
	public List<Friend> getFriends();
	public Friend getFriend(int id);
	public void saveFriend(Friend friend);
	public void deleteFriend(int id);
}
