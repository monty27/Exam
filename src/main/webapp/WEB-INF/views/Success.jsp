<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exam finished</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<H3> Hello <c:out value='${loggedInCustomer.name}'/> congrats! your score is, <c:out value='${score}'/> </H3>
	<h4>Please <a href = "/exam/Home">click here</a> for your home page</h4>
</body>
</html>