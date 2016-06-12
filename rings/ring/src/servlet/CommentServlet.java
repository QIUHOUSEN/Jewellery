package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.ring.dao.impl.CommentDaoImpl;
import net.ring.dao.impl.UserDaoImpl;
import bean.Comment;
import bean.Users;

/**
 * Servlet implementation class CommentServlet
 */
//@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        
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

		request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		
		String Ringid = request.getParameter("hidringid");
		int ringid = Integer.parseInt(Ringid);
		//System.out.println(ringid);
		String pinlun = request.getParameter("pinlun");
		//System.out.println(pinlun);
		HttpSession session = request.getSession();
		Users user = new Users();
		user=(Users) session.getAttribute("user");
		//System.out.println(user.getUserName());
		UserDaoImpl userdao = new UserDaoImpl();
		int userid = userdao.findUserId(user);
		String name = user.getUserName();
		Comment com = new Comment();
		com.setContent(pinlun);
		com.setRingId(ringid);
		com.setUserId(userid);
		System.out.println(userid+" "+ringid);
		CommentDaoImpl comdao = new CommentDaoImpl();
		comdao.addComment(com);
		
		
		ArrayList<Comment> list = new ArrayList();
		list = comdao.findComment(ringid);
		request.setAttribute("ringid", ringid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("pinlun.jsp").forward(request, response);
	}

}
