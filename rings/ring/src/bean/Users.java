package bean;
/*用户
 * */
//by @邱厚森
public class Users {
	private int UserId;//用户Id
	private String UserName;//用户名字
	private String Pwd;//用户密码
	

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	
}
