package web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserException;
import service.UserService;
import domain.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// depend on UserService
		UserService userService = new UserService();
		
		// 封装数据到User
		String username = "";
		String gender = "";
		String password = "";
		String email = "";
		boolean getAllParam = true;
		
		if (request.getParameterMap().containsKey("username")) {
			username = request.getParameter("username");
		} else {
			//username = "tommy";
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("password")) {
			password = request.getParameter("password");
		} else {
			//return;
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("email")) {
			email = request.getParameter("email");
		} else {
			//return;
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("gender")) {
			gender = request.getParameter("gender");
		} else {
			//return;
			getAllParam = false;
		}
		
		if (!getAllParam){
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			//System.out.println(username + " : " + password );
			out.print("lack parameters");
			return;
		}
		
		
		Date date = new Date(); 
		Timestamp currentTime = new Timestamp(date.getTime());
		
		User user = new User();
		user.setEmail(email);
		user.setGender(gender);
		user.setPassword(password);
		user.setRegisterDate(currentTime);
		user.setUsername(username);
		
		// 调用UserService.register()方法
		// 可能没有异常，也可能抛出UserException
		// 返回异常提示
		try {
			userService.register(user);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("register success");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print(e);
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
