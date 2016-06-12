package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ring.dao.AdminListDao;

//by 杨后青
public class DelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//如果数据表中存在外键关系就删除不了
		String flag=request.getParameter("flag");
		AdminListDao db = new AdminListDao();
		/*if(flag.equals("1")){
		String userid = request.getParameter("userid");
		//在mysql中语句：delete from student where Sno = '3';
		String sql = "delete from users where UserId = '"+userid+"'";
		
		db.ExecuteDel(sql);
		//System.out.println(sql);
		//System.out.println("成功删除："+sno);
		request.getRequestDispatcher("AdminAction?flag=1").forward(request, response);
		
	  }*/
		
		if(flag.equals("1")){
			String userid = request.getParameter("userid");
			//在mysql中语句：delete from student where Sno = '3';
			String sql_buy="delete from buy where UserId = '"+userid+"'";
			String sql_orders="delete from orders where UserId = '"+userid+"'";
			String sql_comment="delete from comment where UserId = '"+userid+"'";
			String sql_users = "delete from users where UserId = '"+userid+"'";
			
			db.ExecuteDel(sql_buy);
			db.ExecuteDel(sql_orders);
			db.ExecuteDel(sql_comment);
			db.ExecuteDel(sql_users);
			//System.out.println(sql);
			//System.out.println("成功删除："+sno);
			request.getRequestDispatcher("AdminAction?flag=1").forward(request, response);
			
		  }
		
		if(flag.equals("2")){
			String commentid = request.getParameter("commentid");
			//在mysql中语句：delete from student where Sno = '3';
			String sql = "delete from comment where CommentId = '"+commentid+"'";
			db.ExecuteDel(sql);
			//System.out.println(sql);
			//System.out.println("成功删除："+sno);
			request.getRequestDispatcher("AdminAction?flag=2").forward(request, response);
			
		  }
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
		
	}

	
}
