package com.fang.test.configurecenter.dao;

import java.util.List;

import com.fang.test.configurecenter.vo.User;


public interface UserDAO {

	void createUser(User customer);
	void deleteUserById(long id);
	User getUserById(long id);
	User getUserByName(String id);
	void updateUser(User user);
	List<String> getAllUserNames();
	List<String> searchUserNames(String match);
}
