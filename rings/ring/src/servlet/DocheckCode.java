package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DocheckCode extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw=response.getWriter();
		
		HttpSession session1 = request.getSession();
		String clientCheck = (String) session1.getAttribute("clientCheck");
		System.out.println("客户端："+clientCheck);
		String serverCheck = (String) session1.getAttribute("randomnum");
		System.out.println("服务器端:"+serverCheck);
		if(clientCheck.equals(serverCheck)){
			response.sendRedirect("/ring/first_web.jsp");
		}
		/*if(clientCheck.equals("")){
			//pw.print("<script>alert('哈哈哈哈');</script>");
			//request.getRequestDispatcher("Login.jsp?tag=2").forward(request, response);
			response.sendRedirect("Login.jsp?tag=2");
		}*/
		if(!clientCheck.equals(serverCheck)){
			response.sendRedirect("Login.jsp?tag=2");
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
