package com.niit.collaboration.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.collaboration.model.Users;
import com.niit.collaboration.service.UsersService;

@Controller
public class SignUpController {
	
	private Path path;
	
	@RequestMapping("/signUp")
	public String signUp()
	{
		return "signUp";
	}

	@ModelAttribute("registerCommand")
	public Users newUser()
	{
		return new Users();
	}
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("registerCommand") Users user, HttpServletRequest request, BindingResult result, Model model){

        if(result.hasErrors()){
            return "signUp";
        }
        
        usersService.addUsers(user);
       // user.setEnabled(true);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        /*List<Users> customerList = userService.list();
        for (int i=0; i< customerList.size(); i++){
            if(user.getUseremail().equals(customerList.get(i).getUseremail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "signUp";
            }

            if(user.getUsername().equals(customerList.get(i).getUsername())){
                model.addAttribute("usernameMsg", "Username already exists");

                return "signUp";
            }
        }*/

        //userService.saveOrUpdate(user);
        
        MultipartFile userImage= user.getImage();
		String rootDirectory= request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "WEB-INF/resources/images" + user.getUserId() + ".png");
		System.out.println("Path = " + path);
		System.out.println("File name = " + user.getImage().getOriginalFilename());
		System.out.println(user.getUserId());
		if(userImage!=null && !userImage.isEmpty())
		{
			try{
				userImage.transferTo(new File(path.toString()));
				System.out.println("Image Succesfully Uploaded");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println(e.getMessage());
				throw new RuntimeException("User Profile Picture Saving Failed", e);
			}
		}
		
        
        return "redirect:/registerConfirmed";
    }

	
        
        
		    
	    @RequestMapping("/registerConfirmed")
		public String registerConfirmed(){
			
			return "registerConfirmed";
			
		}

}
