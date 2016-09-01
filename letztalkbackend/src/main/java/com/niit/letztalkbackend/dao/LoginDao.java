package com.niit.letztalkbackend.dao;

import java.util.List;

import com.niit.letztalkbackend.model.Login;

public interface LoginDao {
	
	public List<Login> loginlist();
	
	public boolean saveOrUpdate(Login login);
	
	public void delete(int id);
	
	public Login getLoginByName(String username);
	
	public Login getLoginById(int id);
	
	public boolean IsValidUser(String username,String password);

}
