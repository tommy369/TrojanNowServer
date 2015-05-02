<%@ page language="java" contentType="text/html; charset=UTF-8" import="dao.*"
    pageEncoding="UTF-8"%>


<%

	String pass = "";
	String email = "";

	if (request.getParameterMap().containsKey("password")) {
		pass = request.getParameter("password");
	 }
	 
	if (request.getParameterMap().containsKey("email")) {
		email = request.getParameter("email");
	 }
	


	
	//if(email.equals("tom@163.com") && pass.equals("321")){
%>

	<%
		if(email.equals("trojan") && pass.equals("123")){
	%>
true
	<%} else { %>
false

	<%} %>

