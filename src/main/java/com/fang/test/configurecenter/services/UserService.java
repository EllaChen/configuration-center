package com.fang.test.configurecenter.services;

import java.util.List;

import com.fang.test.configurecenter.vo.User;


public interface UserService{

	public void createUser(User user);
	
	public void updateUserProfile(User user);
	
	public User getUserById(long id);
	public User getUserByName(String id);
	
	public List<String> getAllUserNames();
	public List<String> searchUserNames(String match);
}
