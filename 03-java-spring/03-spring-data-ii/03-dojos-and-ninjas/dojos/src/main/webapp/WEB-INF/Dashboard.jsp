<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Dashboard</title>
</head>
<body>
	<h1>Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dojos}" var="dojo">
			<tr>
				<td>${dojo.name}</td>
				<td><a href="/dojo/${dojo.id}">View</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">Add a Dojo</a>
	<a href="/ninja/new">Add a Ninja</a>
</body>
</html>