package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Users;

public class CharactorFilter implements Filter {
	private String encoding=null;//编码格式
	public void destroy() {
		// TODO Auto-generated method stub
		encoding=null;
	}
	//将得到的encoding进行编码
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		Object users = session.getAttribute("user");
		System.out.println(users);
		
		if(users!=null){
			chain.doFilter(request, response);
		}
		if(users==null){
			res.sendRedirect("/ring/Login.jsp");
			//req.getRequestDispatcher("/Login.jsp").forward(req, res);
		}
		if(encoding!=null)
		{
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}
		
			 
	}
	//初始化操作，从配置文件中拿到初始化数据
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		 encoding=filterConfig.getInitParameter("encoding");
	}

}
