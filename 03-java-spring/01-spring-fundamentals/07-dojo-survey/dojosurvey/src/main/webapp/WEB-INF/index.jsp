<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
</head>
<body>
<h1>Welcome!</h1>
<form action="/survey" method="POST">
<p> Name: <input type="text" name="name"></p>
<p>Dojo Location: 
<select name = "location">
	<option value="San Jose">San Jose</option>
	<option value="Seattle">Seattle</option>
	<option value="Dallas">Dallas</option>
	</select>
</p>
<p>Favorite Language:
	<select name = "language">
	<option value="Java">Java</option>
	<option value="Python">Python</option>
	<option value="MERN">MERN</option>
	</select>
</p>
<p><button>Submit</button></p>
</form>
</body>
</html>