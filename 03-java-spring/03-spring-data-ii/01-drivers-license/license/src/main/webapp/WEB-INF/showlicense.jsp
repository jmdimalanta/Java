<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User License</title>
</head>
<body>
<h1>License Details:</h1>
<p>First Name: <c:out value="${person.firstName}"/></p>
<p>First Name: <c:out value="${person.lastName}"/></p>
<p>License Number: <c:out value="${license.number}"/></p>
<p>State: <c:out value="${license.expiration_date}"/></p>
<p>Expiration Date:</p>
</body>
</html>