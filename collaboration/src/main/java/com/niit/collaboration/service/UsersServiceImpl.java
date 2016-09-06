package com.niit.collaboration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaboration.dao.UsersDao;
import com.niit.collaboration.model.Users;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersDao usersDao;

	public List<Users> userslist() {
		
		return usersDao.userslist();
	}

	public Users getUserById(int id) {
		
		return usersDao.getUserById(id);
	}

	public void saveOrUpdate(Users users) {
		usersDao.saveOrUpdate(users);
		
	}

	public void delete(int id) {
		usersDao.delete(id);
		
	}

	public Users getUserByUserLoginName(String username) {
		
		return usersDao.getUserByUserLoginName(username);
		
	}

	public void addUsers(Users users) {

		usersDao.addUsers(users);
		
	}

	public boolean isUserExist(Users user) {
		
		return usersDao.isUserExist(user);
	}

}
