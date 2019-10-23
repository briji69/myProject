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
<title>Customer Home</title>
</head>
<body>
	
	<h2 align="center">hello <%=user.getUserName() %></h2>
	<br>
	
	<h2>Welcome to Customer Home page...!</h2>
	<a href="./updateCustomer">Update Customer</a><br>
	<a href="./removeCustomer">Delete Customer</a><br>
	<a href="./bookTicket">Book Ticket</a><br>
	<a href="./cancelTicket">Cancel Ticket</a><br>
	<a href="./printTicket">Print Ticket</a><br>
	<a href="./writeFeedback">Give Feedback</a><br>
	<a href="./logout">Logout</a><br>
</body>
</html>