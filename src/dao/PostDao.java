package dao;

import java.sql.Statement;
import java.sql.Timestamp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;

import domain.Post;

public class PostDao {

	
	public String getAllPosts(){
	
		String posts = "{\"posts\":[";
		
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
			String sql = "SELECT * FROM post ORDER BY time DESC";
			// get results
			rs = (ResultSet) stmt.executeQuery(sql);
			
			int postId;
			String owner = null;
			boolean anonymous = false;
			String content = null;
			Timestamp datetime = null;
			String acceleration = null;
			
			
			while(rs.next()){
				postId = rs.getInt("postid");
				owner = rs.getString("owner");
				anonymous = rs.getBoolean("anonymous");
				content = rs.getString("content");
				datetime = rs.getTimestamp("time");
				acceleration = rs.getString("acceleration");

				
				Post post = new Post(postId, owner, anonymous, content, datetime, acceleration);
				posts += post;
				
				if (!rs.isLast()){
					posts += ",";
				}
			}
			posts += "]}";
			
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
		return posts;
		
	}
	
	// add posts, and throw error informations
	public void add(Post post){
		String owner = post.getOwner();
		boolean anonymous = post.isAnonymous();
		String content = post.getContent();
		Timestamp postTime = post.getDatetime();
		String acceleration = post.getAcceleration();
		
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
			System.out.println("PostDao: " + postTime.toString() + "->" + postTime.toString().substring(0, 19));
				
			int myInt = (anonymous) ? 1 : 0;

			
			String sql = "INSERT INTO post VALUES (null,'" + owner + "','" + myInt
					+ "','" + content + "','" + postTime.toString().substring(0, 19)
					+ "','" + acceleration + "')";
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
	}// end addPost
	
	public String findPostByUsername(String username){
		String posts = "{\"posts\":[";
		
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
			String sql = "SELECT * FROM post WHERE owner='" + username + "' ORDER BY time DESC";
			// get results
			rs = (ResultSet) stmt.executeQuery(sql);
			
			int postId;
			String owner = null;
			boolean anonymous = false;
			String content = null;
			Timestamp datetime = null;
			String acceleration = null;
			
			
			while(rs.next()){
				postId = rs.getInt("postid");
				owner = rs.getString("owner");
				anonymous = rs.getBoolean("anonymous");
				content = rs.getString("content");
				datetime = rs.getTimestamp("time");
				acceleration = rs.getString("acceleration");

				
				Post post = new Post(postId, owner, anonymous, content, datetime, acceleration);
				posts += post;
				
				if (!rs.isLast()){
					posts += ",";
				}
			}
			posts += "]}";
			
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
		return posts;
	}
	
	
}
