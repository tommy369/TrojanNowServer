package domain;

import java.sql.Timestamp;

public class Post {
	private int postId;
	private String owner = null;
	private boolean anonymous = false;
	private String content = null;
	private Timestamp datetime = null;
	private String	acceleration = null;
	
	// constructor
	public Post(int postId, String owner, boolean anonymous, String content,
			Timestamp datetime, String acceleration) {
		super();
		this.postId = postId;
		this.owner = owner;
		this.anonymous = anonymous;
		this.content = content;
		this.datetime = datetime;
		this.acceleration = acceleration;
	}
	
	

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public boolean isAnonymous() {
		return anonymous;
	}
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
	@Override
	public String toString() {
	//	return "Post [postId=" + postId + ", owner=" + owner + ", anonymous="
	//			+ anonymous + ", content=" + content + ", datetime=" + datetime
	//			+ "]";
		if (datetime != null){
			return "{\"postid\":" + postId + ", \"owner\":\"" + owner + "\", \"anonymous\":"
					+ anonymous + ", \"content\":\"" + content + "\", \"datetime\":\""
					+ datetime.toString().substring(0, 19) + "\", acceleration:\"" + acceleration + "\"}";
		} else {
			return "{\"postid\":" + postId + ", \"owner\":\"" + owner + "\", \"anonymous\":"
					+ anonymous + ", \"content\":\"" + content + "\", \"datetime\":\""
					+ datetime + "\", acceleration:\"" + acceleration + "\"}";
		}
		
	}



	public String getAcceleration() {
		return acceleration;
	}



	public void setAcceleration(String acceleration) {
		this.acceleration = acceleration;
	}
	
	
	
	
}
