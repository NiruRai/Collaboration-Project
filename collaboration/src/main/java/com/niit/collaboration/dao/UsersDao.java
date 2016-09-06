package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Users;

public interface UsersDao {
	
	public List<Users> userslist();
	
	public Users getUserById(int id);
	
	public void saveOrUpdate(Users users);
	
	public void delete(int id);
	
	public void addUsers(Users users);
	
	public boolean isUserExist(Users user);
	
	public Users getUserByUserLoginName(String username);
	
	


}
