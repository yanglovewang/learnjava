package com.java1234.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.java1234.model.User;

@Repository
public class userDaoImpl implements UserDao {

	@Resource
	private JdbcTemplate JdbcTemplate;
	@Override
	public User queryUser(User user) {
		String sql = "select * from t_user where userName = ? and passWord = ?";
		final User u = new User();
		JdbcTemplate.query(sql, new Object[]{
			user.getUserName(),
			user.getPassword(),
		}, new RowCallbackHandler() {
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				u.setUserName(rs.getString("userName"));
				u.setPassword(rs.getString("passWord"));
				u.setRoleName(rs.getString("roleName"));
				u.setId(rs.getInt("id"));
			}
		});
		
		return u;
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUserName("java1234");
		user.setPassword("123456");
		UserDao userDao = new userDaoImpl();
		System.out.println(userDao.queryUser(user));
		
	}
	
}
