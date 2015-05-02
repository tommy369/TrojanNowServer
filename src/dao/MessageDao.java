package dao;

import java.sql.Statement;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import domain.Message;
import domain.Post;

public class MessageDao {

	public void add(Message message){
		String from = message.getFrom();
		String to = message.getTo();
		String mesContent = message.getMessage();
		Timestamp mesTime = message.getDatetime();
		
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
			//System.out.println("PostDao: " + postTime.toString() + "->" + postTime.toString().substring(0, 19));

			
			String sql = "INSERT INTO message VALUES ('" + from + "','" + to
					+ "','" + mesContent + "','" + mesTime.toString().substring(0, 19)
					+ "')";
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
		
	} // end addMessage
	
	public String getAllMessages(String username){
		
		String messages = "{\"messages\":[";
		
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
			String sql = "SELECT * FROM message WHERE tou='" + username + "' ORDER BY time DESC";
			// get results
			rs = (ResultSet) stmt.executeQuery(sql);
			
			/*
			int postId;
			String owner = null;
			boolean anonymous = false;
			String content = null;
			Timestamp datetime = null;
			String acceleration = null;
			*/
			String to = null;
			String from = null;
			String mesContent = null;
			Timestamp datetime = null;
			
			while(rs.next()){
				
				to = rs.getString("tou");
				from = rs.getString("fromu");
				mesContent = rs.getString("message");
				datetime = rs.getTimestamp("time");
				
				Message message = new Message(from, to, mesContent, datetime);
				messages += message;
				
				if (!rs.isLast()){
					messages += ",";
				}
			}
			messages += "]}";
			
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
		// return posts
		return messages;
		
	}

}
