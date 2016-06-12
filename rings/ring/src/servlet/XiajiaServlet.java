package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Dbutil;

import bean.Ring;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.ring.dao.impl.RingDaoImpl;

public class XiajiaServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public XiajiaServlet() {
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
		
		int flag=Integer.parseInt(request.getParameter("flag").toString());
		if(flag!=0){
		int ID=flag;
		//int ID=Integer.parseInt(request.getParameter("ID"));
		System.out.println("下架的ID号:"+ID);
		Connection con=Dbutil.getConnection();
		String sql="select * from ring where RingId='"+ID+"'"; 
		PreparedStatement pst=null;
		ResultSet rs1=null;
		Ring ringjl=new Ring();
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs1 = pst.executeQuery();
			if(rs1.next())
			{
				ringjl.setClean(rs1.getString("Clean"));
				ringjl.setColor(rs1.getString("Color"));
				ringjl.setCommentNum(rs1.getInt("commentNum"));
				ringjl.setCut(rs1.getString("Cut"));
				ringjl.setPrice(Integer.parseInt(rs1.getString("Price")));
				ringjl.setQuality(rs1.getString("Quality"));
				ringjl.setRingImage(rs1.getString("RingImage"));
				ringjl.setSaleNum(rs1.getInt("SaleNum"));
				ringjl.setSize(rs1.getInt("Size"));
				ringjl.setWeight(rs1.getString("Weight"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RingDaoImpl deal=new RingDaoImpl();
		deal.delRing(ID, "ring","RingId");
		deal.addRing(ringjl, "newring");
		request.getRequestDispatcher("AdminAction?flag=3").forward(request, response);
		}
		PrintWriter out = response.getWriter();
		doPost(request,response);
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
		PrintWriter out = response.getWriter();
		
		
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
