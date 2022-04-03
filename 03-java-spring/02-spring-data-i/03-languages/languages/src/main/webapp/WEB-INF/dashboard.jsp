<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
	<h1>Dashboard</h1>
	<div>
		<table>
			<thead>
				<tr>
				 <th>Name</th>
				 <th>Creator</th>
				 <th>Version</th>
				 <th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${languages}" var="language">
				<tr>
					
					<td>
					<a href="/show/${language.id}">
					<c:out value = "${language.name}"/>
					</a>
					</td>
					<td><c:out value = "${language.creator}"/></td>
					<td><c:out value = "${language.version}"/></td>
					<td>
					<form action="languages/${language.id}/edit">
						<input type="submit" value="Edit">
					</form>
					<form action="/delete/languages/${language.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Delete">
					</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="/">Add Language</a>
</body>
</html>