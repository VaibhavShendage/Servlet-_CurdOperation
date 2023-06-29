<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	margin-top: 50px;
}

</style>

        

</head>
<body>
 <a href="index.jsp"> <input type ="submit" value="GoTo HOME"  style="margin-left: 1000px; color: orange;"></a>
<h1 style ="color:pink">Select Employee</h1>
<form action="get" method="get">
<label>Enter Your Id </label>
<input type="text" name="id">
<input type="Submit" value="Show">
</form>


	<table border=1>
		<tr>
			<th>id</th>
			<th> Name</th>
			<th>Last Name</th>
			<th>Mob_No</th>
			<th>Email_id</th>
			<th>Address</th>
			<th>Password</th>
			
		</tr>
		
		<tr>
			<td>${addemp.id}</td>
			<td>${addemp.firstname}</td>
			<td>${addemp.lastname}</td>
			<td>${addemp.mobileno}</td>
			<td>${addemp.email}</td>
			<td>${addemp.address}</td>
			<td>${addemp.password}</td>
		</tr>
		
		
	</table>



</body>
</html>