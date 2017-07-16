package section_2.c3p0.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
// ʹ��c3p0��������Դ
public class C3p0sql {
	public static DataSource ds = null;
	
	// ֱ�Ӵ���
//	static{
//		ComboPooledDataSource cds = new ComboPooledDataSource();
//		
//		try {
//			cds.setDriverClass("com.mysql.jdbc.Driver");
//			cds.setJdbcUrl("jdbc:mysql://localhost:3306/sw?characterEncoding=gbk");
//			cds.setUser("root");
//			cds.setPassword("root");
//			
//			cds.setInitialPoolSize(5);
//			cds.setMaxPoolSize(15);
//			
//			C3p0sql.ds = cds;
//		} catch (PropertyVetoException e) {
//			e.printStackTrace();
//		}
//	}
	// �����ļ�����
	static {
		ComboPooledDataSource cbs = new ComboPooledDataSource();
		C3p0sql.ds = cbs;
	}
	public static void main(String[] args) throws SQLException {
		Connection con = ds.getConnection();
		
		String sql = "select * from user";
		
		PreparedStatement pStatement = con.prepareStatement(sql);
		ResultSet rSet = pStatement.executeQuery();
		
		while (rSet.next()){
			System.out.println("���ݴ�ӡ  name: " + rSet.getString("name"));
		}
	}
}
