package util;
//by @邱厚森
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Dbutil {
	
	public static Connection getConnection(){
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/zjwdb_547940";
		String userName="zjwdb_547940";
		String passWord="QHSwhm123";
		
		//下面这都是正常情况下本地的数据库连接
		//String url="jdbc:mysql://localhost:3306/ring";
		//String userName="root";
		//String passWord="qiu";
		//加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//得到连接
			con=(Connection) DriverManager.getConnection(url,userName,passWord);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//抽取一个方法：实现数据库的增 删 改(以后只要是增 删 改就用此方法)，只需传值
	public static void executeUpdate(String sql,String[] parasm){
		Connection con=null;
		con=getConnection();
		try {
			PreparedStatement ps= (PreparedStatement) ((java.sql.Connection) con).prepareStatement(sql);
			if(parasm!=null){
				for(int i=0;i<parasm.length;i++){
					ps.setString(i+1,parasm[i]);
				}
			}
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	
	}
	
}
