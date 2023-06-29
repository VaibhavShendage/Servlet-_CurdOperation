<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="org.omg.CORBA.Request"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
	 <a href="index.jsp"> <input type ="submit" value="GoTo HOME"  style="margin-left: 1000px; color: orange;"></a>
		<h1 align="center" style="color:pink">
			<font><strong >Show All Empolyee Details</strong></font>
		</h1>
		<form action="getall" method="post">
		<table border="1" style="background-color:lightyellow">
			
			<tr>
				<td><b>id</b></td>
				<td><b>Name</b></td>
				<td><b>LastName</b></td>
				<td><b>Mob_no</b></td>
				<td><b>Email</b></td>
				<td><b>Address</b></td>
				<td><b>Password</b></td>
			</tr>
			
			<c:forEach var="addemp" items="${userList}">
			
			<tr>
			
				<td>${addemp.id}</td>
				<td>${addemp.firstname}</td>
				<td>${addemp.lastname}</td>
				<td>${addemp.mobileno}</td>
				<td>${addemp.email}</td>
				<td>${addemp.address}</td>
				<td>${addemp.password}</td>
			


			</tr>
			</c:forEach>

		
		</table>
		</form>
	</div>


</body>
</html>