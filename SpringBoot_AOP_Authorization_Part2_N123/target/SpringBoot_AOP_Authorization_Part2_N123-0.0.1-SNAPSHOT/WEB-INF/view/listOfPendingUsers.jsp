<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending</title>
<link href="${pageContext.request.contextPath}/additional/css/decorate-authorization.css" rel="stylesheet">
</head>
<body>
<h3>Pending User Registration requests:</h3>
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Username</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>Gender</th>
			<th colspan="2">Operations</th>
		</tr>
		<c:if test="${empty pendingUsers}">
			<tr>
				<td colspan="7">
					<p class ="noRecordFound ">No record found</p>
				</td>
			</tr>
		</c:if>
		<c:forEach items="${pendingUsers}" var="user">
			<tr>
				<td>${user.userName}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td>${user.email}</td>
				<td>${user.gender}</td>
				<td>
                    <form class="accept" action="${pageContext.request.contextPath}/authorization/acceptAuth" method="GET">
						<input type="hidden" name="username" value="${user.userName}" />
						<input type="submit" value="Accept" />
					</form>
				</td>
				<td>
					<form class="reject" action="${pageContext.request.contextPath}/authorization/rejectAuth" method="GET">
						<input type="hidden" name="username" value="${user.userName}" />
						<input type="submit" value="Reject" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>