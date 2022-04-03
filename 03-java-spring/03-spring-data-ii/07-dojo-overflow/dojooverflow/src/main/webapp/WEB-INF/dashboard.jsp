<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<table>
		<tr>
			<th>Questions</th>
			<th>Tags</th>
		</tr>
		<c:forEach items ="${allqs}" var = "q">
		<tr>
			<td><a href="/show/${q.id}"/>${q.text}</a></td>
			<td>
			<p>
			<c:forEach items = "${q.taggers}" var="tagtext">
			${tagtext.subject},
			</c:forEach>
			</p>
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href = "/new">Ask a new Question</a>
</body>
</html>