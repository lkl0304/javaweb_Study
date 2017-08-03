package section_5;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionBindListener implements HttpSessionBindingListener{
	// 数据被实例化后 存入session 和 从session中删除的监听
	
	private String name;
	private String pass;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// 存入监听  可以做在线用户人数统计
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// 删除监听
		
	}

}
