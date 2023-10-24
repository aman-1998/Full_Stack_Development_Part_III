<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style>

.failed {
	color : red;
}

</style>
</head>
<body>
<h2>Custom Login Form</h2>
<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
	
	<%-- If user login fails then  springSecurity redirects to loginPage.jsp and 'error' is appended to the loginPage url as a queryParameter --%>
	<c:if test="${param.error != null}">
		<i class="failed"><spring:message code="label.invalid.login.credential"/></i>
	</c:if>
	
	<p>
		<input type="text" name="username" placeholder="Username"/> 
	<%-- name should be strictly username then only SpringSecurity will understand--%>
	<%-- <form:input path="username" /> This doesn't work here --%>
	</p>
	
	<p>
		<input type="password" name="password" placeholder="password"/> 
	<%-- name should be strictly password then only SpringSecurity will understand--%>
	<%-- <form:password path="password" /> This doesn't work here --%>
	</p>
	<input type="submit" name="Login" />
</form:form>
</body>
</html>