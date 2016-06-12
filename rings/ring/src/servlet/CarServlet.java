package servlet;

import java.awt.Button;
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
import net.ring.dao.impl.OrderDaoImpl;
import net.ring.dao.impl.RingDaoImpl;
import net.ring.dao.impl.UserDaoImpl;

public class CarServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		
		String flag = request.getParameter("flag");//购买的数量
		String flag1 = request.getParameter("flag1");//戒指对应的image
		String flag2 = request.getParameter("flag2");//戒指对应的尺寸
		int size=Integer.parseInt(flag2);
		
		
		RingDaoImpl ringDaoImpl = new RingDaoImpl();
		Ring ring = ringDaoImpl.findSpecialRing(flag1);//通过戒指对应的image获取该戒指
		
		ringDaoImpl.insertRingSize(size,ring.getRingId());//将购买的尺寸插进ring表里面
		
		
		HttpSession session = request.getSession();//下面以及这里是得到登录的用户，然后将用户对象封装
		String username = (String) session.getAttribute("UserName");
		String pwd = (String) session.getAttribute("Pwd");
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		int userid = userDaoImpl.findUserId(username, pwd);
		
		session.setAttribute("buynum", flag);//设置购买的数量，然后在结账servlet里面获取，再在jsp页面获取
		//Users user = new Users();
		//user.setUserName(username);
		//user.setPwd(pwd);
		
		//System.out.println("名字"+username);
		//System.out.println("密码"+pwd);
		
		
		Buy buy = new Buy();
		buy.setBuyNum(Integer.parseInt(flag));
		//System.out.println("buynum: "+Integer.parseInt(flag));
		buy.setRingId(ring.getRingId());
		//System.out.println("ringid: "+ring.getRingId());
		buy.setUserId(userid);
		//System.out.println("userid: "+userid);
		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();
		int orderid=orderDaoImpl.findLastOrderId();
		
		buy.setOrderId(orderid);
		buy.setBuySize(size);
		
		BuyDaoImpl buyDaoImpl = new BuyDaoImpl();
		Boolean temp = buyDaoImpl.addBuy(buy);
		//System.out.println(temp);//打印buy加入是否成功
		//BuyDaoImpl buyDaoImpl = new BuyDaoImpl();
		//ArrayList<Buy> arrayList = buyDaoImpl.findAllBuy();
		//session.setAttribute("arrayList", arrayList);
		//System.out.println(arrayList.get(1).getBuySize());
		//ArrayList<Buy> arrayList = buyDaoImpl.findAllBuy();
		//session.setAttribute("arrayList", arrayList);
		//System.out.println(arrayList.get(0).getBuyNum());
		
		//System.out.println(buyDaoImpl.countBuyCord());
		//System.out.println(buyDaoImpl.findAllBuy().get(1).getBuySize()+" 尺寸");
		//session.setAttribute("ring", ring);
		//request.setAttribute("ring", ring);----------------
		//Ring ring2 = (Ring) session.getAttribute("ring");//这里是得到jiehunservlet的session的ring
		//session.setAttribute("ring", ring2);
		//response.sendRedirect("shangpinxiangqing.jsp?tag="+temp+"");
		request.getRequestDispatcher("shangpinxiangqing.jsp?tag="+temp+"").forward(request, response);
		//System.out.println(username+" "+pwd);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
