package section_5;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class SessionBindListener implements HttpSessionBindingListener{
	// ���ݱ�ʵ������ ����session �� ��session��ɾ���ļ���
	
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
		// �������  �����������û�����ͳ��
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// ɾ������
		
	}

}
