<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam's Home page</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<h3> Welcome to online exam portal, <c:out value='${loggedInCustomer.name}'/> </h3>
	<p><a href = ""> Click here</a> If you want to take an exam.</p>
	<p><a href = ""> Click here</a> To view all the test taken by you.</p>
	
	<form action ="/exam/Home" method = "post">
		<input type = "hidden" value = "" name = "username"/>
		<input type = "hidden" value = "" name = "password"/>
		<input type = "hidden" value = "true" name = "logout"/>
		<input type = "submit" value = "Logout"/>
	</form>
</body>
</html>