<%@page import="com.capgemini.busschedulingspringmvc.beans.Availability"%>
<%@page import="java.util.List"%>
<%@page import="com.capgemini.busschedulingspringmvc.beans.Ticket"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%String msg=(String)request.getAttribute("msg"); %>
<%Ticket ticket=(Ticket)request.getAttribute("ticket"); %>
<%List<Availability> availabilities=(List<Availability>)request.getAttribute("availList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Ticket</title>
</head>
<body>
	<form action="./checkAvail" method="post">
		<table align="center" border="10px" border="1">
	<h2 align="center">Check AValiability</h2>
			<tr>
				<td>Journey Date</td>
				<td>:</td>
				<td><input type="date" name="journeyDate"></td>
			</tr>
			<tr>
				<td>Source</td>
				<td>:</td>
				<td><input type="text" name="startingPoint"></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td>:</td>
				<td><input type="text" name="endingPoint"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Check"></td>
			</tr>
		</table>
	</form>
	
	<h3 align="center">Avaliability Details</h3>
	
	<table align="center" border="1"  border="10px">
	<tr><%if(msg!=null && !msg.isEmpty()){ %>
	<%=msg %>
	<%} %></tr>
	<thead>
	<td>Bus Id</td>
	<td>Available Date</td>
	<td>Available Seats</td>
	</thead>
	
	<tbody>
	<%if(availabilities!=null && !availabilities.isEmpty() ){ %>
	
	<%for(Availability availList:availabilities){%>
	<tr>
	<td><%=availList.getBusId() %></td>  
	<td><%=availList.getAvailableDate() %></td>
	<td><%=availList.getAvailableSeat() %></td>
	</tr>
	<% } %>
	<% } %>
	</tbody>
	</table>
	<br>
	<form action="./bookTicket" method="post">
	<h2 align="center">Book Ticket</h2>
		<table align="center" border="10px" border="1">
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId"></td>
			</tr>
			<tr>
				<td>Journey Date</td>
				<td>:</td>
				<td><input type="date" name="journeyDate"></td>
			</tr>
			<tr>
				<td>Number of seats</td>
				<td>:</td>
				<td><input type="number" name="numOfSeats"></td>
			</tr>
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="text" name="customerId"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Book Ticket"></td>
			</tr>
		</table>
	</form>
	<br>
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>
	<h3 align="center">Ticket Details</h3>
	<table align="center" border="1"  border="10px">
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
	<tr>
	<td><%=ticket.getBookingId() %></td>
	<td><%=ticket.getBusId()%></td>
	<td><%=ticket.getBookingDateTime()%></td>
	<td><%=ticket.getCustomerId()%></td>
	<td><%=ticket.getJourneyDate()%></td>
	<td><%=ticket.getNumOfSeats()%></td>
	</tr>
	<% } %>
	</tbody>
	</table>
	
</body>
</html>