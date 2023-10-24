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
<p><span style="color: #f83053">Name:</span> ${name}<br>
<p><span style="color: #f83053">Date Of Birth:</span> <fmt:formatDate value="${dateOfBirth}" type="date"/><br>
<p><span style="color: #f83053">Gender:</span> ${gender}<br>
<p><span style="color: #f83053">Country:</span> ${country}<br>
<p><span style="color: #f83053">Languages:</span> 
<c:forEach items="${languages}" var="lang">
${lang} | 
</c:forEach><br>
<p><span style="color: #f83053">Address:</span> ${address}
</body>
</html>