package com.letsstartcoding.springbootrestapiexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsstartcoding.springbootrestapiexample.Entity.UserInfo;
import com.letsstartcoding.springbootrestapiexample.dao.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserInfo userInfo) {
		userInfoService.saveUser(userInfo);
		return "User Saved";
	}
}
