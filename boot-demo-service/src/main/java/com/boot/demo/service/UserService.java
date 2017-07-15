package com.boot.demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.boot.demo.dao.entity.User;
import com.boot.demo.dao.mapper.UserMapper;
import com.boot.demo.redis.RedisService;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;

	@Resource
    private RedisService redisService;
	@Override
	public User getUserById(int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		boolean b = redisService.set("user:"+user.getId(), JSON.toJSONString(user), 1800);
		System.out.println(b);
		return userMapper.selectByPrimaryKey(userId);
	}
}
