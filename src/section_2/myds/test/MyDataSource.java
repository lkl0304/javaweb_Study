package section_2.myds.test;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import section_2.jdbc.test.util.JdbcUtils;

public class MyDataSource implements DataSource {
	private static LinkedList<Connection> pool = new LinkedList<>();
	
	static {
		for (int i = 0; i < 10; i++){
			pool.add(JdbcUtils.getConnect());
		}
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection connection = pool.pop();
		MyConnection mycon = new MyConnection(connection, pool);
		return mycon;
	}
	
	public LinkedList<Connection> getPool() {
		return pool;
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}
}
