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

import service.MessageException;
import service.MessageService;
import service.PostException;
import domain.Message;
import domain.Post;

/**
 * Servlet implementation class AddMessage
 */
@WebServlet("/addMessage")
public class AddMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				request.setCharacterEncoding("utf-8");

				// depend on PostService
				MessageService messageService = new MessageService();
				
				// 封装数据到Post
				String from = null;
				String to = null;
				String mesContent = null;
				boolean getAllParam = true;
				
				if (request.getParameterMap().containsKey("from")) {
					from = request.getParameter("from");
				} else {
					getAllParam = false;
				}
				if (request.getParameterMap().containsKey("to")) {
					to = request.getParameter("to");
				} else {
					//return;
					getAllParam = false;
				}
				if (request.getParameterMap().containsKey("message")) {
					mesContent = request.getParameter("message");
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
				
				Message messageObj = new Message();
				messageObj.setFrom(from);
				messageObj.setTo(to);
				messageObj.setMessage(mesContent);
				messageObj.setDatetime(currentTime);

				
				// 调用MessageService.addMessage()方法
				// 可能没有异常，也可能抛出MessageException
				// 返回异常提示
				try {
					messageService.addMessage(messageObj);
					response.setCharacterEncoding("UTF-8");
					PrintWriter out = response.getWriter();
					out.print("send");
				} catch (MessageException e) {
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
