package section_3.test;

import java.util.List;

import section_3.dao.BaseDao;
import section_3.entity.User;

public class ZsgcTest {
	private static BaseDao dao = new BaseDao();
	public static void main(String[] args) {
		List<User> list = null;
		// 增加
		User user = new User();
		user.setName("oooo");
		user.setMoney(2000);
		if(dao.myQuery("name='oooo'") == null){
			if(dao.myUpdate("insert", user)){
				System.out.println("添加成功！");
			}
		}
		
		// 查询
		list = dao.myQuery();
		for(User u : list){
			System.out.println(u.getName() + "  " + u.getMoney());
		}
		
		
	}
}
