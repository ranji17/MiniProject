package com.fujitsu.loginandregister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginandregister.DAO.loginDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		loginDao dao = new loginDao();
		//if(dao.verifyUserCredentials(username, password)) {
		//type:1
		//if(username.equals("user@gmail.com")&&(password.equals("123"))){   instead of 24 & 25 th line;
			
		//type 2
			boolean result=dao.verifyUserCredentials(username,password); 
			//instead of 25th line
			if(result) {
			System.out.println("executing if block "+true);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			
			
			
			response.sendRedirect("welcome.jsp");
			
		}
		else {
			response.sendRedirect("login.jsp");
		}
			
	}

}
