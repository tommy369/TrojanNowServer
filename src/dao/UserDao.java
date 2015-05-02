package dao;

import java.sql.Statement;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import domain.User;

public class UserDao {

	// find user by username
	public User findByUsername(String username){
		
		//User user = new User();
		
		// connect DB
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBconnector DBcon = new DBconnector();
		try {
			// get connector
			con = DBcon.getConnection();
			// get statement
			stmt = con.createStatement();
			// set query
			String sql = "SELECT * FROM users";
			// get results
			rs = (ResultSet) stmt.executeQuery(sql);
			
			while(rs.next()){
				int uid;
				String email;
				String password;
				// username
				String gender;
				Timestamp registerTime;
				
				String queryUsername = rs.getString("username");
				if(queryUsername.equals(username)){
					uid = rs.getInt("uid");
					email = rs.getString("email");
					password = rs.getString("password");
					gender = rs.getString("gender");
					registerTime = rs.getTimestamp("register_date");
					
					User user = new User(uid, email, password, username,
							gender, registerTime);
					
					return user;
				}
				
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			try{
				// close database
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch (Exception e){
				throw new RuntimeException(e);
			}
		}
		
		return null;
	}
	
	
	public User findByEmail(String email){
		// connect DB
				Connection con = null;
				Statement stmt = null;
				ResultSet rs = null;
				DBconnector DBcon = new DBconnector();
				try {
					// get connector
					con = DBcon.getConnection();
					// get statement
					stmt = con.createStatement();
					// set query
					String sql = "SELECT * FROM users";
					// get results
					rs = (ResultSet) stmt.executeQuery(sql);
					
					while(rs.next()){
						int uid;
						//String email;
						String password;
						String username;
						String gender;
						Timestamp registerTime;
						
						String queryEmail = rs.getString("email");
						if(queryEmail.equals(email)){
							uid = rs.getInt("uid");
							username = rs.getString("username");
							password = rs.getString("password");
							gender = rs.getString("gender");
							registerTime = rs.getTimestamp("register_date");
							
							User user = new User(uid, email, password, username,
									gender, registerTime);
							
							return user;
						}
						
					}
					
				} catch (Exception e) {
					throw new RuntimeException(e);
					
				} finally {
					try{
						// close database
						if(rs != null){
							rs.close();
						}
						if(stmt != null){
							stmt.close();
						}
						if(con != null){
							con.close();
						}
					}catch (Exception e){
						throw new RuntimeException(e);
					}
				}
				
				return null;
	}
	
	public void add(User user){
		String email = user.getEmail();
		String password = user.getPassword();
		String username = user.getUsername();
		String gender = user.getGender();
		Timestamp registerTime = user.getRegisterDate();
		
	
		
		// connect DB
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBconnector DBcon = new DBconnector();
		try {
			// get connector
			con = DBcon.getConnection();
			// get statement
			stmt = con.createStatement();
			// set query
			System.out.println("UserDao: " + registerTime.toString() + "->" + registerTime.toString().substring(0, 19));
			
			String sql = "INSERT INTO users VALUES (null,'" + email + "','" + password
					+ "','" + username + "','" + gender + "','" + registerTime.toString().substring(0, 19) + "')";
			// execute
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			try{
				// close database
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch (Exception e){
				throw new RuntimeException(e);
			}
		}
	} // end addUser
	
	public String getAllUsers(){
		String allUsers = "[";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		DBconnector DBcon = new DBconnector();
		try {
			// get connector
			con = DBcon.getConnection();
			// get statement
			stmt = con.createStatement();
			// set query
			String sql = "SELECT username FROM users";
			// get results
			rs = (ResultSet) stmt.executeQuery(sql);
			
			while(rs.next()){
				String username = null;
				
				username = rs.getString("username");
				
				
				allUsers = allUsers + "\"" + username + "\"";
				
				if (!rs.isLast()){
					allUsers += ",";
				}
			}
			allUsers += "]";
			
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			try{
				// close database
				if(rs != null){
					rs.close();
				}
				if(stmt != null){
					stmt.close();
				}
				if(con != null){
					con.close();
				}
			}catch (Exception e){
				throw new RuntimeException(e);
			}
		}
		
		return allUsers;
		
	}
	
}
