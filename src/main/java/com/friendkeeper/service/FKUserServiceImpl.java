package com.friendkeeper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.friendkeeper.dao.FKUserDAO;
import com.friendkeeper.entity.FKUser;

@Service
public class FKUserServiceImpl implements FKUserService {

	@Autowired
	private FKUserDAO userDAO;

	@Override
	@Transactional
	public List<FKUser> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public FKUser getUser(int id) {
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void saveUser(FKUser user) {
		userDAO.saveUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}
