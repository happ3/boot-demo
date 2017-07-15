package com.boot.demo.provide.impl;


import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.boot.demo.api.ExampleService;
import com.boot.demo.dao.entity.User;
import com.boot.demo.service.UserService;

public class ExampleServiceImpl implements ExampleService{

	@Resource
	private UserService userService;
	@Override
	public User getUserById(int userId) {
		User user =userService.getUserById(userId);
		
		System.out.println(JSON.toJSONString(user));
		return user;
	}
}
