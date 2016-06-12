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

import util.Dbutil;

import bean.Ring;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class NextPage extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NextPage() {
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
		
		
		Connection con=Dbutil.getConnection();
		ArrayList<Ring> list=new ArrayList<Ring>();
		String sql="select * from ring"; 
		PreparedStatement pst=null;
		ResultSet rs1=null;
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			rs1 = pst.executeQuery();
			int index=0;
			while(rs1.next())
			{
				index++;
				if(index>6){
				Ring ringjl=new Ring();
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
				list.add(ringjl);
				}
				else continue;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("List",list);
		/*
		Iterator<Ring> it=list.iterator();//迭代器指向集合
		while(it.hasNext()){//开始询问集合是否有元素
			Ring r = (Ring)it.next();//如果有，通过next方法取得元素
			System.out.println(r.getRingImage());
		}*/
		System.out.println("取得价钱:"+list.get(0).getPrice());
		
		for(int j=0;j<list.size();j++)
		{
			System.out.println(list.get(j).getRingImage());
		}
		request.setAttribute("List",list);
		request.getRequestDispatcher("Shangjia.jsp").forward(request, response);
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
