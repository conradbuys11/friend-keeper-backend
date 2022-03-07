package com.friendkeeper.dao;

import com.friendkeeper.entity.UserLogin;

public interface UserLoginDAO {
	public UserLogin getLogin(int id);
	public void saveLogin(UserLogin login);
	public void deleteLogin(int id);
}
