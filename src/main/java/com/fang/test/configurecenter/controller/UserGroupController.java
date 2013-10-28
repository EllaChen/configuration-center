package com.fang.test.configurecenter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fang.test.configurecenter.form.UserGroupIdName;
import com.fang.test.configurecenter.services.UserGroupService;
import com.fang.test.configurecenter.services.UserService;
import com.fang.test.configurecenter.vo.GroupItem;
import com.fang.test.configurecenter.vo.User;
import com.fang.test.configurecenter.vo.UserGroup;

@Controller
public class UserGroupController extends BaseErrorHandlerController {

	@Inject
	@Named("userGroupService")
	private UserGroupService usrGrpService;
	
	@Inject
	@Named("userAuthUtils")
	private UserAuthUtils utils;
	
	@Inject
	@Named("userService")
	private UserService userService;
	
//	@RequestMapping(value={ "/viewUserGroups"},method = RequestMethod.GET)
//	public String showUserGroupListPage(ModelMap model, HttpServletRequest request) {
//		
//		List<UserGroupSummary> list = usrGrpService.getAllUserGroups();
//		model.put("userGroups", list);
//		return "viewUserGroups";
//	}
//	
//	@RequestMapping(value={ "/createUserGroup"},method = RequestMethod.GET)
//	public String showCreateUserGroupPage(ModelMap model, HttpServletRequest request) {
//		model.put("act", "create");
//		return "editUserGroup";
//	}
//	
//	@RequestMapping(value={ "/editUserGroup"},method = RequestMethod.GET)
//	public String showEditUserGorupPage(@RequestParam("id") long id, HttpServletRequest request,ModelMap model) {
//		UserGroup userGroup = usrGrpService.getUserGroupById(id);
//		model.put("userGroup", userGroup);
//		model.put("act", "update");
//		return "editUserGroup";
//	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@RequestMapping(value={ "/userGroups"},method = RequestMethod.GET)
	public String showUserGroupsPage(ModelMap model, HttpServletRequest request) {
		
		List<UserGroupIdName> list = usrGrpService.getAllUserGroups();
		model.put("userGroups", list);
		return "userGroups";
	}
	
	@RequestMapping(value={ "/updateUserGroup"},method = RequestMethod.GET)
	public String showUpdateUserGorupPage(@RequestParam("id") long id, HttpServletRequest request,ModelMap model) {
		
		UserGroup userGroup = usrGrpService.getUserGroupById(id);
		if(userGroup == null){
			throw new IllegalArgumentException("No user group found.");
		}
		model.put("userGroup", userGroup);
		Long userId = utils.getUserId(request);
		if(userId != null && userId == userGroup.getOwner().getId()){
			model.put("act", "update");
			return "editUserGroup";
		}else{
			return "viewUserGroup";
		}
	}
	
	@RequestMapping(value={ "/editUserGroup"},params="act=update",method = RequestMethod.POST)
	public String updateUserGroup(long id,String name,@RequestParam(value="userName",required=false) List<String> userNames, HttpServletRequest request,ModelMap model) {
		
		userNames = (userNames ==null? new ArrayList<String>():userNames);
		UserGroup userGroup = constructUserGroup(id, name, userNames);
		List<String> failed = usrGrpService.updateGroupUsers(userGroup);
//		UserGroup userGroup = usrGrpService.getUserGroupById(id);
		model.put("userGroup", userGroup);
		model.put("act", "update");
		if(failed.size() > 0){
			model.put("error", "Cannot find users: " + failed);	
		}
		
		return "editUserGroup";
	}
	
	@RequestMapping(value={ "/editUserGroup"},params="act=create",method = RequestMethod.POST)
	public String createUserGroup(String name,@RequestParam(value="userName",required=false) List<String> userNames, HttpServletRequest request,ModelMap model) {
		userNames = (userNames ==null? new ArrayList<String>():userNames);
		UserGroup userGroup = constructUserGroup(null, name, userNames);
		Long id = utils.getUserId(request);
		User user = new User();
		user.setId(id);
		userGroup.setOwner(user);
		
		List<String> failed = usrGrpService.createUserGroup(userGroup);
		model.put("userGroup", userGroup);
		model.put("act", "update");
		
		if(failed.size() > 0){
			model.put("error", "Cannot find users: " + failed);	
		}
		
		return "editUserGroup";
	}
	
	@RequestMapping(value={ "/newUserGroup"},method = RequestMethod.GET)
	public String showNewUserGroupPage(ModelMap model, HttpServletRequest request) {
		if(!utils.hasUserLogin(request)){
			model.put("error", "Please login first");
			throw new IllegalStateException("User should login first");
		}
		model.put("act", "create");
		return "editUserGroup";
	}
	
	protected UserGroup constructUserGroup(Long id, String name, List<String> userNames){
		UserGroup userGroup = new UserGroup();
		userGroup.setId(id);
		userGroup.setName(name);
		for(String userName: userNames){
			GroupItem item = new GroupItem();
			User user = new User();
			user.setName(userName);
			item.setUser(user);
			item.setUserGroup(userGroup);
			userGroup.getItems().add(item);
		}
		return userGroup;
	}
	
	
	
}
