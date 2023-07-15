package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.letsstartcoding.springbootrestapiexample.DTO.UserInfoUserDetails;
import com.letsstartcoding.springbootrestapiexample.Entity.UserInfo;
import com.letsstartcoding.springbootrestapiexample.repository.UserInfoRepository;

public class UserInfoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserInfo> userInfo=repository.findByUserName(username);
		return userInfo.map(UserInfoUserDetails::new).orElseThrow(null);
	}

}
