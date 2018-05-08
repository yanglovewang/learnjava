package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import model.User;

public interface UserDao {

	public void add(User user);
	public void insert(int userId);
	public void find(int userId, Connection conn, PreparedStatement ps, ResultSet rs);
}
