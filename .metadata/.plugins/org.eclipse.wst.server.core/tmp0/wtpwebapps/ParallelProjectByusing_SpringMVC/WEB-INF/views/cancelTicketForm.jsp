<%@page import="com.capgemini.busschedulingspringmvc.beans.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancel Ticket</title>
</head>
<body>
	<form action="./cancelTicket" method="post">
		<h1 align="center">Cancel Ticket</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>Booking Id</td>
				<td>:</td>
				<td><input type="number" name="bookingId"></td>
			</tr>
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="userId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Cancel"></td>
			</tr>
		</table>
	</form>
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>

</body>
</html>