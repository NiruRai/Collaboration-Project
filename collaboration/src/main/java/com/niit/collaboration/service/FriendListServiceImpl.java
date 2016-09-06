package com.niit.collaboration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.collaboration.dao.FriendListDao;
import com.niit.collaboration.model.FriendList;
import com.niit.collaboration.model.Users;

@Service
public class FriendListServiceImpl implements FriendListService{
	
	@Autowired
	FriendListDao friendListDao;

	public FriendList getFriendByFromId(int id) {
		
		return friendListDao.getFriendByFromId(id);
	}

	public void saveOrUpdate(FriendList friendList) {
		
		friendListDao.saveOrUpdate(friendList);
		
	}

	public void delete(int id) {
	
		friendListDao.delete(id);
		
		
	}

	public void addFriendList(FriendList friendList, Users userFrom, Users userTo) {
		
		friendListDao.addFriendList(friendList, userFrom, userTo);
		
	}

}
