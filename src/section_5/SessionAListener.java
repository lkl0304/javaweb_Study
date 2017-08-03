package section_5;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionAListener implements HttpSessionActivationListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 数据固化和活化监听  需要实现Serializable才能被活化啥的 具体不能过理解 以后再研究
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
