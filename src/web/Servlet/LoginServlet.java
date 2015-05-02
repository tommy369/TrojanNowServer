package web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		// depend on UserService
		UserService userService = new UserService();
		
		// get parameters
		String username = "";
		String password = "";
		boolean successLogin = true;
		
		if (request.getParameterMap().containsKey("username")) {
			username = request.getParameter("username");
		} else {
			//username = "tommy";
			successLogin = false;
		}
		
		if (request.getParameterMap().containsKey("password")) {
			password = request.getParameter("password");
		} else {
			//username = "tommy";
			successLogin = false;
		}
		
		if(!successLogin){
			PrintWriter out = response.getWriter();
			//System.out.println(username + " : " + password );
			out.println(successLogin);
			return;
		}
		
		if (userService.login(username, password) == null){
			successLogin = false;
			PrintWriter out = response.getWriter();
			//System.out.println(username + " : " + password );
			out.println(successLogin);
		} else {
			successLogin = true;
			PrintWriter out = response.getWriter();
			//System.out.println(username + " : " + password );
			out.println(successLogin);
		}
		
		return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
