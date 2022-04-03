<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
<h1>
	<c:out value = "${product.name}"/>
	<c:out value = "${product.description}"/>
	<c:out value = "${product.price}"/>
</h1>
<hr>
<h2>Categories</h2>
<ul>
	<c:forEach items="${product.categories}" var="cat">
		<li>${cat.name}</li>
	</c:forEach>
</ul>
<form method = "post" action="/addCatToProd/${product.id}">
	<select name = "categories">
		<c:forEach items="${notInProd}" var="prod">
		<option value="${prod.id }">${prod.name}</option>
		</c:forEach>
	</select>
	<button>Add Category</button>
</form>
</body>
</html>