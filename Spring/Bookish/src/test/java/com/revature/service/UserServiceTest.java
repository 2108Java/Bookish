package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.id.IdentifierGenerationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.postgresql.util.PSQLException;

import com.revature.models.Book;
import com.revature.models.Message;
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
	void registerUser() throws Exception{
		//the userDao.save() method is doesn't throw an exception or return null
		//it silently doesn't persist users that violate the not null and unique constraints
		//I can't figure out why it's doing this
		
		List<Book> fakeList = new ArrayList<>();
		Message success = new Message("Registration was successful.");
		Message failure = new Message("Registration was unsuccessful.");
		
		User testUser = new User("new", "email", "password", fakeList);
		User duplicateUser = testUser;
		User nullUsername = new User(null, "email", "password", fakeList);
		User nullEmail = new User("new", null, "password", fakeList);
		User nullPassword = new User("new", "email", null, fakeList);
		
		when(userDao.save(testUser)).thenReturn(testUser);
		when(userDao.save(nullUsername)).thenThrow(IdentifierGenerationException.class);
		when(userDao.save(nullEmail)).thenThrow(PSQLException.class);
		when(userDao.save(nullPassword)).thenThrow(PSQLException.class);
		
		assertEquals(userService.registerUser(testUser), success);
		assertEquals(userService.registerUser(nullUsername), failure);
		assertEquals(userService.registerUser(nullEmail), failure);		
		assertEquals(userService.registerUser(nullPassword), failure);
	}
			
	@Test
	void authenticate() {
		List<Book> fakeList = new ArrayList<>();
		User testUser = new User("username", "email", "password", fakeList);
		
		when(userDao.findByUsername("username")).thenReturn(testUser);
		when(userDao.findByUsername("fake")).thenReturn(null);
		when(userDao.findByUsername(null)).thenReturn(null);
		
		assertEquals(userService.authenticate("username", "password"), testUser);
		assertEquals(userService.authenticate("username", "fake"), null);
		assertEquals(userService.authenticate("fake", "password"), null);
		assertEquals(userService.authenticate("fake", "fake"), null);
		assertEquals(userService.authenticate("username", null), null);
		assertEquals(userService.authenticate(null, "password"), null);
		assertEquals(userService.authenticate(null, null), null);
		
	}
		
	@Test
	void updatePassword() {
		Message success = new Message("Update Password was successful.");
		Message failure = new Message("Update Password was unsuccessful.");
		
		when(userDao.updatePassword("username", "password")).thenReturn(1);
		when(userDao.updatePassword("username", "fake")).thenReturn(0);
		when(userDao.updatePassword("fake", "password")).thenReturn(0);
		when(userDao.updatePassword("fake", "fake")).thenReturn(0);
		when(userDao.updatePassword(null, "password")).thenReturn(0);
		when(userDao.updatePassword("username", null)).thenReturn(0);
		when(userDao.updatePassword(null, null)).thenReturn(0);
		
		assertEquals(userService.updatePassword("username", "password"), success);
		assertEquals(userService.updatePassword("username", "fake"), failure);
		assertEquals(userService.updatePassword("fake", "password"), failure);
		assertEquals(userService.updatePassword("fake", "fake"), failure);
		assertEquals(userService.updatePassword(null, "password"), failure);
		assertEquals(userService.updatePassword("username", null), failure);
		assertEquals(userService.updatePassword(null, null), failure);

	}
		
}
