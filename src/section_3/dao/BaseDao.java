package section_3.dao;
/**
 * ʹ��DBUtilsʵ����ɾ�Ĳ���� 
 * 1. ����jar��commons-dbutils-1.6.jar
 * 2. ʹ�� ResultSetHandler�ӿ� �� QueryRunner��ʵ�ֲ���
 * 
 * @author ����С��
 */

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import section_3.entity.User;

public class BaseDao {
	private static DataSource dSource = null;
	private QueryRunner       qRunner = null;
	static {
		// ����Ĭ������
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		BaseDao.dSource = cpds;
	}
	
	public boolean myUpdate(String type, User user){
		qRunner = new QueryRunner(dSource);
		String sql = null;
		Object[] obj = null;
		switch (type) {
		case "insert":
			sql = "insert into user (name, money) values (?, ?)";
			obj = new Object[]{user.getName(), user.getMoney()};
			break;
		case "delete":
			sql = "delete from user where id=?";
			obj = new Object[]{user.getId()};
			break;
		case "update":
			sql = "update user set name=?, money=? where id=?";
			obj = new Object[]{user.getName(), user.getMoney(), user.getId()};
			break;
		}
		
		try {
			if(qRunner.update(sql, obj) > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<User> myQuery(String... str) {
		qRunner = new QueryRunner(dSource);
		String sql = "select * from user ";
		if (str.length > 0) {
			sql = sql + "where " + str[0];
		}
		try {
			List<User> list = qRunner.query(sql, new BeanListHandler<>(User.class));
			if (!list.isEmpty()){
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
