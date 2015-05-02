package test.dao;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.UserDao;
import domain.User;

public class UserDaoTest {
	
	public void testFindByUsername(){
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.findByUsername("tony");
		
		System.out.println(user);
		
	}
	
	
	public void testAdd(){
		UserDao userDao = new UserDao();	
		User user = new User();
		user.setEmail("test@gmail.com");
		user.setGender("female");
		user.setPassword("123");
		user.setUsername("Test");
		
		Date date = new Date();
		//SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   // Timestamp currentTime = f.format(date); 
		Timestamp currentTime = new Timestamp(date.getTime());
		user.setRegisterDate(currentTime);
		
		userDao.add(user);
		System.out.println(currentTime + "\n");
	    
	    
		
	}
	
	
}
