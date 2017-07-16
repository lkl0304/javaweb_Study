package section_2.jdbc.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtils {
	public static Connection getConnect()
	{
		String url      = "jdbc:mysql://localhost:3306/sw?characterEncoding=gbk";
		String user     = "root";
		String password = "root";
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.err.println("驱动加载失败！");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("数据库连接失败！");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void myclose(Statement pre, Connection con){
		
		try {
			if (pre != null) {
				pre.close();
				pre = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void myclose(Statement pre, Connection con, ResultSet res){
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			res = null;
		}
		myclose(pre, con);
	}
}
