package com.friendkeeper.dao;

import java.util.List;

import com.friendkeeper.entity.FKUser;

public interface FKUserDAO {
	public List<FKUser> getUsers();
	public FKUser getUser(int id);
	public void saveUser(FKUser user);
	public void deleteUser(int id);
}
