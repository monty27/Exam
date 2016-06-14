<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All exams taken</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<h3>All the tests taken by you are displayed below</h3>

	<table>
		<c:forEach var="test" items="${tests}">
			<tr>
				<td><c:url value="/ViewTest" var="displayURL">
						<c:param name="tid" value="${test.id}" />
					</c:url><a href='<c:out value="${displayURL}" />'>Test ID : ${test.id}</a></td>
				<td>Your score : ${test.score}</td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<p>
		<a href="/exam/InExam"> Click here</a> If you want to take an exam.
	</p>
	<p>
		<a href="/exam/ViewTests"> Click here</a> To view all the exams taken
		by you.
	</p>
</body>
</html>