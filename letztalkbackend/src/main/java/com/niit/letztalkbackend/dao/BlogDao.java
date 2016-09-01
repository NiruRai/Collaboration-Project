package com.niit.letztalkbackend.dao;

import java.util.List;

import com.niit.letztalkbackend.model.Blog;

public interface BlogDao {
	
	public List<Blog> bloglist();
	
	public void saveOrUpdate(Blog blog);
	
	public void delete(int id);
	
	public Blog getblogById(int id);
	
	public Blog getblogByblog(String blogtitle);

}
