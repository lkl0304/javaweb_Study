package section_2.myds.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

public class Test {
	public static void main(String[] args) throws SQLException {
		MyDataSource ds = new MyDataSource();
		LinkedList<Connection> pool = ds.getPool();
		
		System.out.println(pool.size());
		
		Connection mc = ds.getConnection();
		
		System.out.println(pool.size());
		
		mc.close();
		
		System.out.println(pool.size());
	}
}
