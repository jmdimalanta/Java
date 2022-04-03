<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome!</title>
</head>
<body>
	<h1>Add a language!</h1>
	<form:form action = "/create" method="post" modelAttribute="language">
		<p>
			<form:label path = "name">Name:</form:label>
			<form:errors class="text-danger" path="name"/>
			<form:input path = "name"/>
		</p>
		<p>
			<form:label path = "creator">Creator:</form:label>
			<form:errors class="text-danger" path="creator"/>
			<form:input path = "creator"/>
		</p>
		<p>
			<form:label path = "version">Version:</form:label>
			<form:errors class="text-danger" path="version"/>
			<form:input path = "version"/>
		</p>
		<input type="submit" value="Submit"/>
	</form:form>	
</body>
</html>