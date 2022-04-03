<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<h2>The page has been visited: <c:out value = "${count}"/> of times!</h2>
	<p><a href="/counterbytwo">Double Count</a></p>
	<p><a href="/reset">Reset</a></p>
	<p><a href="/">Home</a>
</body>
</html>