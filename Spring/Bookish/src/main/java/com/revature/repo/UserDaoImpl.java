package com.revature.repo;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean insertUser(User user) {
		
		return false;
	}

	@Override
	public User selectUser(String username) {
//		String hql = "from User where username = '" + username + "'";
		
		User user = sessionFactory.openSession().get(User.class, username);
		sessionFactory.close();
//		User user = sessionFactory.getCurrentSession().get(User.class, username);
		return user;
	}

	@Override
	public boolean updateUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
