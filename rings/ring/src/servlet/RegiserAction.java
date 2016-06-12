package servlet;
//by @邱厚森
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ring.dao.impl.UserDaoImpl;

import bean.Users;

public class RegiserAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		String UserName = request.getParameter("user");//从jsp页面获取用户名
		String Pwd = request.getParameter("password");//从jsp页面获取密码
		//String Repwd = request.getParameter("pwdagain");
		Users user = new Users();
		user.setUserName(UserName);
		user.setPwd(Pwd);
		
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		Boolean checkRegister = userDaoImpl.checkRegister(user);//检查是否数据库里已经有了这个注册的人
		if(checkRegister==false){
			Boolean temp = userDaoImpl.addUser(user);
			if(temp==true){
				//为嘛没有图片
				request.getRequestDispatcher("Register.jsp?tag=1").forward(request, response);
				//response.sendRedirect("/ring/Register.jsp?tag=1");//这里给个1参数代表数据库没有此人，可以注册
			}
		}else{
			response.sendRedirect("/ring/Register.jsp?tag=2");//给个2代表库里有这个人了，不可以注册
		}
		
		
		//System.out.println(temp);
		//response.sendRedirect("/Register.jsp?tag=temp");
		//request.setAttribute("value", temp);
		//request.getRequestDispatcher("/Register.jsp").forward(request, response);
		//System.out.println(str);
		//pw.print(UserName+""+Pwd+""+Repwd);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
