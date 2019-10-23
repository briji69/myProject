<%@page import="com.capgemini.busschedulingspringmvc.beans.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page session="false" %>
    <%String msg=(String)request.getAttribute("msg"); %>
        <%User user=(User)request.getAttribute("user"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

</head>
<body>
<form action="./login" method="post">
		<h1 align="center">Login..!</h1>

		<table border="10px" align="center" border="1" >
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><input type="number" name="userId"></td>
			</tr>
			<tr>
				<td>User Password</td>
				<td>:</td>
				<td><input type="password" name="userPassword"></td>
			</tr>		
			<tr align="center">
				<td><button type="submit" >Login</button></td>
			</tr>
		</table>
	</form>
	<br>
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>
</body>
</html>