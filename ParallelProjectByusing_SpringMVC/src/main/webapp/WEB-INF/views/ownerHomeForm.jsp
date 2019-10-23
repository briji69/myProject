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
<title>Owner Home</title>
</head>
<body>
	
	<h2 align="center">hello <%=user.getUserName() %></h2>
	<br>
	
	<h2>Welcome to Owner Home page...!</h2>
	<a href="./addBus">Add Bus</a><br>
	<a href="./updateBus">Update Bus</a><br>
	<a href="./removeBus">Remove Bus</a><br>
	<a href="./setBusAvail">Set Bus Avail</a><br>
	<a href="./getAllTicketsForm">Get All Tickets</a><br>
	<a href="./searchBus">Search Bus</a><br>
	<a href="./viewFeedbackForm">View Feedbacks</a><br>
	<a href="./logout">Logout</a>
</body>
</html>