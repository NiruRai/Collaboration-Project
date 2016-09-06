package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.FriendListDao;
import com.niit.collaboration.model.FriendList;
import com.niit.collaboration.model.Users;

@Repository
public class FriendListDaoImpl implements FriendListDao{

	
	public FriendListDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public FriendListDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
		
	}
	
	public List<FriendList> friendList() {
		@SuppressWarnings("unchecked")
		List<FriendList> friendlist = (List<FriendList>) sessionFactory.getCurrentSession()
				.createQuery("from FriendList").list();

		return friendlist;
	}

	public FriendList getFriendByFromId(int id) {
		String hql = "from FriendList where fromUserId= ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<FriendList> friendList = (List<FriendList>) query.list();
		

		if (friendList != null && !friendList.isEmpty()) {
			return friendList.get(0);
		}

		return null;
	}

	public void saveOrUpdate(FriendList friendList) {

		sessionFactory.getCurrentSession().saveOrUpdate(friendList);
		
	}

	public void delete(int id) {
		
		FriendList friendList = new FriendList();
		friendList.getFriendListId();
		sessionFactory.getCurrentSession().delete(friendList);
		
	}

	public void addFriendList(FriendList friendList,Users userFrom,Users userTo) {

		Session session=sessionFactory.getCurrentSession();
						
		friendList.setFromUserId(userFrom.getUserId());
		
		friendList.setRequestApproved(false);
		
		friendList.setRequestRejected(false);
		
		friendList.setRespondStatus("Pending");
		
		friendList.setToUserId(userTo.getUserId());
		
		session.saveOrUpdate(friendList);
		
				
	}

	

}
