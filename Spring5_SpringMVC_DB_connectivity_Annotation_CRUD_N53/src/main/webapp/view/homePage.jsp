<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="${pageContext.request.contextPath}/additional/css/beautify.css" rel="stylesheet">
</head>
<body>
<h1><u>A tutorial to learn spring form with client-side and server-side validation</u></h1>
<div class="register">
	<span class="click-here">Click here to register >>> </span>
	<a href="${pageContext.request.contextPath}/form"><button class="register-button">Registration Form</button></a>
</div>
<br>
<div class="listOfCustomers">
	<span class="click-here">Click here to view customers >>> </span>
	<a href="${pageContext.request.contextPath}/viewCustomers"><button class="view-button">View Customers</button></a>
</div>
</body>
</html>