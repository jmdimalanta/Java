<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a License</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/license/create" method="post" modelAttribute="newLicense">
		<p>
			<form:select path="person">
			<c:forEach items="${allPersons}" var= "person">
				<option value="${person.id}">${person.firstName }${person.lastName}</option>			
			</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="state">State:</form:label>
			<form:input path="state"/>
		</p>
		<p>
			<form:label path="expiration_date">Expiration Date:</form:label>
			<input type="date" id="date" name="expiration_date">
		</p>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>