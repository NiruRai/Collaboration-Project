package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.ForumCommentDao;
import com.niit.collaboration.model.ForumComment;

@Repository
public class ForumCommentDaoImpl implements ForumCommentDao {

	public ForumCommentDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	public ForumCommentDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<ForumComment> forumCommentlist() {
		@SuppressWarnings("unchecked")
		List<ForumComment> commentlist = (List<ForumComment>) sessionFactory.getCurrentSession()
				.createQuery("from ForumComment").list();

		return commentlist;
	}

	public void saveOrUpdate(ForumComment forumComment) {

		sessionFactory.getCurrentSession().saveOrUpdate(forumComment);

	}

	public void delete(int id) {

		ForumComment forumcomment = new ForumComment();
		forumcomment.setfCommentId(id);
		sessionFactory.getCurrentSession().delete(forumcomment);

	}

	public ForumComment getforumCommentById(int id) {
		String hql = "from ForumComment where fCommentId= ? ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<ForumComment> listcomment = (List<ForumComment>) query.list();
		

		if (listcomment != null && !listcomment.isEmpty()) {
			return listcomment.get(0);
		}

		return null;

	}

	public ForumComment getforumCommentByUserName(String username) {
		String hql = "from ForumComment where userName=: usm ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("usm", username);

		@SuppressWarnings("unchecked")
		List<ForumComment> listcomment = (List<ForumComment>) query.list();
		

		if (listcomment != null && !listcomment.isEmpty()) {
			return listcomment.get(0);
		}

		return null;

	}
	

}
