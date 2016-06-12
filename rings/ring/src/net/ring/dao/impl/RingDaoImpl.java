package net.ring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Dbutil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.Ring;
import net.ring.dao.RingDao;

public class RingDaoImpl implements RingDao{
	Connection con=Dbutil.getConnection();
	
	public int GetSalesNum(Ring ring) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	public ArrayList<Ring> findRing(Ring ring) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Boolean addRing(Ring ring,String table) {
		// TODO Auto-generated method stub
		boolean b=false;
		try {
			PreparedStatement pst=null;
			
			String sql = "insert into "+table+"(Price,SaleNum,Weight,Color,Clean,Cut,Quality,Size,RingImage,CommentNum)" +
					" values (?,?,?,?,?,?,?,?,?,?)";
			    //System.out.println(sql);
			    pst=(PreparedStatement) con.prepareStatement(sql);
			    pst.setInt(1, ring.getPrice());
		    	pst.setInt(2, ring.getSaleNum());
		    	pst.setString(3, ring.getWeight());
		    	pst.setString(4, ring.getColor());
		    	pst.setString(5, ring.getClean());
		    	pst.setString(6, ring.getCut());
		    	pst.setString(7, ring.getQuality());
		    	pst.setInt(8, ring.getSize());
		    	pst.setString(9, ring.getRingImage());
		    	pst.setInt(10, ring.getCommentNum());
		    	
				int a=pst.executeUpdate();
				if(a==1)
					b=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	
	public Boolean delRing(int ringID,String table,String id){
		String sql="delete from "+table+" where "+id+"="+ringID+"";
		System.out.println(sql);
		//ResultSet rs=null;
		//System.out.println("删除语句:"+sql);
		PreparedStatement pst=null;
		try {
			pst=(PreparedStatement) con.prepareStatement(sql);
			//rs = pst.executeQuery();
	    	int a=pst.executeUpdate();
			if(a==1) return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Ring findSpecialRing(String RingImage) {
		// TODO Auto-generated method stub
		String sql="select *from Ring where RingImage=N'"+RingImage+"'";
		ResultSet rs=null;
		PreparedStatement ps=null;
		Ring ring=new Ring();
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				ring.setClean(rs.getString("Clean"));
				ring.setColor(rs.getString("Color"));
				ring.setCut(rs.getString("Cut"));
				ring.setPrice(rs.getInt("Price"));
				ring.setQuality(rs.getString("Quality"));
				ring.setRingId(rs.getInt("RingId"));
				ring.setSaleNum(rs.getInt("SaleNum"));
				ring.setSize(rs.getInt("Size"));
				ring.setWeight(rs.getString("Weight"));
				ring.setRingImage(rs.getString("RingImage"));
				ring.setCommentNum(rs.getInt("CommentNum"));
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ring;
	}

	public boolean insertRingSize(int size, int ringId) {
		// TODO Auto-generated method stub
		//System.out.println(size);
		String sql="update ring set Size="+size+" where RingId="+ringId+"";
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public Ring findByRingId(int RingId) {
		// TODO Auto-generated method stub
		String sql="select * from ring where RingId="+RingId+"";
		Ring ring = new Ring();
		PreparedStatement ps= null;
		ResultSet rs= null;
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				
				ring.setClean(rs.getString("Clean"));
				ring.setColor(rs.getString("Color"));
				ring.setCut(rs.getString("Cut"));
				ring.setPrice(rs.getInt("Price"));
				ring.setQuality(rs.getString("Quality"));
				ring.setRingId(rs.getInt("RingId"));
				ring.setSaleNum(rs.getInt("SaleNum"));
				ring.setSize(rs.getInt("Size"));
				ring.setWeight(rs.getString("Weight"));
				ring.setRingImage(rs.getString("RingImage"));
				ring.setCommentNum(rs.getInt("CommentNum"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ring;
	}

	
}
