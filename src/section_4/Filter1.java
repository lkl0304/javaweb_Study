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
	// 通过过滤器可以实现通过cookie自动生成session 即用户自动登录
	
    public Filter1() {
    	super();
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		response.getWriter().write("hello filter");
		chain.doFilter(request, response); // 在此处放行 想用户展示界面 
		// 在下面添加的内容可对从页面返回的内容进行过滤
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}
}
