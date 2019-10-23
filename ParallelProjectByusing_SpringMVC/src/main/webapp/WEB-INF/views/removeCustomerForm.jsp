<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Customer</title>
</head>
<body>
	<form action="./removeCustomer" method="post">
			<h1 align="center">Remove Customer</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="userId"></td>
			</tr>
			<tr>
				<td><button type="submit">Remove Customer</button></td>
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