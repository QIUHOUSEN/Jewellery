package net.ring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.Dbutil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import bean.Buy;
import bean.Ring;
import bean.Users;
import net.ring.dao.BuyDao;

public class BuyDaoImpl implements BuyDao{
	Connection con=Dbutil.getConnection();
	
	public Boolean addBuy(Ring ring, Users users) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addBuy(Buy buy) {
		// TODO Auto-generated method stub
		int buynum = buy.getBuyNum();
		int ringid = buy.getRingId();
		int userid = buy.getUserId();
		int orderid = buy.getOrderId();
		int ringSize = buy.getBuySize();
		//System.out.println(buynum+" "+ringid+" "+userid+" "+orderid);
		String sql="insert into buy(UserId,RingId,OrderId,BuyNum,BuySize) values("+userid+","+ringid+","+orderid+","+buynum+","+ringSize+")";
		//String[] temp={userid,ringid,buynum};
		PreparedStatement ps;
		
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//try {
			//con.close();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		return true;
	}

	public int countBuyCord() {
		// TODO Auto-generated method stub
		String sql="select * from buy";
		int i=0;
		PreparedStatement ps=null;
		
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.last();
			i=rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
		/*PreparedStatement ps=null;
		ResultSet rs=null;
		int i=0;
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
			}
			rs.last();
			i=rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;*/
	}

	public ArrayList<Buy> findAllBuy(Users users) {
		// TODO Auto-generated method stub
		String sql="select * from buy where UserId="+users.getUserId()+" and BuyStatus="+0+"";
		ArrayList<Buy> arrayList = new ArrayList<Buy>();
	
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Buy buy = new Buy();
				buy.setBuyId(rs.getInt("BuyId"));
				buy.setUserId(rs.getInt("UserId"));
				buy.setRingId(rs.getInt("RingId"));
				buy.setOrderId(rs.getInt("OrderId"));
				buy.setBuyNum(rs.getInt("BuyNum"));
				buy.setBuySize(rs.getInt("BuySize"));
				arrayList.add(buy);			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrayList;
	}

	public Boolean deleteBuy(int BuyId) {
		// TODO Auto-generated method stub
		String sql="delete from buy where BuyId="+BuyId+"";
		PreparedStatement ps=null;
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}



	public Map<Integer,Integer> findBuyNumber() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		String sql = "select * from ring";
		//con = DBUtil.getconConnection();
		int Rid[]= new int[100];
		int i=0;
		int length=0;
		String sql2;
		
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Rid[i] = rs.getInt("RingId");
				length = ++i;
			}
			for(int n=0;n<length;n++){
				sql2 = "select * from buy where RingId="+Rid[n];
				PreparedStatement ps2 = (PreparedStatement) con.prepareStatement(sql2);
				ResultSet rs2 = ps2.executeQuery();
				int number=0;
				while(rs2.next()){
					number = number+rs2.getInt("BuyNum");
				}
				map.put(Rid[n], number);
			}
			
			/* Set<Integer> keys = map.keySet();
			 
			 for(Integer key:keys){
				 System.out.println("键："+key+"  "+"值："+map.get(key).intValue());
			 }*/
			

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return map;
		
	}

	public void updateBuyStatus(Users users) {
		// TODO Auto-generated method stub
		String sql="update buy set BuyStatus="+1+" where UserId="+users.getUserId()+"";
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
