package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.ring.dao.impl.CommentDaoImpl;
import bean.Comment;

/**
 * Servlet implementation class PinLunServlet
 */
//@WebServlet("/PinLunServlet")
public class PinLunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PinLunServlet() {
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
		String flag = request.getParameter("flag");
		CommentDaoImpl comm = new CommentDaoImpl();
		int ringid = comm.findRingId(flag);
		ArrayList<Comment> list = new ArrayList();
		list = comm.findComment(ringid);
		request.setAttribute("ringid", ringid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("pinlun.jsp").forward(request, response);
		/*request.setCharacterEncoding("UTF-8");//设置从页面获取内容的编码
		response.setCharacterEncoding("UTF-8");//设置浏览器方面的编码，下同
		response.setContentType("text/html;charset=UTF-8");
		CommentDaoImpl comdao = new CommentDaoImpl();
		ArrayList<Comment> list = new ArrayList();
		list = comdao.findComment();
		request.setAttribute("list", list);
		request.getRequestDispatcher("pinlun.jsp").forward(request, response);*/
	}

}
