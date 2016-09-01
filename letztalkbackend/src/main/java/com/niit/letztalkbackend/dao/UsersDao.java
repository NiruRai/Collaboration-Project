package com.niit.letztalkbackend.dao;

import java.util.List;

import com.niit.letztalkbackend.model.Users;

public interface UsersDao {
	
	public List<Users> userslist();
	
	public Users getUserById(int id);
	
	public void saveOrUpdate(Users users);
	
	public void delete(int id);
	
	public Users getUserByUserLoginName(String username);
	
	


}
