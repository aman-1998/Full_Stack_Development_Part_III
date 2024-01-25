<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accepted</title>
<link href="${pageContext.request.contextPath}/additional/css/decorate-authorization.css" rel="stylesheet">
</head>
<body>
<h3>Accepted User Registration requests:</h3>
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Gender</th>
			<th>Accepted By<th>
		</tr>
		<c:if test="${empty acceptedUsers}">
			<tr>
				<td colspan="6">
					<p class ="noRecordFound ">No record found</p>
				</td>
			</tr>
		</c:if>
		<c:forEach items="${acceptedUsers}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.gender}</td>
				<td>${user.actionBy}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>