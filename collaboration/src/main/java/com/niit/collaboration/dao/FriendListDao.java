package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.FriendList;
import com.niit.collaboration.model.Users;

public interface FriendListDao {
	
public List<FriendList> friendList();
	
	public FriendList getFriendByFromId(int id);
	
	public void saveOrUpdate(FriendList friendList);
	
	public void delete(int id);
	
	public void addFriendList(FriendList friendList,Users userFrom,Users userTo);
	
	

}
