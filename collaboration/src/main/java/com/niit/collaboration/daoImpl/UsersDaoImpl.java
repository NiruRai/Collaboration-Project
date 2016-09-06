package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.collaboration.dao.UsersDao;
import com.niit.collaboration.model.Login;
import com.niit.collaboration.model.Role;
import com.niit.collaboration.model.Users;


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

	
	@Transactional
	public void saveOrUpdate(Users users) {
	
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		
	}

	public void delete(int id) {
		
		Users UsersToDelete=new Users();
		UsersToDelete.setUserId(id);
		sessionFactory.getCurrentSession().delete(UsersToDelete);
		
		
	}
	
	@Transactional
	public Users getUserByUserLoginName(String username) {
		System.out.println(username);
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


	@Transactional
	public void addUsers(Users users) {
		
		Session session = sessionFactory.getCurrentSession();
		
		users.setStatus("NEW");
		
		session.saveOrUpdate(users);
		
		Login login = new Login();
		
	//	login.setLoginID(users.getUserId());
		
		login.setIsActive(true);
		
		login.setUserName(users.getUserLoginName());
		
		login.setPassword(users.getPassword());
		
		
		Role role = new Role();
		
		role.setUserLoginName(users.getUserLoginName());
		
		role.setRoleName("ROLE_USER");
		
		session.saveOrUpdate(login);
		
		session.saveOrUpdate(role);
		
		//session.flush();
		
	}
		
		@Transactional
		public boolean isUserExist(Users user) {
			return getUserByUserLoginName(user.getUserLoginName())!=null;
		}
		
		
	}

	


