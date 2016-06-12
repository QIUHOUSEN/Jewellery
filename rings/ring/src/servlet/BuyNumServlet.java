package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ring.dao.BuyDao;
import net.ring.dao.impl.BuyDaoImpl;

/**
 * Servlet implementation class BuyNumServlet
 */
//@WebServlet("/BuyNumServlet")
public class BuyNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyDao buydao = new BuyDaoImpl();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		map = buydao.findBuyNumber();
	    Set<Integer> keys = map.keySet();
	    int num[] = new int[keys.size()];
	    int i = 0;
		 for(Integer key:keys){
			num[i] = map.get(key);
			i++;
		 }
		 request.setAttribute("buynum", num);
		 request.getRequestDispatcher("jiehun.jsp").forward(request, response);
	}

}
