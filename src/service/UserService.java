package service;

import dao.UserDao;
import domain.User;

public class UserService {
	private UserDao userDao = new UserDao();
	

	// 调用dao按用户名查询方法，得到User对象
	// 返回null，调用添加用户方法
	// 返回非null， 创建异常对象，设置异常信息
	public void register(User user) throws UserException{
		// check username
		User _user = userDao.findByUsername(user.getUsername());
		if(_user != null){
			throw new UserException("username exist");
		}
		_user = userDao.findByEmail(user.getEmail());
		if(_user != null){
			throw new UserException("email exist");
		}
		
		userDao.add(user);
		
	}
	
	public User login(String username, String password){
		User user = userDao.findByUsername(username);
		
		if (user == null){
			return null;
		}else if (user.getPassword().equals(password)){
			return user;
		} else {
			return null;
		}	
	}
	
	public String getAllUsers(){
		String allUsers = userDao.getAllUsers();
		return allUsers;
	}
	
	public User findByUsername(String username){
		return userDao.findByUsername(username);
	}
	
}
