<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@tablib uri="http://java.sun.com/jsp/jstl/core" prefic="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<h1>This is ADMIN PAGE!</h1>

<h3>User Profiles:</h3>

 <c:forEach var="user" items="${user }">
	<c:out value="${user }"/><br>
</c:forEach>




</body>
</html>