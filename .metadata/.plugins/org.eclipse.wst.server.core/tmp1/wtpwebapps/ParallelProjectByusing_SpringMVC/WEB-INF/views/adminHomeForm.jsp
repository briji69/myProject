<%@page import="com.capgemini.busschedulingspringmvc.beans.User"%>
<%@page import="com.capgemini.busschedulingspringmvc.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false" %>

	<%
		User user=(User)request.getAttribute("user");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	
	<h2 align="center">hello <%=user.getUserName() %></h2>
	<br>
	
	<h2>Welcome to Admin Home page...!</h2>
	<a href="./register">Add Owner</a><br>
	<a href="./register">Add Customer</a><br>
	<a href="./removeOwner">Remove Owner</a><br>
	<a href="./removeCustomer">Remove Customer</a><br>	
	<a href="./logout">Logout</a>
	
</body>
</html>