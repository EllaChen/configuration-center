package com.fang.test.configurecenter.dao;

import java.util.List;

import com.fang.test.configurecenter.vo.UserGroup;

public interface UserGroupDAO {

	void createUserGroup(UserGroup customer);
	void deleteUserGroup(long id);
	UserGroup getUserGroupById(long id);
	UserGroup getUserGroupByName(String name);
	void updateUserGroup(UserGroup user);
	List<UserGroup> getAllUserGroups();
	List<UserGroup> getAllUserGroups(int index, int maxLength);
	
	List<UserGroup> getUserGroupsByOwner(Long owner);
	List<UserGroup> getUserGroupsByOwner(Long owner, int index, int maxLength);
}
