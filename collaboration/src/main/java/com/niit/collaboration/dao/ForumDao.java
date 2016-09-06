package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Forum;

public interface ForumDao {
	
	public List<Forum> forumlist();
	
	public void saveOrUpdate(Forum forum);
	
	public void delete(int id);
	
	public Forum getforumById(int id);
	
	public Forum getforumByTitle(String forumtitle);
	
	public boolean isForumExist(Forum forum);
	

}
