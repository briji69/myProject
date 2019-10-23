<%@page import="com.capgemini.busschedulingspringmvc.beans.Feedback"%>
<%@page import="com.capgemini.busschedulingspringmvc.beans.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<%String msg=(String)request.getAttribute("msg"); %>
<%List<Feedback> feedbacks=(List<Feedback>)request.getAttribute("feedback"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Feedbaack</title>
</head>
<body>

	<table align="center">
		<tr><%if(msg!=null && !msg.isEmpty()){ %>
		<td><%=msg %></td>
		<%} %></tr>
	</table >
	<h2 align="center">All Feedbacks...!</h2>
	<table align="center" border="10px" border="1">
	<thead>
	<td>Customer Id</td>
	<td>Feedback</td>
	</thead>
	<tbody>
	<%if(feedbacks!=null && !feedbacks.isEmpty()){ %>
	<%for(int i=0;i<feedbacks.size();i++){%>
	<tr>
	<td><%=feedbacks.get(i).getCustomerId() %></td> 
	<td><%=feedbacks.get(i).getFeedback() %></td> 
	</tr>
	<%} %>
	<%} %>
	</tbody>
	</table>
</body>
</html>