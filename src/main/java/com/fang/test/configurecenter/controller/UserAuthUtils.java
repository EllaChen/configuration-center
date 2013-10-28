package com.fang.test.configurecenter.controller;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Component;

import com.fang.test.configurecenter.spring.security.UserInfo;
import com.fang.test.configurecenter.vo.User;

@Component("userAuthUtils")
public class UserAuthUtils{

	@Inject
	@Named("org.springframework.security.authenticationManager")
	protected AuthenticationManager authenticationManager;

	public  void authenticateuser(User user, HttpServletRequest request) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getName(), user.getPassword());
		token.setDetails(new WebAuthenticationDetails(request));
		
		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		request.getSession()
				.setAttribute(
						HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
						SecurityContextHolder.getContext());

	}
	
	public void updateUserInfo(User user, HttpServletRequest request){
		SecurityContext context = (SecurityContext) request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if(context != null){
			UserInfo info = ((UserInfo)context.getAuthentication().getPrincipal());
			info.setFullName(user.getFullName());
		}else{
			throw new SessionAuthenticationException("Could not find user. Please login.");
		}
	}
	
	public void removeUserFromSession(HttpServletRequest request) {
		request.getSession().removeAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
	}
	
	public Long getUserId(HttpServletRequest request){
		UserInfo info = getUser(request);
		if(info != null){
			return info.getId();
		}else{
			return null;
		}
	}
	
	public UserInfo getUser(HttpServletRequest request){
		SecurityContext context = (SecurityContext) request.getSession().getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if(context != null){
			return ((UserInfo)context.getAuthentication().getPrincipal());
		}
		return null;
	}
	
	public boolean hasUserLogin(HttpServletRequest request){
		return (getUser(request) != null);
	}
}
