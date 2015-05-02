package dao;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;




public class DBconnector {
	
	@org.junit.Test
	public Connection getConnection () throws ClassNotFoundException, SQLException{
		/*
		 * 
		 */
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://aa1o47r4bgauald.czcucmargv8m.us-west-1.rds.amazonaws.com:3306/trojanow";
		//String username = "trojan";
		//String password = "578project";
		String username = "tommy";
		String password = "utfX3699";
		
		
		Connection con = (Connection) DriverManager.getConnection(url,username,password);
		//System.out.println(con);
		
		return con;
		
		
	}
	
}
