<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter Page</title>
</head>
<body>
	<div id="main">
	<p>You have visited the website
	<span id="counter"><c:out value="${count}"/></span>
	times.</p>
	<br>
	<a href="/">Test another visit?</a>
	</div>

</body>
</html>