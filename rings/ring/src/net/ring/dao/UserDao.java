package net.ring.dao;
//by @邱厚森
import java.util.ArrayList;

import bean.Users;

/*改接口对应于数据库里的users表
 * 实现对用户的管理
 * 
 * */
public interface UserDao {
	public Boolean addUser(Users user);//增加用户
	public Boolean checkRegister(Users user);//验证该用户是否已经注册（已注册返回false否则true）
	public Boolean checkLogin(Users user);//验证登录是否成功（成功返回true否则false）
	public Boolean deleteUser(Users user);//删除用户
	public ArrayList<Users> FindALLUsers();//查询数据库中所有用户，并且返回到数组集合中
	public int findUserId(String UserName, String Pwd);
	//王静的
	public int findUserId(Users user);
	
}
