package domain;

import java.sql.Timestamp;

public class User {
	private int uid;
	private String email;
	private String password;
	private String username;
	private String gender;
	private Timestamp registerDate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int uid, String email, String password, String username,
			String gender, Timestamp registerDate) {
		super();
		this.uid = uid;
		this.email = email;
		this.password = password;
		this.username = username;
		this.gender = gender;
		this.registerDate = registerDate;
	}


	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Timestamp getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", email=" + email + ", password="
				+ password + ", username=" + username + ", gender=" + gender
				+ ", registerDate=" + registerDate + "]";
	}
	
	
	
	
	
	
}
