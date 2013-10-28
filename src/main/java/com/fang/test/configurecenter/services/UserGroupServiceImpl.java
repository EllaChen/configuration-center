package com.fang.test.configurecenter.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fang.test.configurecenter.dao.UserDAO;
import com.fang.test.configurecenter.dao.UserGroupDAO;
import com.fang.test.configurecenter.form.UserGroupIdName;
import com.fang.test.configurecenter.vo.GroupItem;
import com.fang.test.configurecenter.vo.User;
import com.fang.test.configurecenter.vo.UserGroup;

@Component("userGroupService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class UserGroupServiceImpl implements UserGroupService{

	@Inject
	@Named("userGroupDAO")
	private UserGroupDAO usrgrpDAO;
	
	@Inject
	@Named("userDAO")
	private UserDAO userDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List<String> createUserGroup(UserGroup usrGrp) {
		
		
		List<String> res = new ArrayList<String>();
		
		List<GroupItem> target = new ArrayList<GroupItem>();
		for(GroupItem item: usrGrp.getItems()){
			User user = userDAO.getUserByName(item.getUser().getName());
			if(user ==null){
				res.add(item.getUser().getName());
			}else{
				item.setUser(user);
				if(!target.contains(item)){
					target.add(item);
				}
			}
		}
		
		usrGrp.getItems().clear();
		usrGrp.getItems().addAll(target);
		
		usrgrpDAO.createUserGroup(usrGrp);
		return res;
	}

	@Override
	public List<UserGroupIdName> getAllUserGroups() {
		
		return convert(usrgrpDAO.getAllUserGroups());
	}

	@Override
	public List<UserGroupIdName> getAllUserGroups(int index, int maxLength) {
		return convert(usrgrpDAO.getAllUserGroups(index, maxLength));
	}

	@Override
	public List<UserGroupIdName> getUserGroupsByOwner(long owner) {
		return convert(usrgrpDAO.getUserGroupsByOwner(owner));
	}

	@Override
	public List<UserGroupIdName> getUserGroupsByOwner(long owner, int index,
			int maxLength) {
		return convert(usrgrpDAO.getUserGroupsByOwner(owner, index, maxLength));
	}
	
	private List<UserGroupIdName> convert(List<UserGroup> usrGrps) {
		List<UserGroupIdName> ret = new ArrayList<UserGroupIdName>();
		if(usrGrps != null){
			for(UserGroup usrGrp: usrGrps){
				UserGroupIdName summary = new UserGroupIdName(usrGrp);
				ret.add(summary);
			}
		}
		
		return ret;
	}

	@Override
	public UserGroup getUserGroupById(long id) {
		UserGroup usr =  usrgrpDAO.getUserGroupById(id);
		if(usr != null){
				Hibernate.initialize(usr.getItems());
				Hibernate.initialize(usr.getOwner());
		}
		return usr;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public List<String> updateGroupUsers(UserGroup userGroup) {
		List<String> res = new ArrayList<String>();
		UserGroup ug = usrgrpDAO.getUserGroupById(userGroup.getId());
		List<GroupItem> removeList = new ArrayList<GroupItem>(ug.getItems());
		for(GroupItem item: userGroup.getItems()){
			User user = userDAO.getUserByName(item.getUser().getName());
			if(user ==null){
				res.add(item.getUser().getName());
			}else{
				item.setUser(user);
				if(!ug.getItems().contains(item)){
					item.setUserGroup(ug);
					ug.getItems().add(item);
				}
				removeList.remove(item);
			}
		}
		
		ug.getItems().removeAll(removeList);
		usrgrpDAO.updateUserGroup(ug);
		
		userGroup.setItems(ug.getItems());
		userGroup.setName(ug.getName());
		return res;
	}

}
