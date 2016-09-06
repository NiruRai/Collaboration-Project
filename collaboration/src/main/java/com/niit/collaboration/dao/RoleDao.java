package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Role;

public interface RoleDao {
	
	public List<Role> rolelist();
	
	public boolean saveOrUpdate(Role role);
	
	public void delete(int id);
	
	public Role getRoleById(int id);
	
	public Role getRoleByName(String rolename);
	
	
	

}
