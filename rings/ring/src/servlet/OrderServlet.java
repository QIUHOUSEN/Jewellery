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
import net.ring.dao.impl.OrderDaoImpl;
import net.ring.dao.impl.UserDaoImpl;

import bean.Buy;
import bean.Orders;
import bean.Users;

public class OrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String allMoney = request.getParameter("flag");//OK
		//System.out.println(allMoney);
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		//System.out.println(user.getUserName()+" "+user.getPwd());
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userid = userDaoImpl.findUserId(user.getUserName(),user.getPwd());
		Orders orders = new Orders();
		orders.setUserId(userid);
		orders.setOrderAllPrice(Integer.parseInt(allMoney));
		
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		Boolean temp = orderDaoImpl.addOrder(orders);
		
		BuyDaoImpl buyDaoImpl = new BuyDaoImpl();
		buyDaoImpl.updateBuyStatus(user);
		
		//System.out.println(temp);
		
		//BuyDaoImpl buyDaoImpl = new BuyDaoImpl();	
	//	ArrayList<Buy> arrayList = buyDaoImpl.findAllBuy();
		
	//	HttpSession session2 = request.getSession();
	//	session.setAttribute("arrayList", arrayList);
		request.getRequestDispatcher("car.jsp?tag="+temp+"").forward(request, response);
		//response.sendRedirect("car.jsp?tag="+temp+"");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
