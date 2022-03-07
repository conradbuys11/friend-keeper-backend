package com.friendkeeper.service;

import com.friendkeeper.entity.UserLogin;

public interface UserLoginService {
	public UserLogin getLogin(int id);
	public void saveLogin(UserLogin login);
	public void deleteLogin(int id);
}
