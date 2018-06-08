package com.java1234.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.impl.UserDao;
import com.java1234.dao.impl.userDaoImpl;
import com.java1234.model.User;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private UserDao userDaoImpl;
	@Override
	public User queryUser(User user) {
		
		return userDaoImpl.queryUser(user);
	}

	
}
