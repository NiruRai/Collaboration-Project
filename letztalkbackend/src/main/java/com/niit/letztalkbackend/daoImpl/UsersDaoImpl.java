package com.niit.letztalkbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.letztalkbackend.dao.UsersDao;
import com.niit.letztalkbackend.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	
	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	

	public List<Users> userslist() {
		
		@SuppressWarnings("unchecked")
		List<Users> userslist=(List<Users>)sessionFactory.getCurrentSession().createQuery("from Users").list();
		
		return userslist;
	}

	public Users getUserById(int id) {
		
		String hql= "from Users where userId=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers=(List<Users>) query.list();
		if(listUsers!=null && !listUsers.isEmpty()){
			
			return listUsers.get(0);
			
		}
		
		else
		{
			return null;			
		}

	}

	

	public void saveOrUpdate(Users users) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		
	}

	public void delete(int id) {
		
		Users UsersToDelete=new Users();
		UsersToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(UsersToDelete);
		
		
	}

	public Users getUserByUserLoginName(String username) {
		String hql="from Users where userLoginName=:unm";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("unm", username);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers=(List<Users>) query.list();
		if(listUsers!=null && !listUsers.isEmpty()){
			
			return listUsers.get(0);
			
		}
		else
		{
			return null;
		}

	}

	

}
