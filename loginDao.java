package com.fujitsu.loginandregister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class loginDao  {
	public boolean verifyUserCredentials(String username,String password) {

	String url = "jdbc:mysql://localhost:3306/test1";
	String db_username = "root";
	String db_password = "tiger";

	Connection con;
	PreparedStatement pstmt;

	String sql ="select * from user where username=? and password=?";
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, db_username, db_password);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
			return true;

	}catch(Exception e)
	{
		e.printStackTrace();
	}return false;
}
}