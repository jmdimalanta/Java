<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Dojo</title>
</head>
<body>
	<h1>Add a new Dojo</h1>
		<form:form action = "/create" method="post" modelAttribute="dojo">
			<form:label path="name">Name:</form:label>
			<form:input path="name"/>
			<input type="submit" value="Submit"/>
		</form:form>
</body>
</html>