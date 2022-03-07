package com.friendkeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friendkeeper.dao.UserLoginDAO;
import com.friendkeeper.entity.UserLogin;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginDAO dao;
	
	@Override
	@Transactional
	public UserLogin getLogin(int id) {
		return dao.getLogin(id);
	}

	@Override
	@Transactional
	public void saveLogin(UserLogin login) {
		dao.saveLogin(login);
	}

	@Override
	@Transactional
	public void deleteLogin(int id) {
		dao.deleteLogin(id);
	}

}
