package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.ForumComment;

public interface ForumCommentDao {
	
	public List<ForumComment> forumCommentlist();
	
	public void saveOrUpdate(ForumComment forumComment);
	
	public void delete(int id);
	
	public ForumComment getforumCommentById(int id);
	
	public ForumComment getforumCommentByUserName(String username);

}
