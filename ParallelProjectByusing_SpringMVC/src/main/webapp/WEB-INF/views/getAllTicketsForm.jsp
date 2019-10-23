<%@page import="com.capgemini.busschedulingspringmvc.beans.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%String msg=(String)request.getAttribute("msg"); %>
<%List<Ticket> tickets=(List<Ticket>)request.getAttribute("ticket"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Tickets</title>
</head>
<body>
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>
	<h2 align="center">All Tickets...!</h2>
	<table align="center" border="10px" border="1">
	<thead>
	<td>Booking Id</td>
	<td>Booking Date</td>
	<td>Bus Id</td>
	<td>Customer Id</td>
	<td>Journey Date</td>
	<td>Seats Booked</td>
	</thead>
	<tbody>
	<%if(tickets!=null && !tickets.isEmpty()){ %>
	
	<%for(int i=0;i<tickets.size();i++){%>
	<tr>
	<td><%=tickets.get(i).getBookingId() %></td> 
	<td><%=tickets.get(i).getBookingDateTime()%></td>
	<td><%=tickets.get(i).getBusId()%></td> 
	<td><%=tickets.get(i).getCustomerId()%></td>
	<td><%=tickets.get(i).getJourneyDate()%></td> 
	<td><%=tickets.get(i).getNumOfSeats()%></td>
	</tr>
	<%} %>
	
	<%} %>
	
	</tbody>
	</table>
</body>
</html>