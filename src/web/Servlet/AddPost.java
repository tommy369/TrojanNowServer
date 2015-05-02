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

import service.PostException;
import service.PostService;
import domain.Post;

/**
 * Servlet implementation class StorePost
 */
@WebServlet("/addPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");

		// depend on PostService
		PostService postService = new PostService();
		
		// 封装数据到Post
		String owner = "";
		boolean anonymous = false;
		String content = "";
		boolean getAllParam = true;
		String acceleration = null;
		
		if (request.getParameterMap().containsKey("owner")) {
			owner = request.getParameter("owner");
		} else {
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("anonymous")) {
			anonymous = Boolean.parseBoolean(request.getParameter("anonymous"));
		} else {
			//return;
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("content")) {
			content = request.getParameter("content");
		} else {
			//return;
			getAllParam = false;
		}
		if (request.getParameterMap().containsKey("acceleration")) {
			acceleration = request.getParameter("acceleration");
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
		
		Post post = new Post();
		post.setOwner(owner);
		post.setAnonymous(anonymous);
		post.setContent(content);
		post.setDatetime(currentTime);
		post.setAcceleration(acceleration);
		
		// 调用PostService.addPost()方法
		// 可能没有异常，也可能抛出PostException
		// 返回异常提示
		try {
			postService.addPost(post);
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.print("posted");
		} catch (PostException e) {
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
