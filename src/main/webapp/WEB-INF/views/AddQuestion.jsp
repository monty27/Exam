<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a Question</title>
</head>
<body>
<form action = "/exam/AddQuestion" method = "post">
	<table>
	<tr><td>Question:</td><td><input type = "text" name = "question"/></td></tr>
	<tr><td>Option A:</td><td><input type = "text" name = "optionA"/></td></tr>
	<tr><td>Option B:</td><td><input type = "text" name = "optionB"/></td></tr>
	<tr><td>Option C:</td><td><input type = "text" name = "optionC"/></td></tr>
	<tr><td>Option D:</td><td><input type = "text" name = "optionD"/></td></tr>
	<tr><td>Answer:</td><td><input type = "text" name = "answer"/></td></tr>
	<tr><td>Difficulty:</td><td><input type = "text" name = "difficulty"/></td></tr>
	<tr><td colspan = 2><input type = "submit" value = "ADD QUESTION"/></td></tr>
	</table>
</form>
</body>
</html>