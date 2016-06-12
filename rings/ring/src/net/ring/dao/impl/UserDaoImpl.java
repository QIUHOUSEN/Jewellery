package net.ring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import util.Dbutil;

import bean.Users;
import net.ring.dao.UserDao;

public class UserDaoImpl implements UserDao{
	Connection con=Dbutil.getConnection();
	
	public Boolean addUser(Users user) {
		// TODO Auto-generated method stub
		String username=user.getUserName();
		String pwd=user.getPwd();
		String sql="insert into users(UserName,Pwd) values(?,?)";
		String[] temp={username,pwd};
		Dbutil.executeUpdate(sql, temp);
		return true;
	}

	public Boolean deleteUser(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Users> FindALLUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean checkRegister(Users user) {
		// TODO Auto-generated method stub
		String sql="select *from users";
		ResultSet rs=null;
		PreparedStatement ps=null;
		//ArrayList<Users> list=null;
		
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("UserName").equals(user.getUserName())){
					return true;
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public Boolean checkLogin(Users user) {
		// TODO Auto-generated method stub
		String sql="select *from users";
		ResultSet rs=null;
		PreparedStatement ps=null;
		//ArrayList<Users> list=null;
		
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				if(rs.getString("UserName").equals(user.getUserName()) && rs.getString("Pwd").equals(user.getPwd())){
					return true;
				}
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	public int findUserId(String UserName, String Pwd) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs;
		int id = 0;
		String sql="select *from users where UserName='"+UserName+"' and Pwd='"+Pwd+"'";
		try {
			ps=(PreparedStatement) con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				id = rs.getInt("UserId");
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return id;
	}

	public int findUserId(Users user) {
		String pwd = user.getPwd();
		String sql = "select * from users where Pwd="+pwd;
		int userid = 0;
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				userid = rs.getInt("UserId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userid;
	}
	
}
