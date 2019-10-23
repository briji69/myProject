<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page session="false" %>
	<%String msg=(String)request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="./register" method="post">
		<h1 align="center">Add User</h1>
	
		<table border="10px" align="center" border="1">
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="userId" required="required"></td>
			</tr>
			<tr>
				<td>User name</td>
				<td>:</td>
				<td><input type="text" name="userName" required="required"></td>
			</tr>
			<tr>
				<td>User Email</td>
				<td>:</td>
				<td><input type="email" name="userEmail" required="required"></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td>:</td>
				<td><input type="password" name="userPassword" required="required"></td>
			</tr>
			<tr>
				<td>User Mobile</td>
				<td>:</td>
				<td><input type="tel" name="userMobile" required="required"></td>
			</tr>
			<tr>
				<td>User Type</td>
				<td>:</td>
				<td><select name="type">				
				<option>....</option>
				<option>owner</option>
				<option>enjoyer</option>
				</select>
				</td>
			</tr>
			<tr align="center">
				<td><button type="submit"  >Add User</button></td>
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