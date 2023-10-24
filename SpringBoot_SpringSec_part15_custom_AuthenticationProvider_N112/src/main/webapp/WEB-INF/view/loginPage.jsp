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
	href="${pageContext.request.contextPath}/additional/css/decorate-login.css"
	rel="stylesheet" />
</head>
<body>

<div class="wrapper">
        <div class="logo">
            <img src="https://www.khems.co.in/wp-content/uploads/2016/11/khems-logo-composed-1.png" alt="Bharat">
        </div>
        <form:form class="p-3 mt-3" action="${pageContext.request.contextPath}/authenticateUser" method="POST"> <%-- POST is mandatory --%>
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="text" name="username" id="userName" placeholder="Username">
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="Password">
            </div>
            <button type="submit" class="btn mt-3">Login</button>
        </form:form>
        <div class="p-3 mt-3 extraPartLogin">
	        <a href="${pageContext.request.contextPath}/"><button class="btn mt-3">Home</button></a>
	    </div>
	    <div class="message text-center fs-6">
		    <c:if test="${param.error != null}">
				<p style="color: #ff0000;"><i><spring:message code="label.invalid.login.credential"/></i></p>
		    </c:if>
		    <c:if test="${param.logout != null}">
				<p style="color: #007d00"><i><spring:message code="label.successful.logout"/></i></p>
		    </c:if>
		    <c:if test="${param.registrationSuccess != null}">
				<p style="color: #007d00"><i><spring:message code="label.successful.registration"/></i></p>
		    </c:if>
	    </div>
        
    </div>

</body>
</html>