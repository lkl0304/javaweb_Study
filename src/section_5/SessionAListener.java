package section_5;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class SessionAListener implements HttpSessionActivationListener, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// ���ݹ̻��ͻ����  ��Ҫʵ��Serializable���ܱ��ɶ�� ���岻�ܹ���� �Ժ����о�
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
