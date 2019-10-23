<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
</head>
<body>
	<form action="./updateCustomer" method="post">
			<h2 align="center">Update Customer..!</h2>
	
		<table align="center" border="10px" border="1">
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="userId"></td>
			</tr>
			<tr>
				<td>User name</td>
				<td>:</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>User Email</td>
				<td>:</td>
				<td><input type="email" name="userEmail"></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td>:</td>
				<td><input type="password" name="userPassword"></td>
			</tr>
			<tr>
				<td>User Mobile</td>
				<td>:</td>
				<td><input type="tel" name="userMobile"></td>
			</tr>
			<tr>
				<td><button type="submit" >Update Customer</button></td>
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