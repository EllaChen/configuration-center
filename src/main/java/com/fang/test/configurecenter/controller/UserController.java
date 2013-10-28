package com.fang.test.configurecenter.controller;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fang.test.configurecenter.services.UserService;
import com.fang.test.configurecenter.vo.User;

@Controller
public class UserController extends BaseErrorHandlerController{

	@Inject
	@Named("userService")
	private UserService userService;

	
	@Inject
	@Named("userAuthUtils")
	private UserAuthUtils utils;
	
	@RequestMapping(value={ "/register" }, method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}

	@RequestMapping(value={ "/register" },params = "act=register", method = RequestMethod.POST)
	public String register(User user, Map<String, Object> model,
			BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "register";
		}
		
		User cloneUser = (User) user.clone();
		userService.createUser(user);
		cloneUser.setId(user.getId());
		utils.authenticateuser(cloneUser,request);

		return "redirect:/home";
	}
	
	@RequestMapping(value={ "/editProfile" },method = RequestMethod.GET)
	public String showEditProfilePage(User user, Map<String, Object> model,
			BindingResult bindingResult, HttpServletRequest request) {
		long id = utils.getUserId(request);
		model.put("user", userService.getUserById(id));
		return "editProfile";
	}
	
	@RequestMapping(value={ "/editProfile" },params = "act=edit", method = RequestMethod.POST)
	public String editProfile(User user, Map<String, Object> model,
			BindingResult bindingResult, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "editProfile";
		}
		
		userService.updateUserProfile(user);
		
		utils.updateUserInfo(user, request);

		return "redirect:/home";
	}
}
