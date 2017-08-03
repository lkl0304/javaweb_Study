package section_2.dbcp.test;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;
//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DbcpSql {
	// DBCP 数据库连接池
	public static DataSource bd = null;
//	static {
//		BasicDataSource bds = new BasicDataSource();
//		bds.setDriverClassName("com.mysql.jdbc.Driver");
//		bds.setUrl("jdbc:mysql://localhost:3306/sw?characterEncoding=gbk");
//		bds.setUsername("root");
//		bds.setPassword("root");
//		bds.setInitialSize(5);
//		bds.setMaxActive(10);
//		
//		DbcpSql.bd = bds;
//	}
	
	// 通过工厂类配置连接源
	static{
		Properties pps = new Properties();
		String path = "dbcpconfig.properties";
		try {
//			InputStream in = new FileInputStream(new File(path));
			InputStream in = new DbcpSql().getClass().getClassLoader().getResourceAsStream(path);
			pps.load(in);
			DbcpSql.bd = BasicDataSourceFactory.createDataSource(pps);
		} catch (IOException e) {
			System.err.println("没有发现文件");
		} catch (Exception e) {
			System.err.println("连接源创建失败");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection con = bd.getConnection();
		
		String sql = "select * from user";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		
		while (rSet.next()){
			System.out.println("name: " + rSet.getString("name") + " money: " + rSet.getFloat("money"));
		}
	}
}
