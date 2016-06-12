package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ring.dao.impl.BuyDaoImpl;
import net.ring.dao.impl.RingDaoImpl;

import bean.Buy;
import bean.Ring;

public class JieHunServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = response.getWriter();
		
		
		String flag = request.getParameter("flag");
		RingDaoImpl ringDaoImpl = new RingDaoImpl();
		Ring ring=ringDaoImpl.findSpecialRing(flag);
		//System.out.println(ring.getRingImage());
		HttpSession session = request.getSession();
		session.setAttribute("ring", ring);
		//request.setAttribute("ring", ring);
		//request.getRequestDispatcher("shangpinxiangqing.jsp").forward(request, response);
		//response.setCharacterEncoding("UTF-8");
		
		
		response.sendRedirect("shangpinxiangqing.jsp");
		
		//System.out.println(ring.getRingImage()+"  "+ring.getClean());
		
		//System.out.println(flag);
		//pw.write(flag);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
