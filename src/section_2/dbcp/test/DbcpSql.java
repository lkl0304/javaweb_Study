package section_2.dbcp.test;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;
//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DbcpSql {
	// DBCP 数据源 连接池
	public static DataSource bd = null;
	//方法一： 直接连接
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
	
	// 方法二：工厂类读取配置文件
	static{
		Properties pps = new Properties();
		String path = "dbcpconfig.properties";
		try {
//			InputStream in = new FileInputStream(new File(path));
			InputStream in = new DbcpSql().getClass().getClassLoader().getResourceAsStream(path);
			pps.load(in);
			DbcpSql.bd = BasicDataSourceFactory.createDataSource(pps);
		} catch (IOException e) {
			System.err.println("文件读取失败！");
		} catch (Exception e) {
			System.err.println("加载配置失败！");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection con = bd.getConnection();
		
		String sql = "select * from user";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		
		while (rSet.next()){
			System.out.println("数据打印  name: " + rSet.getString("name") + " money: " + rSet.getFloat("money"));
		}
	}
}
