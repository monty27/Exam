<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<form action="/exam/Home" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /> 
				<input type="hidden" value="false" name="logout" /></td>
			</tr>

			<tr>
				<td colspan=2><input type="submit" value="Log In" /></td>
			</tr>
		</table>
	</form>
	<h4>
		If you are new to this web site please <a href="/exam/Register">register here</a>
	</h4>
</body>
</html>