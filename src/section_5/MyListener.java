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
		System.out.println("request������");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		System.out.println("request������");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("context������");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("context������");
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session������");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session������");
	}
	
}
