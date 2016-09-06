package com.niit.collaboration.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.LoginDao;
import com.niit.collaboration.model.Login;

@Repository
public class LoginDaoImpl implements LoginDao {

	public LoginDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	public LoginDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	public List<Login> loginlist() {
		@SuppressWarnings("unchecked")
		List<Login> loginlist = (List<Login>) sessionFactory.getCurrentSession().createQuery("from Login").list();
		return loginlist;

	}

	public boolean saveOrUpdate(Login login) {

		sessionFactory.getCurrentSession().saveOrUpdate(login);
		
		return true;

	}

	public void delete(int id) {

		Login login = new Login();

		login.setLoginID(id);

		sessionFactory.getCurrentSession().delete(login);

	}

	public Login getLoginByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Login getLoginById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean IsValidUser(String username, String password) {
		String hql = "from Login where userName=:unm and password=:pass";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("unm", username);
		query.setParameter("pass", password);
		@SuppressWarnings("unchecked")
		List<Login> list = (List<Login>) query.list();

		if (list != null && !list.isEmpty()) {
			return true;
		}

		return false;

	}

}
