package net.ring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Buy;
import bean.Comment;
import bean.OrderList;
import bean.Orders;
import bean.Ring;
import bean.Users;

//by 杨后青
public class AdminListDao {
	
	/**
	 * 驱动类名称
	 */
	private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	/**
	 * 数据库连接字符串
	 */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ring";
	
	/**
	 * 数据库用户名
	 */
	private static final String USER_NAME = "root";
	
	/**
	 * 数据库密码
	 */
	private static final String PASSWORD = "qiu";
	
	/**
	 * 数据库连接类
	 */
	private static Connection conn;
	
	/**
	 * 数据库操作类
	 */
	private static Statement stmt;
	
	
	
	// 加载驱动
	static{
		try {
			Class.forName(DRIVER_CLASS);
		} catch (Exception e) {
			System.out.println("加载驱动错误");
			System.out.println(e.getMessage());
		}
	}
	
	// 取得连接
	private static Connection getConnection(){
		
		try {
			conn = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("取得连接错误");
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	
	public void ExecuteDel(String sql){
		//System.out.println("1234565");
		
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
		}
		
		try {
			int rows = stmt.executeUpdate(sql);
			//System.out.println("1234565");
			//System.out.println(sql);
			//System.out.println("一共有"+rows+"行");
			if(rows >= 1){
				System.out.println("成功删除.....");
				
			} else {
				System.out.println("删除失败.....");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	//遍历用户列表
	public ArrayList<Users> getUserList(String sql){
		
		ArrayList<Users> list = new ArrayList<Users>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int UserId = rs.getInt(1);
				
				// 第2列 sname
				String UserName = rs.getString(2);
				
				
				Users stu = new Users();
				stu.setUserId(UserId);
				stu.setUserName(UserName);
				
				
				list.add(stu);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	//遍历评论列表
   public ArrayList<Comment> getCommentList(String sql){
		
		ArrayList<Comment> list = new ArrayList<Comment>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int CommentId = rs.getInt(1);
				int RingId = rs.getInt(2);
				int UserId = rs.getInt(3);
				String Content = rs.getString(4);
				
				
				Comment comment = new Comment();
				comment.setCommentId(CommentId);
				comment.setRingId(RingId);
				comment.setUserId(UserId);
				
				comment.setContent(Content);
				
				
				list.add(comment);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	//遍历所有商品列表
   public ArrayList<Ring> getRingList(String sql){
		
		ArrayList<Ring> list = new ArrayList<Ring>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int RingId = rs.getInt(1);
				String RingImage = rs.getString(2);
				
				Ring ring = new Ring();
				ring.setRingId(RingId);
				ring.setRingImage(RingImage);
				
				list.add(ring);
				//System.out.println("rs.getString(RingImage)");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
   
 //遍历Order表列表
   /*
    public ArrayList<Orders> getOrderList(String sql){
		
		ArrayList<Orders> list = new ArrayList<Orders>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int OrderId = rs.getInt(1);
				int UserId = rs.getInt(2);
				int OrderAllPrice = rs.getInt(3);
				
				Orders order = new Orders();
				order.setOrderId(OrderId);
				order.setUserId(UserId);
				order.setOrderAllPrice(OrderAllPrice);
				
				list.add(order);
				//System.out.println("rs.getString(RingImage)");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
 //遍历buy表列表
   public ArrayList<Buy> getbuyList(String sql){
		
		ArrayList<Buy> list = new ArrayList<Buy>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int BuyId = rs.getInt(1);
				int UserId = rs.getInt(2);
				int RingId = rs.getInt(3);
				int OrderId = rs.getInt(4);
				int BuyNum = rs.getInt(5);
				
				Buy buy = new Buy();
				buy.setBuyId(BuyId);
				buy.setUserId(UserId);
				buy.setRingId (RingId );
				buy.setOrderId(OrderId);
				buy.setBuyNum(BuyNum);
				
				list.add(buy);
				//System.out.println("rs.getString(RingImage)");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
 //遍历ring表列表
   public ArrayList<Ring> getringList(String sql){
		
		ArrayList<Ring> list = new ArrayList<Ring>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				// 第一列 sno
				int RingId = rs.getInt(1);
				int Price = rs.getInt(2);
				int SaleNum = rs.getInt(3);
				String Weight = rs.getString(4);
				String Color = rs.getString(5);
				String Clean = rs.getString(6);
				String Cut = rs.getString(7);
				String Quality = rs.getString(8);
				String Size = rs.getString(9);
				String RingImage = rs.getString(10);
				int CommentNum = rs.getInt(11);
				
				Ring ring = new Ring();
				ring.setRingId(RingId);
				ring.setPrice(Price);
				ring.setSaleNum (SaleNum );
				ring.setWeight(Weight);
				ring.setColor(Color);
				ring.setClean(Clean);
				ring.setCut(Cut);
				ring.setQuality (Quality );
				ring.setSize(Size);
				ring.setRingImage(RingImage);
				ring.setCommentNum(CommentNum);
				
				list.add(ring);
				//System.out.println("rs.getString(RingImage)");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
   */
   //遍历OrderList表
   public ArrayList<OrderList> getOrderList(String sql){
		
		ArrayList<OrderList> list = new ArrayList<OrderList>();
		
		// 取得数据库操作对象
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			System.out.println("statement取得错误");
			System.out.println(e.getMessage());
			return null;
		}
		
		try {
			
			// 查询数据库对象,返回记录集(结果集)
			ResultSet rs = stmt.executeQuery(sql);
			
			// 循环记录集，查看每一行每一列的记录
			while (rs.next()) {
				//System.out.println("111111111111111");
				// orders表
				//int orders_OrderId = rs.getInt("OrderId");
				//int orders_UserId = rs.getInt("UserId");
				int OrderAllPrice = rs.getInt("OrderAllPrice");
				//ring表
				//int ring_RingId = rs.getInt("RingId");
				int Price = rs.getInt("Price");
				//int SaleNum=rs.getInt("SaleNum");
				String Weight = rs.getString("Weight");
				String Color = rs.getString("Color");
				String Clean = rs.getString("Clean");
				String Cut = rs.getString("Cut");
				String Quality = rs.getString("Quality");
				String Size = rs.getString("Size");
				String RingImage = rs.getString("RingImage");
				//int CommentNum = rs.getInt("CommentNum");
				//buy表
				//int buy_BuyId = rs.getInt("BuyId");
				int buy_UserId = rs.getInt("UserId");
				int buy_RingId = rs.getInt("RingId");
				int buy_OrderId = rs.getInt("OrderId");
				int BuyNum = rs.getInt("BuyNum");
				
				
				//order表
				OrderList orderlist = new OrderList();
				
			//	orderlist.setOrders_OrderId(orders_OrderId);
			//	orderlist.setOrders_UserId(orders_UserId);
				orderlist.setOrderAllPrice(OrderAllPrice);
                //ring表
				
				//orderlist.setRing_RingId(ring_RingId);
				orderlist.setPrice(Price);
				//System.out.println("111111111111111");
				//orderlist.setSaleNum(SaleNum);
				orderlist.setWeight(Weight);
				orderlist.setColor(Color);
				orderlist.setClean(Clean);
				orderlist.setCut(Cut);
				orderlist.setQuality (Quality );
				orderlist.setSize(Size);
				orderlist.setRingImage(RingImage);
				//orderlist.setCommentNum(CommentNum);
				//buy表
				
				//orderlist.setBuy_BuyId(buy_BuyId);
				orderlist.setBuy_UserId(buy_UserId);
				orderlist.setBuy_RingId (buy_RingId );
				orderlist.setBuy_OrderId(buy_OrderId);
				orderlist.setBuyNum(BuyNum);
				
				
				
				list.add(orderlist);
				//System.out.println("rs.getString(RingImage)");
				
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}
	public static void main(String[] a){
		 /*DBConnection dbhelper=new DBConnection();
		 System.out.println("成功获得连接:"+dbhelper.getConnection());
		 String sql = "delete from student where Sno = '11001'";
		 DBConnection db = new DBConnection();
	     db.ExecuteDel(sql);*/
	   }
}

