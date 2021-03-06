package web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import domain.User;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/getUserInfo")
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userInfo = null;
		
		boolean getAllParam = true;
		String username = null;
		
		if (request.getParameterMap().containsKey("username")) {
			username = request.getParameter("username");
		} else {
			getAllParam = false;
		}
		
		if (!getAllParam){
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			//System.out.println(username + " : " + password );
			out.print("lack parameters");
			return;
		}
		
		UserService userService = new UserService();
		User user = new User();
		user = userService.findByUsername(username);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if (user != null){
			userInfo = "{\"email\":\"" + user.getEmail() + "\", \"gender\":\"" + user.getGender() + "\"}";
			out.println(userInfo);
		} else {
			out.println("notFind");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
