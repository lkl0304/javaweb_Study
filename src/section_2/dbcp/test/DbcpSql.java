package section_2.dbcp.test;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.sql.DataSource;
//import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.apache.tomcat.dbcp.dbcp.BasicDataSourceFactory;

public class DbcpSql {
	// DBCP ����Դ ���ӳ�
	public static DataSource bd = null;
	//����һ�� ֱ������
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
	
	// ���������������ȡ�����ļ�
	static{
		Properties pps = new Properties();
		String path = "dbcpconfig.properties";
		try {
//			InputStream in = new FileInputStream(new File(path));
			InputStream in = new DbcpSql().getClass().getClassLoader().getResourceAsStream(path);
			pps.load(in);
			DbcpSql.bd = BasicDataSourceFactory.createDataSource(pps);
		} catch (IOException e) {
			System.err.println("�ļ���ȡʧ�ܣ�");
		} catch (Exception e) {
			System.err.println("��������ʧ�ܣ�");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Connection con = bd.getConnection();
		
		String sql = "select * from user";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		
		while (rSet.next()){
			System.out.println("���ݴ�ӡ  name: " + rSet.getString("name") + " money: " + rSet.getFloat("money"));
		}
	}
}
