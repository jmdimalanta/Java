<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book!</title>
</head>
<body>
<h1>Add a New Book!</h1>
<form:form action = "/create" method="post" modelAttribute="book">
	<p>
		<form:label path = "title">Title</form:label>
		<form:input path ="title"/>
	</p>
	<p>
		<form:label path= "description">Description</form:label>
		<form:input path ="description"/>
	</p>
	<p>
		<form:label path= "language">Language</form:label>
		<form:input path ="language"/>
	</p>
	<input type="submit" value="Submit"/>
</form:form>
</body>
</html>