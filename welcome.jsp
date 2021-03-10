<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	

	<%
	
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<h1>Welcome to ${user }</h1>
    
	<a href="index.jsp">HOME</a>
	<a href="aboutus.jsp">ABOUT</a>
	<a href="admin.jsp">ADMIN</a>
	<form action="logout">
	<input type="submit" value="logout">
	</form>

</body>
</html>