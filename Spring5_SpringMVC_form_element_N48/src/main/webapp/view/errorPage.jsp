<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="${pageContext.request.contextPath}/additional/css/decoration.css" rel="stylesheet">
</head>
<body>
<h1><u>List of errors:-</u></h1>
<div id="serverSideErrorArea">
<c:forEach items="${errorList}" var="error">
<h4 style="color: red">${error}</h4><br>
</c:forEach>
</div>
</body>
</html>