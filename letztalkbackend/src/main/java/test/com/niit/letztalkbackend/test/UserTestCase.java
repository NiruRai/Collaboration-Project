package test.com.niit.letztalkbackend.test;

import static org.junit.Assert.*;

import com.niit.letztalkbackend.model.Blog;
import com.niit.letztalkbackend.model.Role;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.letztalkbackend.daoImpl.BlogDaoImpl;
import com.niit.letztalkbackend.daoImpl.RoleDaoImpl;

public class UserTestCase {
	
	@Autowired
	private Role role;
	
	@Autowired
	private RoleDaoImpl roleDaoImpl;
	
	@Autowired
	private Blog blog;
	
	@Autowired
	private BlogDaoImpl blogdaoImpl;
	
	
	
	@Test
	public void roleTestCase(){
		
		role=roleDaoImpl.getRoleById(1);
		
		assertEquals("Roe Name Test Case", role.getRoleID(), role);
		
	}
	
	@Test
	public void userTestCase(){
		
		blog=blogdaoImpl.getblogById(1);
		
		assertEquals("Blog Id test case",blog.getBlogId(),blog);
		
		
		
	}

}
