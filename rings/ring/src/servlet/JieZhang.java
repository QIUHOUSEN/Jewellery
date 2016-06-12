package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Buy;
import bean.Ring;
import bean.Users;

import net.ring.dao.impl.BuyDaoImpl;
import net.ring.dao.impl.RingDaoImpl;
import net.ring.dao.impl.UserDaoImpl;

public class JieZhang extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		BuyDaoImpl buyDaoImpl = new BuyDaoImpl();
		
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		ArrayList<Buy> arrayList = buyDaoImpl.findAllBuy(user);
		
		session.setAttribute("arrayList", arrayList);
		//request.getRequestDispatcher("car.jsp").forward(request, response);
		//String buynum = (String) session.getAttribute("buynum");//从carservlet里面获取的
		//session.setAttribute("buynum", buynum);
		//System.out.println(arrayList.size());
		response.sendRedirect("car.jsp");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
