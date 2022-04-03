<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Category</title>
</head>
<body>
<h1><c:out value = "${category.name}"/></h1>
<hr>
<h2>Products</h2>
<ul>
<c:forEach items = "${category.products}" var = "prod">
<li> ${prod.name} | ${prod.description} | ${prod.price} </li>
</c:forEach>
</ul>
<form method = "post" action="/addProdToCat/${category.id}">
	<select name = "products">
		<c:forEach items="${notInCat}" var="cat">
		<option value="${cat.id }">${cat.name}</option>
		</c:forEach>
	</select>
	<button>Add Category</button>
</form>
</body>
</html>