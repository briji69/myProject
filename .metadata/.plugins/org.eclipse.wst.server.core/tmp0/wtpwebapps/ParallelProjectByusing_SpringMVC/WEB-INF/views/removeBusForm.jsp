<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Bus</title>
</head>
<body>
	<form action="./removeBus" method="post">
		<h1 align="center">Remove Bus</h1>
		<table border="10px" align="center" border="1">
			<tr>
				<td>Bus Id</td>
				<td>:</td>
				<td><input type="number" name="busId"></td>
			</tr>
			<tr>
				<td><button type="submit">Remove Bus</button></td>
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