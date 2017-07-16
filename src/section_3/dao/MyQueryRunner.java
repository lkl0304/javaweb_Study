package section_3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

import section_2.jdbc.test.util.JdbcUtils;

public class MyQueryRunner {
	
	public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) {
		Connection connection = JdbcUtils.getConnect();
		PreparedStatement pre = null;
		ResultSet re = null;
		try {
			pre = connection.prepareStatement(sql);
			for (int i = 0; params != null && i < params.length; i++) {
				pre.setObject(i + 1, params[i]);
			}
			re = pre.executeQuery();
			T obj = rsh.handle(re); // ´¦Àí
			return obj;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.myclose(pre, connection, re);
		}
		return null;
	}
}
