<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link
	href="${pageContext.request.contextPath}/additional/css/decoration.css"
	rel="stylesheet" />
</head>
<body>

<div class="wrapper">
        <div class="logo">
            <img src="https://www.freepnglogos.com/uploads/flag-logo-png/flag-logo-transparent-india-flag-23.png" alt="Bharat">
        </div>
        <form:form class="p-3 mt-3" action="${pageContext.request.contextPath}/authenticateUser" method="POST">
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="username" id="userName" placeholder="Username">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="Password">
            </div>
            <c:if test="${param.error != null}">
	        <div class="text-center fs-6">
	            <p class="failed"><i>Invalid username / password</i></p>
	        </div>
        </c:if>
            <button type="submit" class="btn mt-3">Login</button>
        </form:form>
    </div>

</body>
</html>