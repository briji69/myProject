<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page session="false" %>
    	<%String msg=(String)request.getAttribute("msg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Bus</title>
</head>
<body>
<form action="./addBus" method="post">
	<h1 align="center">Add Bus</h1>
		<table border="10px" align="center" border="1">
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId" required="required"></td>
			</tr>
			<tr>
				<td>Bus name</td>
				<td>:</td>
				<td><input type="text" name="busName" required="required"></td>
			</tr>
			<tr>
				<td>Starting Point</td>
				<td>:</td>
				<td><input type="text" name="startingPoint" required="required"></td>
			</tr>
			<tr>
				<td>Ending Point</td>
				<td>:</td>
				<td><input type="text" name="endingPoint" required="required"></td>
			</tr>
			<tr>
				<td>Bus Type</td>
				<td>:</td>
				<td><input type="text" name="busType" required="required"></td>
			</tr>
			<tr>
				<td>Total Seats</td>
				<td>:</td>
				<td><input type="number" name="totalSeats" required="required"></td>
			</tr>
			<tr>
			<td>Cost</td>
				<td>:</td>
				<td><input type="number" value="cost" required="required"></td>
			</tr>
			<tr align="center">
				<td ><input type="submit" value="AddBus" ></td>
			</tr>
		</table>
	</form >
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>
</body>
</html>