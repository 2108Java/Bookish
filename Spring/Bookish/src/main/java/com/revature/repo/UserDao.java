package com.revature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Book;
import com.revature.models.User;

@Transactional
@Repository("userDao")
public interface UserDao extends JpaRepository<User, String>{

	//insert user
	
	//get a user
	User findByUsername(String username);
	
	//update password
	@Modifying
	@Query("update User user set user.password = ?2 where user.username = ?1")
	int updatePassword(String username, String password);
	
	
}
