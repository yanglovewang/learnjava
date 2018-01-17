package JdbcUtil1;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil1 {
	
	private static Properties pro = null;
	
	static {
		try {
		pro = new Properties();
		InputStream in = JdbcUtil1.class.getClassLoader()
				.getResourceAsStream("properties.properties");
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Class.forName(pro.getProperty("driverClassName"));        //静态注册驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection conn() throws SQLException {
		return DriverManager.getConnection(pro.getProperty("url"),    //通过jdbc驱动管理器建立连接
				pro.getProperty("username"), pro.getProperty("password"));
	}
	
	public static void main(String[] arg) throws SQLException{
		if(JdbcUtil1.conn()!=null) {
			System.out.println("连接成功");
		}
	}
}
