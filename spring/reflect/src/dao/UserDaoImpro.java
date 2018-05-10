package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import util.DbUtil;

public class UserDaoImpro implements UserDao {

	@Override
	public void add(User user) {
		System.out.println("add");
	}

	@Override
	public void insert(int userId) {
		
		
	}

	@Override
	public void find(int userId, Connection conn, PreparedStatement ps, ResultSet rs) {
		conn
		
	}

	

	

}
