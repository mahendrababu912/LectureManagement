package com.letsstartcoding.springbootrestapiexample.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsstartcoding.springbootrestapiexample.Entity.UserInfo;
import com.letsstartcoding.springbootrestapiexample.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository repository;
	
	public UserInfo saveUser(UserInfo userInfo) {
		
		return repository.save(userInfo);
		
	}

}
