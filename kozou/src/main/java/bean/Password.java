package bean;

public class Password implements java.io.Serializable {
	
	private String password;
	private String hashWord;
	private String salt;
	
	public String getPassword() {
		return password;
	}
	public String getHashWord() {
		return hashWord;
	}
	public String getSalt() {
		return salt;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setHashWord(String hashWord) {
		this.hashWord = hashWord;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
}
