package section_3.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import section_3.dao.MyQueryRunner;
import section_3.entity.User;

public class TestResultSetHandler {
	public static void main(String[] args) throws SQLException {
		MyQueryRunner mqr = new MyQueryRunner();
		String sql = "select * from user";
		// arrayhandler
		Object[] arr = mqr.query(sql, new ArrayHandler());
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// arraylisthandler 
		List<Object[]> list = mqr.query(sql, new ArrayListHandler());
		for (Object[] obj : list) {
			for (int i = 0; i < obj.length; i++) {
				System.err.println(obj[i]);
			}
		}
		
		// beanhandler 
		User user = mqr.query(sql, new BeanHandler<>(User.class));
		System.out.println(user.getId() + "  " + user.getName() + "  " + user.getMoney());
		
		// beanlisthandler
		ArrayList<User> list2 = (ArrayList<User>) mqr.query(sql, new BeanListHandler<>(User.class));
		for (User u : list2){
			System.err.println(u.getId() + "  " + u.getName() + "   " + u.getMoney());
		}
		
		// beanmaphandler
		Map<Integer, User> map = mqr.query(sql, new BeanMapHandler<>(User.class));
		for(int i = 0; i < map.size(); i++){
			System.out.println(map.get(i+1).getId() + "  " + map.get(i+1).getName() + "  " + map.get(i+1).getMoney());
		}
		
		// maphandler
		Map map2 = mqr.query(sql, new MapHandler());
		System.err.println(map2);
		
		// maplisthandler
		List list3 = mqr.query(sql, new MapListHandler());
		System.out.println(list3);
		for(int i = 0; i < list3.size(); i++){
			Map map3 = (Map) list3.get(i);
			System.err.println(map3.get("Id") + "  " + map3.get("name") + "  " + map3.get("money"));
		}
	}
}
