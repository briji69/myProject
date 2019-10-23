<%@page import="javax.swing.GroupLayout.Alignment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@page session="false" %>
        <%String msg=(String)request.getAttribute("msg"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>App Home</title>
<style type="text/css">

</style>
</head>
<body >

<h2 align="center">Bus Booking System...!</h2>
<h2 align="center">Welcome to Briji,s Bus Booking System...!</h2>
	<table align="center">
	<tr>
	<td><a href="./login" >Login</a></td></tr>
	</table>
	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table>
</body>
</html>