package com.niit.collaboration.service;

import java.util.List;

import com.niit.collaboration.model.Users;

public interface UsersService {
	
public List<Users> userslist();
	
	public Users getUserById(int id);
	
	public void saveOrUpdate(Users users);
	
	public void delete(int id);
	
	public void addUsers(Users users);
	
	public boolean isUserExist(Users user);
	
	public Users getUserByUserLoginName(String username);

}
