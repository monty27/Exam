<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<h3>
		Hello <c:out value='${loggedInCustomer.name}' />, please answer this question below: 
	</h3><br/>
	<form action="/exam/InExam" method="post">
		<h3>
			<c:out value='${currentQuestion.question}' />
		</h3>
		<input type="radio" name="answer" value="1">
		<c:out value='${currentQuestion.optionA}' />
		<br /> <input type="radio" name="answer" value="2">
		<c:out value='${currentQuestion.optionB}' />
		<br /> <input type="radio" name="answer" value="3">
		<c:out value='${currentQuestion.optionC}' />
		<br /> <input type="radio" name="answer" value="4">
		<c:out value='${currentQuestion.optionD}' />
		<br /> <input type="submit" value="Next" />
	</form>
</body>
</html>