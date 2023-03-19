package com.springDemo.SpringDemo.dao;

import java.util.List;
import java.util.function.Predicate;
import org.apache.log4j.Logger;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.storage.Storage;


public class UserDaoImp implements UserDAO{

	private Storage storage;
	public static final String USER = "user";
    private static final Logger logger = Logger.getLogger(UserDaoImp.class);


	@Override
	public User getUserById(long userId) {
		User user = storage.getById(USER+userId);
		
		return user;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	@Override
	public User getUserByEmail(String email) {
		Predicate <User> predicate = e->e.getEmail().equals(email);
		User user = (User)storage.getElementsByValue(predicate,USER);
		return user;
	
	}

	@Override
	public List<User> getUsersByName(String name, int pageSize, int pageNum) {
		// TODO Auto-generated method stub
		Predicate <User> predicate = e -> e.getName().contains(name);
		List <User> users = storage.getElementsByValue(predicate,USER);
		return users;
	}

	@Override
	public User createUser(User user) {
		
		User userCreated = storage.addPair(Constants.USER+user.getId(),user);
		return userCreated;
		
	}

	@Override
	public User updateUser(User user) {
		/*Predicate <User> predicate = e -> (USER+e.getId()).equals(USER+"-"+user.getId());
		List <User> users = storage.updateElement(predicate,USER);*/
		return null;
	}

	@Override
	public boolean deleteUser(long userId) {
		return storage.delete(USER+userId);
	}


}
 