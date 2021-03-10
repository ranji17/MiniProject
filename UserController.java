package com.fujitsu.loginandregister.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginandregister.DAO.UserdetailsDao;
import com.fujitsu.loginandregister.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserdetailsDao dao = new UserdetailsDao();
		ResultSet rs = dao.getValues();
		User user;
		ArrayList<User> l1 = new ArrayList<User>();

		try {
			while (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				l1.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	    HttpSession session = request.getSession();
	    session.setAttribute("list", l1);
	    response.sendRedirect("admin.jsp");
	    System.out.println(l1);
	    
	
	
	}
	
	
}
