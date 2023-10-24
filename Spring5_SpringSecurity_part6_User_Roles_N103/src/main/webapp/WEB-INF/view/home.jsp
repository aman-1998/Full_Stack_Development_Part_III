<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Hola!! This our home page.</h1>
<hr>
<p>Username: <security:authentication property="principal.username" /></p>
<p>Roles: <security:authentication property="principal.authorities" /></p>
<hr>
<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout">
</form:form>
</body>
</html>