package com.niit.letztalkbackend.dao;

import java.util.List;

import com.niit.letztalkbackend.model.Forum;

public interface ForumDao {
	
	public List<Forum> forumlist();
	
	public void saveOrUpdate(Forum forum);
	
	public void delete(int id);
	
	public Forum getforumById(int id);
	
	public Forum getforumByTitle(String forumtitle);
	

}
