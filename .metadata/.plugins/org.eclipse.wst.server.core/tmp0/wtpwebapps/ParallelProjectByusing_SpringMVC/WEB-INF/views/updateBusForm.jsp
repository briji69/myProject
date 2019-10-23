<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
	<%String msg=(String)request.getAttribute("msg"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Bus</title>
</head>
<body>
	<form action="./updateBus" method="post">
			<h1 align="center">Update Bus</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId"></td>
			</tr>
			<tr>
				<td>Bus name</td>
				<td>:</td>
				<td><input type="text" name="busName"></td>
			</tr>
			<tr>
				<td>Starting Point</td>
				<td>:</td>
				<td><input type="text" name="startingPoint"></td>
			</tr>
			<tr>
				<td>Ending Point</td>
				<td>:</td>
				<td><input type="text" name="endingPoint"></td>
			</tr>
			<tr>
				<td>Bus Type</td>
				<td>:</td>
				<td><input type="text" name="busType"></td>
			</tr>
			<tr>
				<td>Total Seats</td>
				<td>:</td>
				<td><input type="number" name="totalSeats"></td>
			</tr>
			<tr>
			<td>Cost</td>
				<td>:</td>
				<td><input type="number" value="cost"></td>
			</tr>
			<tr>
				<td><button type="submit" >Update Bus</button></td>
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