package com.springDemo.SpringDemo.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.springDemo.SpringDemo.dao.UserDAO;
import com.springDemo.SpringDemo.dao.UserDaoImp;
import com.springDemo.SpringDemo.models.User;
import com.springDemo.SpringDemo.models.UserImp;


public class UserServiceImpTest {
	
	private UserServiceImp userService;
	private UserDAO mockUserDao;
	
	@Before
	public  void setup() {
		mockUserDao = Mockito.mock(UserDaoImp.class);
		userService = new UserServiceImp();
		userService.setUserDao(mockUserDao);
		
	}
	
	@Test
	public void whenUserId_ThenUserReturn() {
		User user = new UserImp("userTest","user@gmail.com");
		when(mockUserDao.getUserById(anyLong())).thenReturn(user);
		User user_returned = userService.getUserById(2);
		assertEquals(user,user_returned);
	}
	@Test
	public void whenCreateUser_ThenReturnCreatedUser() {
		User user = new UserImp("userCreated","userCreated@gmail.com");
		when(mockUserDao.createUser(any(User.class))).thenReturn(user);
		User user_created = userService.createUser(user);
		assertEquals(user,user_created);
		System.out.println(user.getName());
		
	
	}

}
