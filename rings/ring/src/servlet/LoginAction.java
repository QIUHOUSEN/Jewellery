package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ring.dao.impl.BuyDaoImpl;
import net.ring.dao.impl.UserDaoImpl;

import bean.Buy;
import bean.Users;

public class LoginAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		
		String UserName = request.getParameter("user");//从jsp页面获取用户名
		String Pwd = request.getParameter("password");//从jsp页面获取密码
		String clientCheck=request.getParameter("checkcode");
		
		
		Users user = new Users();
		user.setUserName(UserName);
		user.setPwd(Pwd);
		int userid= userDaoImpl.findUserId(UserName, Pwd);
		user.setUserId(userid);
		
		
		//王静的
		HttpSession session1 = request.getSession();
		session1.setAttribute("user", user);
		
		//UserDaoImpl userDaoImpl = new UserDaoImpl();
		Boolean checkLogin = userDaoImpl.checkLogin(user);
		if(checkLogin==true){
			HttpSession session = request.getSession();
			session.setAttribute("UserName", UserName);
			session.setAttribute("Pwd",Pwd);
			session.setAttribute("clientCheck", clientCheck);
			//String clientnum = request.getParameter("checkcode");//得到用户输入的校验码
			//String servernum = (String) request.getSession().getAttribute("randomnum");
			response.sendRedirect("/ring/DocheckCode");
			//response.sendRedirect("/ring/first_web.jsp");
		}else{
			request.getRequestDispatcher("Login.jsp?tag=1").forward(request, response);
			//System.out.println("不嫩刚登陆");
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
