<%@page import="com.capgemini.busschedulingspringmvc.beans.Bus"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
		<%Bus bus=(Bus)request.getAttribute("bus"); %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Bus</title>
</head>
<body>
	<form action="./searchBus" method="post">
			<h1 align="center">Search Bus</h1>
		<table border="10px" align="center" border="1">
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId"></td>
			</tr>
			<tr>
				<td><button type="submit" >Search Bus</button></td>
			</tr>
		</table >
	</form>
	<h3 align="center">
	<%if(msg!=null && !msg.isEmpty()){ %>
	<%=msg %>
	<%} %>
	</h3>
	<table border="10px" align="center" border="1">
	<thead> 
	<td>Bus Id</td>
	<td>Bus Name</td>
	<td>Bus Type</td>
	<td>Starting Point</td>
	<td>Ending Point</td>
	<td>Number Of Seats</td>
	<td>Cost</td>
	</thead>
	<%if(bus!=null ){ %>
	<tr>
	<td><%=bus.getBusId() %></td>
	<td><%=bus.getBusName()%></td>
	<td><%=bus.getBusType()%></td>
	<td><%=bus.getStartingPoint()%></td>
	<td><%=bus.getEndingPoint()%></td>
	<td><%=bus.getTotalSeats()%><br></td>
	<td><%=bus.getCost()%><br></td>
	</tr>
	<% } %>
	</table>
</body>
</html>