package com.fang.test.configurecenter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fang.test.configurecenter.vo.User;

@Controller
@RequestMapping({ "/logout" })
public class LogoutController extends UserAuthUtils {

	@RequestMapping(method = RequestMethod.GET)
	public String login(User user,HttpServletRequest request) {
		removeUserFromSession(request);
		return "redirect:/login";
	}
}
