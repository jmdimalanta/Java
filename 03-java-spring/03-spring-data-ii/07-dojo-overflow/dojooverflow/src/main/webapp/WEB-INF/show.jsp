<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show</title>
</head>
<body>
	<h1>${question.text}</h1>
		<p>
		<c:forEach items = "${question.taggers}" var="tag">
		${tag.subject},
		</c:forEach>
		</p>
		<h2>Answers</h2>
			<ul>
				<c:forEach items = "${question.answers}" var = "answer">
				<li>${answer.text}</li>
				</c:forEach>
			</ul>
		<hr>
		<h3>Add an Answer</h3>
			<form:form method = "post" action="/addAnswer" modelAttribute = "answer">
				<p>
					<form:label path = "text">Answer:</form:label>
					<form:errors path = "text"/>
					<form:input path = "text"/> 
					<form:hidden path = "question" value = "${question.id}"/>
				</p>
			<button>Add Answer</button>
			</form:form>
	<a href = "/new">Ask a new Question</a>
	<a href = "/">Home</a>
</body>
</html>