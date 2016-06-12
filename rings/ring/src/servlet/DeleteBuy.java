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

import bean.Buy;
import bean.Users;

public class DeleteBuy extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		BuyDaoImpl buyDaoImpl = new BuyDaoImpl();
		HttpSession session = request.getSession();
		Users user=(Users) session.getAttribute("user");
		ArrayList<Buy> arrayList = buyDaoImpl.findAllBuy(user);
		
		
		String i = request.getParameter("flag");
		//String hidden=request.getParameter("shanchu");
		//System.out.println(hidden);
		//if(hidden.equals("sc")){
			int n=Integer.parseInt(i);
			if(i!=null){
				int buyid = arrayList.get(n).getBuyId();
				System.out.println("buyid"+buyid);
				Boolean boolean1 = buyDaoImpl.deleteBuy(buyid);
			}
		//}
		ArrayList<Buy> arrayList1 = buyDaoImpl.findAllBuy(user);
			
		
		session.setAttribute("arrayList", arrayList1);
		response.sendRedirect("car.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
