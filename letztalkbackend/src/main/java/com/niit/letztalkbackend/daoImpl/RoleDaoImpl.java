package com.niit.letztalkbackend.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.letztalkbackend.dao.RoleDao;
import com.niit.letztalkbackend.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	public RoleDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public RoleDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory=sessionFactory;
	}

	public List<Role> rolelist() {
		
		@SuppressWarnings("unchecked")
		List<Role> listrole=(List<Role>)sessionFactory.getCurrentSession().createQuery("from Role").list();
		
		return listrole;
	}

	public boolean saveOrUpdate(Role role) {

		sessionFactory.getCurrentSession().saveOrUpdate(role);
		
		return true;
		
	}

	public void delete(int id) {

		Role RoleToDelete=new Role();
		RoleToDelete.setRoleID(id);
		sessionFactory.getCurrentSession().delete(RoleToDelete);
		
	}
	@Transactional
	public Role getRoleById(int id) {
		String hql= "from Role where roleID=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Role> listRole=(List<Role>) query.list();
		if(listRole!=null && !listRole.isEmpty()){
			
			return listRole.get(0);
			
		}
		
		else
		{
			return null;			
		}

	}

	public Role getRoleByName(String rolename) {
		String hql="from Role where roleName=:unm";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("unm", rolename);
		
		@SuppressWarnings("unchecked")
		List<Role> listRole=(List<Role>) query.list();
		if(listRole!=null && !listRole.isEmpty()){
			
			return listRole.get(0);
			
		}
		else
		{
			return null;
		}

	}

}
