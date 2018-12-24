package com.java1234.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java1234.util.DbUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestDao {
	/**
	 * 
	 * 
	 * @param t 
	 * @return 
	 */
	public JSONArray getmenu(Connection conn, Test t) {
		JSONArray jsonArray = new JSONArray();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from test where parentid=? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getFatherId());
			 rs = ps.executeQuery();
			 while (rs.next()) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", rs.getInt("id"));
				jsonObject.put("text", rs.getString("tier"));
				jsonArray.add(jsonObject);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	public JSONArray getmenus(Connection conn, Test t) {
		JSONArray jsonArray = this.getmenu(conn, t);
		PreparedStatement ps = null;
		ResultSet rs = null;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject o = (JSONObject) jsonArray.get(i);
			if(o.get("text").equals("µÚ¶þ²ã")){
				continue;
			} else {
				Test test = new Test();
				test.setFatherId((Integer)o.get("id"));
				o.put("children", getmenus(conn, test));
			}
		}
		return jsonArray;
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = new DbUtil().getCon();
		Test t = new Test();
		t.setFatherId(1);
		System.out.println(t.getFatherId());
		TestDao testDao =  new TestDao();
		System.out.println(testDao.getmenus(conn, t));
	}

}
