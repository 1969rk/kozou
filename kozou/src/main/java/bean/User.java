package bean;

public class User implements java.io.Serializable {
	
	private int userId;
	private String userName;
	private String loginId;
	private String password;
	private String salt;
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getLoginId() {
		return loginId;
	}
	public String getPasword() {
		return password;
	}
	public String getSalt() {
		return salt;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
