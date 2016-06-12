package net.ring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.crypto.spec.PSource;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import util.Dbutil;

import bean.Orders;
import bean.Users;
import net.ring.dao.OrderDao;


public class OrderDaoImpl implements OrderDao{
	Connection con=Dbutil.getConnection();
	public ArrayList<Orders> findAllOrders(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean addOrder(ArrayList<Orders> orders, Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteOrder(int OrderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean addOrder(Orders orders) {
		// TODO Auto-generated method stub
		int userid=orders.getUserId();
		int allprice=orders.getOrderAllPrice();
		String sql="insert into orders(UserId,OrderAllPrice) values("+userid+","+allprice+")";
		PreparedStatement ps=null;
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public int findLastOrderId() {
		// TODO Auto-generated method stub
		String sql="select * from orders";
		int i = 0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Statement st= (Statement) con.createStatement();
			rs=st.executeQuery(sql);
			//ps=(PreparedStatement) con.prepareStatement(sql);
			//rs=ps.executeQuery();
			
			//i=rs.getInt("UserId");
			rs.last();
			i=rs.getInt("OrderId");
			//i=rs.getRow();
			//System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

}
