package com.letsstartcoding.springbootrestapiexample.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.letsstartcoding.springbootrestapiexample.DTO.UserInfoUserDetailsDto;
import com.letsstartcoding.springbootrestapiexample.Entity.UserInfo;
import com.letsstartcoding.springbootrestapiexample.repository.UserInfoRepository;

public class UserInfoUserDetails implements UserDetailsService{
	@Autowired
 private UserInfoRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	Optional<UserInfo> userinfo=repository.findByUserName(username);
		return userinfo.map(UserInfoUserDetailsDto::new).orElseThrow(null);
	}

}
