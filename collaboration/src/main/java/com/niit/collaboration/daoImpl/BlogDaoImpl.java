package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.BlogDao;
import com.niit.collaboration.model.Blog;


@Repository
public class BlogDaoImpl implements BlogDao{
	
	public BlogDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public List<Blog> bloglist() {

		@SuppressWarnings("unchecked")
		List<Blog> bloglist=(List<Blog>)sessionFactory.getCurrentSession().createQuery("from Blog").list();
		
		return bloglist;
	}

	public void saveOrUpdate(Blog blog) {
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		
	}

	public void delete(int id) {
		
		Blog BlogToDelete=new Blog();
		BlogToDelete.setBlogId(id);
		sessionFactory.getCurrentSession().delete(BlogToDelete);
		
	}

	public Blog getblogById(int id) {
		String hql= "from Blog where blogId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Blog> listblog=(List<Blog>) query.list();
		if(listblog!=null && !listblog.isEmpty()){
			
			return listblog.get(0);
			
		}
		
		else
		{
			return null;			
		}

	}

	public Blog getblogByblog(String blogtitle) {
		System.out.println(blogtitle);
		String hql="from Blog where blogTitle=:btn";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("btn", blogtitle);
		
		@SuppressWarnings("unchecked")
		List<Blog> listblog=(List<Blog>) query.list();
		if(listblog!=null && !listblog.isEmpty()){
			
			return listblog.get(0);
			
		}
		else
		{
			return null;
		}
	}

	@Transactional
	public boolean isBlogExist(Blog blog) {
		return getblogByblog(blog.getBlogTitle())!=null;
	}

}
