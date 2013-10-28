package com.fang.test.configurecenter.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fang.test.configurecenter.dao.UserDAO;
import com.fang.test.configurecenter.vo.User;

@Component("userService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {

	@Inject
	@Named("userDAO")
	private UserDAO userDAO;
	
	@Inject
	@Named("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDAO.createUser(user);
	}

	

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateUserProfile(User user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public User getUserById(long id) {
		
		return userDAO.getUserById(id);
	}



	@Override
	public User getUserByName(String id) {
		return userDAO.getUserByName(id);
	}



	@Override
	public List<String> getAllUserNames() {
		return userDAO.getAllUserNames();
	}



	@Override
	public List<String> searchUserNames(String match) {
		return userDAO.searchUserNames(match);
	}

}
