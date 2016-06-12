package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ring.dao.RingDao;

import net.ring.dao.impl.RingDaoImpl;

import util.Dbutil;

import bean.Ring;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ShangjiaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShangjiaServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int selectID=Integer.parseInt(request.getParameter("ID"));
		System.out.println("新添加的戒指ID号:"+selectID);
		Connection con=Dbutil.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Ring Newring=new Ring();
		String s="select * from newring where Newringid='"+selectID+"'"; 
		
		try {
			ps=(PreparedStatement) con.prepareStatement(s);
			rs = ps.executeQuery();
			if(rs.next()){
				Newring.setClean(rs.getString("Clean"));
				Newring.setColor(rs.getString("Color"));
				Newring.setCommentNum(rs.getInt("commentNum"));
				Newring.setCut(rs.getString("Cut"));
				Newring.setPrice(Integer.parseInt(rs.getString("Price")));
				Newring.setQuality(rs.getString("Quality"));
				Newring.setRingImage(rs.getString("RingImage"));
				Newring.setSaleNum(rs.getInt("SaleNum"));
				Newring.setSize(rs.getInt("Size"));
				Newring.setWeight(rs.getString("Weight"));
			}
			RingDao ring=new RingDaoImpl();
			System.out.println(ring.addRing(Newring,"ring"));
			System.out.println(ring.delRing(selectID,"newring","Newringid"));
			request.getRequestDispatcher("AdminAction?flag=3").forward(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		this.doGet(request, response);
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
