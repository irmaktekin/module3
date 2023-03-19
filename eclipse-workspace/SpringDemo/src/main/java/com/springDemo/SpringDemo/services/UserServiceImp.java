package com.springDemo.SpringDemo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springDemo.SpringDemo.dao.UserDAO;
import com.springDemo.SpringDemo.models.User;


@Component
public class UserServiceImp implements UserService {
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}


	@Autowired
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	
	@Override
	public User getUserById(long userId) {
		// TODO Auto-generated method stub
		
		User user = userDao.getUserById(userId);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userDao.getUserByEmail(email);
		return user;
	}

	@Override
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		List <User> users = userDao.getUsersByName(name, pageSize, pageNum);
		return users;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		User newUser = userDao.createUser(user);
		return newUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		User updatedUser = userDao.updateUser(user);
		return updatedUser;
	}

	@Override
	public boolean deleteUser(long userId) {
		// TODO Auto-generated method stub
		if(userDao.deleteUser(userId)) {
			return true;

		}
		else {
			return false;
		}
	}

}
