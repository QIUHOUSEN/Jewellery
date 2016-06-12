package net.ring.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Dbutil;

import com.mysql.jdbc.Connection;

import bean.Comment;
import bean.Ring;
import bean.Users;
import net.ring.dao.CommentDao;

public class CommentDaoImpl implements CommentDao{
	Connection conn=null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public void addComment(Comment com) {
		String sql = "insert into comment(RingId,UserId,Content) values(?,?,?)";
		String content = com.getContent();
		int ringid = com.getRingId();
		int userid = com.getUserId();
		String parasm[] = {ringid+"",userid+"",content};
		Dbutil.executeUpdate(sql, parasm);
 	}
	public ArrayList<Comment> findComment(int ringid) {
		// TODO Auto-generated method stub
		ArrayList<Comment> list = new ArrayList();
		String sql = "select * from comment where RingId="+ringid;
		conn = (Connection) Dbutil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Comment com = new Comment();
				com.setCommentId(rs.getInt("CommentId"));
				com.setRingId(rs.getInt("RingId"));
				com.setUserId(rs.getInt("UserId"));
				com.setContent(rs.getString("Content"));
				
				list.add(com);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	public int findRingId(String flag) {
		// TODO Auto-generated method stub
		int ringid = 0;
		String sql = "select * from ring where RingImage=N'"+flag+"'";
		conn = (Connection) Dbutil.getConnection();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Ring ring = new Ring();
				ringid = rs.getInt("RingId");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return ringid;
	}
	

	/*public Boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	
}
