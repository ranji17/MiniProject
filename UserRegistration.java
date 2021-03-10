package com.fujitsu.loginandregister.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.loginandregister.DAO.UserResiterDAO;
import com.fujitsu.loginandregister.model.User;

/**
 * Servlet implementation class UserRegistration
 */
@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserResiterDAO dao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	int phone = Integer.parseInt(request.getParameter("phonenumber"));
	String address=request.getParameter("address");
	
	// GENERATING RANDOM ID
	
	Random random = new Random();
	int userid=random.nextInt(999);
	//System.out.println("Userid : "+userid);
	
	User newUser=new User(userid,username,password,phone,address);
	
	//System.out.println(newUser);
	
	dao=new UserResiterDAO();
	boolean result = dao.RegisterDao(newUser);
	
	if(result) {
		System.out.println("User Registered Successfully");
	    response.sendRedirect("welcome.jsp");
	}
	else {
		System.err.println("Internal Server Error");
		response.sendRedirect("error.jsp");
	}
	
	
	
	
	}
}
