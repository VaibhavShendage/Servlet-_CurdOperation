<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1 style= "color:Red;">${error}</h1></center>
<center><h1 style= "color:Green">${successMsg}</h1></center>
 <a href="index.jsp"> <input type ="submit" value="GoTo HOME"  style="margin-left: 1000px; color: orange;"></a>
<h1>Delete Employee</h1>

<form action="Delete">

<label>ID:</label>
<input type="text" name="id" placeholder= "Enter id"/> <br> 
<input type="submit" value="Delete" name="Delete"> <br> 
</form>

</body>
</html>