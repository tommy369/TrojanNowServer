package dao;



import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Test {

	@org.junit.Test
	public void test() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://rdsl6iqzh466r3m6hreak.mysql.rds.aliyuncs.com:3306/trojanow";
		String username = "trojan";
		String password = "578project";
		
		
		Connection con = (Connection) DriverManager.getConnection(url,username,password);
		System.out.println(con);
		
	}

}
