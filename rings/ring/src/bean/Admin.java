package bean;
//by @邱厚森
import javax.print.DocFlavor.STRING;
/*
 * 管理员
 * */
public class Admin {
	private int AdminId;//管理员ID
	private String AdminName;//管理员名字
	private String AdminPwd;//管理员密码
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	public String getAdminPwd() {
		return AdminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		AdminPwd = adminPwd;
	}
	
	
}
