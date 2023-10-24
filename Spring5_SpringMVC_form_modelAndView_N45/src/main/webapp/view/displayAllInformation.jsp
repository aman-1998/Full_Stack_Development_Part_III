<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
</head>
<body>
First Name: ${fname}<br>
Last Name: ${lname}<br>
Gender: ${gender}<br>
Country: ${country}<br>
Languages: 
<c:forEach items="${languages}" var="lang">
${lang} | 
</c:forEach>
</body>
</html>