<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
	<form:form method = "post" action="/newQuestion" modelAttribute="question">
	<p>
		<form:label path ="text">Question:</form:label>
		<form:errors path="text"/>
		<form:textarea path = "text"/>
	</p>
	<p>
		<form:label path = "tagsFromFrontEnd">Tags (Separate by Comma)</form:label>
		<form:errors path="tagsFromFrontEnd"/>
		<form:input path = "tagsFromFrontEnd"/>
	</p>
	<button>Submit Question</button>
	</form:form>
</body>
</html>