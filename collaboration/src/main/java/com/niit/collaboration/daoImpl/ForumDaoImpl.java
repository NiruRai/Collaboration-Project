package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.collaboration.dao.ForumDao;
import com.niit.collaboration.model.Forum;

public class ForumDaoImpl implements ForumDao {
	
	public ForumDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory; 
		
	public ForumDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory=sessionFactory;
		
	}
	

	public List<Forum> forumlist() {
		@SuppressWarnings("unchecked")
		List<Forum> forumlist=(List<Forum>)sessionFactory.getCurrentSession().createQuery("from Forum").list();
		
		return forumlist;
	}

	public void saveOrUpdate(Forum forum) {
			
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		
	}

	public void delete(int id) {
		Forum ForumToDelete=new Forum();
		ForumToDelete.setForumId(id);
		sessionFactory.getCurrentSession().delete(ForumToDelete);
		
	}

	public Forum getforumById(int id) {
		String hql= "from Forum where forumId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Forum> listforum=(List<Forum>) query.list();
		if(listforum!=null && !listforum.isEmpty()){
			
			return listforum.get(0);
			
		}
		
		else
		{
			return null;			
		}
	}

	public Forum getforumByTitle(String forumtitle) {
		System.out.println(forumtitle);
		String hql="from Blog where forumTitle=:ftn";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("ftn", forumtitle);
		
		@SuppressWarnings("unchecked")
		List<Forum> listforum=(List<Forum>) query.list();
		if(listforum!=null && !listforum.isEmpty()){
			
			return listforum.get(0);
			
		}
		else
		{
			return null;
		}
	}

	public boolean isForumExist(Forum forum) {
		return getforumByTitle(forum.getForumTitle())!=null;
	}

}
