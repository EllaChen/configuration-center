package com.fang.test.configurecenter.controller;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fang.test.configurecenter.form.NameSpaceDetail;
import com.fang.test.configurecenter.form.NameSpaceAcccessInfo;
import com.fang.test.configurecenter.services.NameSpaceService;

@Controller
public class NameSpacesController extends BaseErrorHandlerController {

	@Inject
	@Named("userAuthUtils")
	private UserAuthUtils utils;

	@Inject
	@Named("nameSpaceService")
	private NameSpaceService nsService;

	@RequestMapping(value = { "/nameSpaces" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String showUserGroupsPage(ModelMap model, HttpServletRequest request) {

		List<NameSpaceAcccessInfo> list = nsService.getAllNameSpacesForUser(utils
				.getUserId(request));
		model.put("nameSpaces", list);
		return "nameSpaces";
	}

	@RequestMapping(value = { "/createNameSpace" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String showCreateNameSpacePage(ModelMap model,
			HttpServletRequest request) {
		if(!utils.hasUserLogin(request)){
			model.put("error", "Please login first");
			throw new IllegalStateException("User should login first");
		}
		NameSpaceDetail detail = new NameSpaceDetail();
		if (utils.getUser(request) != null) {
			detail.setOwner(utils.getUser(request).getUsername());
		}
		model.put("nameSpace", detail);
		model.put("act", "create");
		return "editNameSpace";
	}

	@RequestMapping(value = { "/editNameSpace" }, params = "act=create", method = RequestMethod.POST)
	public String creatNameSpace(NameSpaceDetail detail,
			HttpServletRequest request, ModelMap model) {
		nsService.createNameSpace(detail);
		model.put("nameSpace", detail);
		model.put("act", "update");
		model.put("message", "Name space has been created sucessfully! Please refresh page to get it shown on the left.");
		return "editNameSpace";
	}
	
//	@RequestMapping(value = { "/editNameSpace" }, method = RequestMethod.GET)
//	public String showUpdateNameSpace(@RequestParam("id") long id,
//			HttpServletRequest request, ModelMap model) {
//		NameSpace ns = nsService.getNameSpace(id);
//		model.put("nameSpace", new NameSpaceDetail(ns));
//		model.put("act", "update");
//		return "editNameSpace";
//	}
	
	
	@RequestMapping(value = { "/editNameSpace" }, params = "act=update", method = RequestMethod.POST)
	public String updateNameSpace(NameSpaceDetail detail,
			HttpServletRequest request, ModelMap model) {
		nsService.updateNameSpace(detail);
		model.put("nameSpace", detail);
		model.put("act", "update");
		model.put("message", "Name space has been updated sucessfully!");
		return "editNameSpace";
	}
	
	@RequestMapping(value = { "/viewNameSpace" }, method = {RequestMethod.GET, RequestMethod.POST})
	public String viewNameSpace(@RequestParam("id") long id,
			HttpServletRequest request, ModelMap model) {
		
		NameSpaceDetail ns = nsService.getNameSpace(id, utils.getUserId(request));
		if(ns == null){
			throw new IllegalArgumentException("Workspace doesn't exists");
		}
		
		model.put("nameSpace", ns);
		boolean writable = ns.isCurrentWritable();
		if(writable){
			model.put("act", "update");
			return "editNameSpace";
		}else{
			return "viewNameSpace";
		}
	}

}
