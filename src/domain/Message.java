package domain;

import java.sql.Timestamp;

public class Message {

	String from = null;
	String to = null;
	String message = null;
	private Timestamp datetime = null;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	
	
	public Message(String from, String to, String message, Timestamp datetime) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
		this.datetime = datetime;
	}
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		
		if (datetime != null ){
			return "{\"from\":" + "\"" + from + "\", \"to\":" + "\"" + to
					+ "\", \"message\":" + "\"" + message + "\", \"time\":" + "\"" + datetime.toString().substring(0, 19) + "\"}";
		} else {
			return "{\"from\":" + "\"" + from + "\", \"to\":" + "\"" + to
					+ "\", \"message\":" + "\"" + message + "\", \"time\":" + "\"" + datetime.toString().substring(0, 19) + "\"}";
		}
	}
	
	
}
