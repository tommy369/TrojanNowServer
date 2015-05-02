package test.any;

import java.sql.Timestamp;
import java.util.Date;

import service.UserService;
import domain.Message;
import domain.Post;

public class MyClass {

	public MyClass() {
		// TODO Auto-generated constructor stub
		
	}
	
	@org.junit.Test
	public void myfun(){
		UserService userService = new UserService();
		String users = userService.getAllUsers();
		System.out.println(users);
	}
	
	//@org.junit.Test
	public void testMessage(){
		
		Date date = new Date(); 
		Timestamp currentTime = new Timestamp(date.getTime());
		Message mes = new Message("a", "b", "message content", currentTime);
		
		System.out.println(mes);
		
		Post post = new Post();
		System.out.println(post);
		
	}

}
