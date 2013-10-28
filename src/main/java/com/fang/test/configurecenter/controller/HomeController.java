package com.fang.test.configurecenter.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends BaseErrorHandlerController{

	public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

	@RequestMapping({ "/", "/home" })
	public String showHomePage(Map<String, Object> model) {
//		model.put("goodsList", new ArrayList());
		return "home";
	}

}
