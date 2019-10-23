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
	<form action="./writeFeedback" method="post">
		<h2 align="center">Give Feedback..!</h2>
	
		<table align="center" border="10px" border="1">
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="customerId"></td>
			</tr>
			<tr>
				<td>One Word Feedback</td>
				<td>:</td>
				<td><input type="text" name="feedback"></td>
			</tr>
			<tr>
				<td><button type="submit" >Add Feedback</button></td>
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