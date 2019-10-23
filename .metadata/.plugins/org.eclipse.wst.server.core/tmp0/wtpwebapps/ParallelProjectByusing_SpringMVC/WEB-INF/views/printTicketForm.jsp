<%@page import="com.capgemini.busschedulingspringmvc.beans.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
	<%Ticket ticket=(Ticket)request.getAttribute("ticket"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Print Ticket</title>
</head>
<body>
	<form action="./printTicket" method="post">
			<h1 align="center">Print Ticket</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>Booking Id</td>
				<td>:</td>
				<td><input type="number" name="bookingId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Print Ticket"></td>
			</tr>
		</table>
	</form>
	
	<h3 align="center"><%if(msg!=null && !msg.isEmpty()){ %>
	<%=msg %>
	<%} %></h3>
	<table border="10px" align="center" border="1">
	<thead>
	<td>Booking Id</td>
	<td>Bus Id</td>
	<td>Booking Date</td>
	<td>Customer Id</td>
	<td>Journey Date</td>
	<td>Number Of Seats</td>
	</thead>
	<tbody>
	<%if(ticket!=null ){ %>
	<td><%=ticket.getBookingId() %></td>
	<td><%=ticket.getBusId()%></td>
	<td><%=ticket.getBookingDateTime()%></td>
	<td><%=ticket.getCustomerId()%></td>
	<td><%=ticket.getJourneyDate()%></td>
	<td><%=ticket.getNumOfSeats()%></td>
	<% } %>
	</tbody>
	</table>
</body>
</html>