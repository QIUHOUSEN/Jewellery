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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.Buy;
import bean.Comment;
import bean.OrderList;
import bean.Orders;
import bean.Ring;
import bean.Users;

import net.ring.dao.AdminListDao;
//by 杨后青
public class AdminAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flag=request.getParameter("flag");
		System.out.println("收到！");
		AdminListDao db = new AdminListDao();
		
		if(flag.equals("1")){
		String sql = "select * from users";
		ArrayList<Users> list = db.getUserList(sql);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/UserList.jsp").forward(request, response);
		}
		
		if(flag.equals("2")){
			String sql = "select * from comment";
			ArrayList<Comment> list = db.getCommentList(sql);
			request.setAttribute("list", list);
			request.getRequestDispatcher("admin/CommentList.jsp").forward(request, response);
			
			
		}
		if(flag.equals("3")){
			String sql="select RingId,RingImage from ring";
			ArrayList<Ring> list=db.getRingList(sql);
			request.setAttribute("list", list);
			//request.getRequestDispatcher("admin/RingList.jsp").forward(request, response);
			//取得新戒指的ID号
			String s="select Newringid from newring";
			int ID[]=new int[100];
			Connection con=Dbutil.getConnection();
			//System.out.println("法定哈桑及罚款是浪费!");
			PreparedStatement ps=null;
			try {
				ps=(PreparedStatement) con.prepareStatement(s);
				ResultSet rs = ps.executeQuery();
				//rs.last();
				
				int i=0;
				while(rs.next()){
					ID[i++]=rs.getInt("Newringid");
				}
				rs.last();
				int row=rs.getRow();
				request.setAttribute("IDs",ID );
				request.setAttribute("len",row);
				request.getRequestDispatcher("admin/RingList.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(flag.equals("4")){
			//System.out.println("123456789");
			String userid = request.getParameter("userid");
			System.out.println(userid+"=============");
			String sql="select buy.OrderId,buy.UserId,buy.RingId,RingImage,Weight,Color,Clean,Cut,Quality,Size,Price,BuyNum,OrderAllPrice from ring.buy join orders on buy.OrderId=orders.OrderId join ring on buy.RingId=ring.RingId where buy.UserId = '"+userid+"' and BuyStatus="+1+"";
			ArrayList<OrderList> list=db.getOrderList(sql);
			request.setAttribute("list", list);
			//System.out.println("123456789");
			request.getRequestDispatcher("admin/OrderList.jsp").forward(request, response);
		}
		
		
		
	     
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

	

}
