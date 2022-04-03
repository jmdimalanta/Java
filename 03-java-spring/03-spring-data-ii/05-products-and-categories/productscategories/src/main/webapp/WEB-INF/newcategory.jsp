<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new category</title>
</head>
<body>
<h1>New Category</h1>
	<form:form action="/categories/create" method="post" modelAttribute="category">
		<form:label path="name">Name:</form:label>
		<form:input path = "name"/>
		<input type = "submit" value="Submit"/>
	</form:form>
</body>
</html>