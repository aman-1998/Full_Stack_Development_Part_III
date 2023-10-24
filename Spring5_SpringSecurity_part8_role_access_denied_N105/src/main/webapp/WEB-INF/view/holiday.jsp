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
<title>Holiday</title>
<link href="${pageContext.request.contextPath}/additional/css/decorate-home.css" rel="stylesheet" />
</head>
<body>

<ul>
  <li><a href="${pageContext.request.contextPath}/">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/notice">Notice</a></li>
  <li><a class="active" href="${pageContext.request.contextPath}/holiday">Holiday List</a></li>
  <li><a href="${pageContext.request.contextPath}/admission">Admission</a></li>
  <li><a href="${pageContext.request.contextPath}/performance">Performance of students</a></li>
  <li><a href="${pageContext.request.contextPath}/pendingFees">Pending Fees of students</a></li>
  <li><a href="${pageContext.request.contextPath}/about">About</a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:700px;">
  <p style="text-align: center">
	  <a href="${pageContext.request.contextPath}/">
		<img src="https://www.khems.co.in/wp-content/uploads/2016/11/khems-logo-composed-1.png" alt="KHEMS" height="120" width="118">
	  </a>
  </p>
  <h2 style="text-align: center">KANCHRAPARA HARNETT ENGLISH MEDIUM SCHOOL</h2>
  <hr>
  <security:authorize access="isAuthenticated()">
	  <table>
		<tr>
			<td><b>Username:</b> <security:authentication property="principal.username"/></td>
		</tr>
		<tr>
			<td><b>Role:</b> <security:authentication property="principal.authorities"/></td>
		</tr>
	  </table>
	  <p>
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout">
		</form:form>
	  </p>
  </security:authorize>
  <security:authorize access="!isAuthenticated()">
	<p>
		<a href="${pageContext.request.contextPath}/myLogin"><button>Login</button></a>
	</p>
  </security:authorize>
  <hr>
  <h3>HOLIDAY LIST</h3>
  	<table border="1">
  		<tr>
  			<th>Date</th>
  			<th>Holiday Name</th>
  			<th>Restricted</th>
  		</tr>
  		<tr>
  			<td>14-February-2022</td>
  			<td>Sankranti / Lorhi</td>
  			<td>Yes</td>
  		</tr>
  		<tr>
  			<td>14-February-2022</td>
  			<td>Sankranti / Lorhi</td>
  			<td>Yes</td>
  		</tr>
  		<tr>
  			<td>14-February-2022</td>
  			<td>Sankranti / Lorhi</td>
  			<td>Yes</td>
  		</tr>
  		<tr>
  			<td>14-February-2022</td>
  			<td>Sankranti / Lorhi</td>
  			<td>Yes</td>
  		</tr>
  		<tr>
  			<td>14-February-2022</td>
  			<td>Sankranti / Lorhi</td>
  			<td>Yes</td>
  		</tr>
  	</table>
  <jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>