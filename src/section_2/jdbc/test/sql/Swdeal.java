package section_2.jdbc.test.sql;

import java.sql.Connection;
import java.sql.SQLException;
import section_2.jdbc.test.util.JdbcUtils;
import java.sql.PreparedStatement;

public class Swdeal {
	public static void main(String[] args) {
		String inUser  = "aaa";
		String outUser = "bbb";
		double change  = 200  ;
		
		Connection        con  = null;
		PreparedStatement pre1 = null;
		PreparedStatement pre2 = null;
		String sql1 = "update user set money=money-? where name=? and money>=200";
		String sql2 = "update user set money=money+? where name=?";
	
		try {
			con = JdbcUtils.getConnect();
			
			con.setAutoCommit(false);
			
			pre1 = con.prepareStatement(sql1);
			pre1.setDouble(1, change);
			pre1.setString(2, outUser);
			pre1.executeUpdate();
			
			pre2 = con.prepareStatement(sql2);
			pre2.setDouble(1, change);
			pre2.setString(2, inUser);
			pre2.executeUpdate();
					
			con.commit(); // 提交事务
			System.out.println("转账成功！");
		} catch (Exception e) {
			try {
				con.rollback();
				System.err.println("转账失败！");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (pre1 != null){
				try {
					pre1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pre1 = null;
			}
			if (pre2 != null){
				try {
					pre2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				pre2 = null;
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				con = null;
			}
		}
	}
}
