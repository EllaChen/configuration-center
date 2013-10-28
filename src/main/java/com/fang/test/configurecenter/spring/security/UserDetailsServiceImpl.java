package com.fang.test.configurecenter.spring.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.CannotCreateTransactionException;

import com.fang.test.configurecenter.services.UserService;
import com.fang.test.configurecenter.vo.User;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Inject
	@Named("passwordEncoder")
	private PasswordEncoder passwordEncoder;
	
	@Inject
	@Named("userService")
	private UserService userService; 
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		UserInfo user = null;

		try {

			User dbUser = userService.getUserByName(username);
			user = new UserInfo(dbUser.getName(), dbUser.getPassword(), true, true, true, true,
					getAuthorities((short)1));
			user.setFullName(dbUser.getFullName());
			user.setId(dbUser.getId());
		}catch(CannotCreateTransactionException ex){
			throw ex;
		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user: " + username, e);
		}

		return user;
	}


	public Collection<GrantedAuthority> getAuthorities(short access) {

		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		authList.add(new SimpleGrantedAuthority("ROLE_USER"));

		// 如果参数access为1.则拥有ROLE_ADMIN权限
		if (access >= 1 ) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}

		return authList;
	}

}
