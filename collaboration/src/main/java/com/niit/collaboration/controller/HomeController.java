package com.niit.collaboration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.collaboration.dao.UsersDao;
import com.niit.collaboration.model.Users;
import com.niit.collaboration.service.UsersService;

@Controller
public class HomeController {
	
	@Autowired
	UsersService userService;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(value = "/userHome/{userLoginname}" , method=RequestMethod.GET)
	public String userHome(@PathVariable("userLoginname") String userLoginname, Model model)
	{   
		Users list=userService.getUserByUserLoginName(userLoginname);
		model.addAttribute("userProfile",userService.getUserByUserLoginName(userLoginname));
		
		System.out.println(list.getUserId());
		return "userHome";
	}
	
	

}
