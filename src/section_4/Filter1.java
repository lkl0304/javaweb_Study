package section_4;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/Filter1")
public class Filter1 implements Filter {
	// ͨ������������ʵ��ͨ��cookie�Զ�����session ���û��Զ���¼
	
    public Filter1() {
    	super();
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.getWriter().write("hello filter");
		chain.doFilter(request, response); // �ڴ˴����� ���û�չʾ���� 
		// ��������ӵ����ݿɶԴ�ҳ�淵�ص����ݽ��й���
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}
}
