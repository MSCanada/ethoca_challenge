package org.msuhail.java.home_project.web;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.msuhail.java.home_project.DAO.Authenticate_Users;
import org.msuhail.java.home_project.model.Users_Auth;
import org.msuhail.java.home_project.service.HashGenerator;
import org.msuhail.java.home_project.service.Validate_User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {

	@RequestMapping(value = "/Login.htm", method = RequestMethod.GET)
	public ModelAndView Login() {

		ModelAndView LoginView = new ModelAndView("Login");
		return LoginView;

	}

	@RequestMapping(value = "/Login.htm", method = RequestMethod.POST)
	public ModelAndView Login_Authenticate(
			@ModelAttribute("users") Users_Auth user, BindingResult BR,HttpSession session)
			throws NoSuchAlgorithmException {
		if (Validate_User.Authenticate(user)){
			session.setAttribute("user_object", user);
			System.out.println("Logged in");
			}
		else
			System.out.println("Not Logged in");
		
		ModelAndView LoginView = new ModelAndView("Login");
		return LoginView;
	}
	
	
	@RequestMapping(value = "/Register.htm", method = RequestMethod.GET)
	public ModelAndView Register(HttpServletResponse response) throws JsonGenerationException, JsonMappingException, IOException {
ArrayList<String> names=new ArrayList();
names.add("muhammad");
names.add("muhammad1");
names.add("muhammad2");
response.addHeader("Access-Control-Allow-Origin", "*");
response.addHeader("Access-Control-Allow-Methods", "POST, GET"); // also added header to allow POST, GET method to be available
//responseHeaders.add("Access-Control-Allow-Origin", "*"); // also added header to allow cross domain request for any domain
ObjectMapper mapper = new ObjectMapper();
String name=mapper.writeValueAsString(names);
System.out.println(name);
		ModelAndView LoginView = new ModelAndView("Register");
		LoginView.addObject("HelloWorld",name);
		
		return LoginView;

	}

}
