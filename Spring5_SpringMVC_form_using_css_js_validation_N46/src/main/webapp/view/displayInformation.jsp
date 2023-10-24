<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
</head>
<body>
Name: ${name}<br>
Date Of Birth: <fmt:formatDate value="${dateOfBirth}" type="date"/><br>
Gender: ${gender}<br>
Country: ${country}<br>
Languages: 
<c:forEach items="${languages}" var="lang">
${lang} | 
</c:forEach><br>
Address: ${address}
</body>
</html>