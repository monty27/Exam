<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<h3>Welcome to Our Exam portal</h3>
<p>please enter your details below</p>
<form action = "/exam/Register" method = "post">
	<table>
	<tr><td>Name:</td><td><input type = "text" name = "name"/></td></tr>
	<tr><td>Address:</td><td><input type = "text" name = "address"/></td></tr>
	<tr><td>SSN:</td><td><input type = "text" name = "ssn"/></td></tr>
	<tr><td>Username:</td><td><input type = "text" name = "username"/></td></tr>
	<tr><td>Password:</td><td><input type = "password" name = "password"/></td></tr>
	<tr><td colspan = 2><input type = "submit" value = "Sign UP"/></td></tr>
	</table>
</form>
</body>
</html>