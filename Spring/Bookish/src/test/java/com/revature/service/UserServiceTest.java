package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.revature.models.Book;
import com.revature.models.User;
import com.revature.repo.BookDao;
import com.revature.repo.UserDao;

public class UserServiceTest {
	
	@Mock
	private UserDao userDao;
	@Mock
	private BookDao bookDao;
	
	private UserService userService;
	
	@Before
	void setup() {
		userDao = mock(UserDao.class);
		bookDao = mock(BookDao.class);
		
		userService = new UserServiceImpl(userDao, bookDao);
	}
	
	@Test
	void registerUser() {}
			
	@Test
	void authenticate() {
		
	}
		
	@Test
	void updatePassword() {
		when(userDao.updateUser("username", "password")).thenReturn(true);
		when(userDao.updateUser("username", "fake")).thenReturn(false);
		when(userDao.updateUser("fake", "password")).thenReturn(false);
		when(userDao.updateUser("fake", "fake")).thenReturn(false);
		when(userDao.updateUser(null, "password")).thenReturn(false);
		when(userDao.updateUser("username", null)).thenReturn(false);
		when(userDao.updateUser(null, null)).thenReturn(false);
		
		assertTrue(userService.updatePassword("username", "password"));
		assertFalse(userService.updatePassword("username", "fake"));
		assertFalse(userService.updatePassword("fake", "password"));
		assertFalse(userService.updatePassword("fake", "fake"));
		assertFalse(userService.updatePassword(null, "password"));
		assertFalse(userService.updatePassword("username", null));
		assertFalse(userService.updatePassword(null, null));
	}
		
	@Test
	void readList() {}
	
	@Test
	void toReadList() {}
}
