<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Details</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<h3>
		Take a look at your test ID:
		<c:out value='${test.id}' /><br/>
		Your Score: <c:out value='${test.score}' />
	</h3>
	<c:forEach var="q" items="${test.questions}" varStatus="status">
		<h3>
			<c:out value='${q.question}' />
		</h3>
		<c:out value='${q.optionA}' />
		<br />
		<c:out value='${q.optionB}' />
		<br />
		<c:out value='${q.optionC}' />
		<br />
		<c:out value='${q.optionD}' />
		<br/>
		<h4>Your Answer :<c:out value='${test.answers[status.index]}' />
		<br/>Correct Answer :<c:out value='${q.answer}' /></h4>
	</c:forEach>
	<br/>
	<p><a href = "/exam/InExam"> Click here</a> If you want to take an exam.</p>
	<p><a href = "/exam/ViewTests"> Click here</a> To view all the exams taken by you.</p>
</body>
</html>