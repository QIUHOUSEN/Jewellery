package servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomNum extends HttpServlet {

	
	private static final int WIDTH=115;
	private static final int HEIGHT=25;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
		Graphics g=image.getGraphics();
		
		
		setBackGround(g);
		
	
		setBorder(g);
		
		
		drawRandomLine(g);
		
		
		String str = drawRandomNum1((Graphics2D) g);
		request.getSession().setAttribute("randomnum", str);
		
	
		response.setContentType("image/jpeg");
		
		response.setDateHeader("expries", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		
		response.setHeader("refresh", "3");
		
		ImageIO.write(image, "jpg", response.getOutputStream());
		
		
	}

	private String drawRandomNum1(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.setFont(new Font("宋体",Font.BOLD,15));
		String base="\u7684\u4e00\u4e86\u6211\u4e0d";//设置出现的常用字
		int x=5;
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<4;i++){
		
			String str=base.charAt(new Random().nextInt(base.length()))+"";
			sb.append(str);
			
			
			int degree = (new Random().nextInt())%30;
			
			g.rotate(degree*Math.PI/180, x, 20);
			g.drawString(str, x, 20);
			
			g.rotate(-degree*Math.PI/180, x, 20);
			x=x+30;
		}
		return sb.toString();
		
		
	}

	private void setBackGround(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
	}

	private void setBorder(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.blue);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
		
	}
	
	private void drawRandomLine(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		for(int i=0;i<8;i++){
			int x1=new Random().nextInt(WIDTH);
			int x2=new Random().nextInt(WIDTH);
			
			int y1=new Random().nextInt(HEIGHT);
			int y2=new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
		
	}


	
	private void drawRandomNum(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.setFont(new Font("宋体",Font.BOLD,20));
		String base="\u7684\u4e00\u4e86\u6211\u4e0d";
		int x=5;
		for(int i=0;i<4;i++){
			
			 String str=base.charAt(new Random().nextInt(base.length()))+"";
			 g.drawString(str, x, 20);
			 x=x+25;
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
