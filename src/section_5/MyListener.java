package section_5;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener, ServletContextListener, ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("request被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request被创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("context被销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("context被创建");
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session被销毁");
	}
	
}
