<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/create" method="post" modelAttribute="person">
		<p>
			<form:label path="firstName">First Name:</form:label>
			<form:input path="firstName"/>
		</p>
		<p>
			<form:label path="lastName">Last Name:</form:label>
			<form:input path="lastName"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>