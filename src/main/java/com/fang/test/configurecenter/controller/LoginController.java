package com.fang.test.configurecenter.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fang.test.configurecenter.vo.User;

@Controller
@RequestMapping({ "/login" })
public class LoginController extends BaseErrorHandlerController{
	
	private final Log log= LogFactory.getLog(LoginController.class);

	@Inject
	@Named("userAuthUtils")
	private UserAuthUtils utils;
	
////	@RequestMapping(params = "op=show", method = RequestMethod.GET)
//	@RequestMapping(method = RequestMethod.GET)
//	public String showLoginPage(@RequestParam(value = "error", required = false) boolean error,  
//            ModelMap model) {
//		System.out.println("Has error: " + error);
//        if (error == true) {  
//            // Assign an error message  
//            model.put("error",  "You have entered an invalid username or password!");  
//        } else {  
//            model.put("error", "");  
//        } 
//		return "login";
//	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showLoginPage(
			@RequestParam(value = "error", required = false) boolean error,
			ModelMap model) {
		System.out.println("Has error: " + error);
		if (error == true) {
			// Assign an error message
			model.put("error",
					"You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}
		
		return "login";
	}

	@RequestMapping(params = "act=signin", method = RequestMethod.POST)
	public String login(User user, BindingResult bindingResult, HttpServletRequest request,ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		try{
			utils.authenticateuser(user, request);
		}catch(AuthenticationException e){
			log.error("Failed to authenticate user: " + user.getName(), e);
			e.printStackTrace();
			model.put("error",
					"You have entered an invalid username or password!");
			return "login";
		}
		
		return "redirect:/home";
	}
}
