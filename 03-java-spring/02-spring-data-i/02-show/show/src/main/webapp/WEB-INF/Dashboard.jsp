<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books!</title>
</head>
<body>
<table>
	<thead>
		<tr>
			<th>Title</th>
			<th>Description</th>
			<th>Language</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
		<tr>
			<td>
			<a href="/show/${book.id}">
			<c:out value="${book.title}"/>
			</a>
			</td>
			<td><c:out value="${book.description}"/></td>
			<td><c:out value="${book.language}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<a href="/">New Book</a>
</body>
</html>