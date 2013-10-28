package com.fang.test.configurecenter.services;

import java.util.List;

import com.fang.test.configurecenter.form.UserGroupIdName;
import com.fang.test.configurecenter.vo.UserGroup;

public interface UserGroupService {

	public List<String> createUserGroup(UserGroup usrGrp);
	public List<String> updateGroupUsers(UserGroup usrGrp);
	public UserGroup getUserGroupById(long id);
	public List<UserGroupIdName> getAllUserGroups();
	public List<UserGroupIdName> getAllUserGroups(int index, int maxLength);
	public List<UserGroupIdName> getUserGroupsByOwner(long owner);
	public List<UserGroupIdName> getUserGroupsByOwner(long owner,int index, int maxLength);
//	public List<String> updateGroupUsers(long userGroupId,List<String> userNames);
}
