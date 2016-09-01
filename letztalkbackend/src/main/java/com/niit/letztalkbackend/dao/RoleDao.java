package com.niit.letztalkbackend.dao;

import java.util.List;

import com.niit.letztalkbackend.model.Role;

public interface RoleDao {
	
	public List<Role> rolelist();
	
	public boolean saveOrUpdate(Role role);
	
	public void delete(int id);
	
	public Role getRoleById(int id);
	
	public Role getRoleByName(String rolename);
	
	
	

}
