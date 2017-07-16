package section_2.jdbc.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

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
			System.err.println("��������ʧ�ܣ�");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void myclose(Statement stmt, Connection con) throws SQLException {
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (con != null) {
			con.close();
			con = null;
		}
	}
	public static void myclose(Statement stmt, Connection con, ResultSet res) throws SQLException{
		if (res != null) {
			res.close();
			res = null;
		}
		myclose(stmt, con);
	}
}
