<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Home</title>
</head>
<body>
	<form action="./setBusAvail" method="post">
			<h1 align="center">Set Bus Avail...!</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>Avail Date</td>
				<td>:</td>
				<td><input type="date" name="availableDate"></td>
			</tr>
			<tr>
				<td>Avail seat</td>
				<td>:</td>
				<td><input type="number" name="availableSeat"></td>
			</tr>
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId"></td>
			</tr>
			<tr>
				<td><button type="submit" >Set Availiability</button></td>
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