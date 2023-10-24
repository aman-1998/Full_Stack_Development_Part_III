<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information of Customers</title>
<link href="${pageContext.request.contextPath}/additional/css/beautify.css" rel="stylesheet">
</head>
<body>
<div class="home-refresh">
	<a href="${pageContext.request.contextPath}"><button class="home">Home</button></a>
	<a href="${pageContext.request.contextPath}/viewCustomers"><button class="refresh">Refresh</button></a><br>
</div>
<h2>List Of All Customers:-</h2>
<div style="overflow-x:auto;">
	<table>
		<tr>
			<th>Name</th>
			<th>Email Id</th>
			<th>Date Of Birth</th>
			<th>Gender</th>
			<th>Country</th>
			<th>Language</th>
			<th>Address</th>
			<th colspan="2">Operations</th>
		</tr>
		<c:forEach items="${listOfCustomers}" var="customer">
			<tr>
				<td>${customer.name}</td>
				<td>${customer.email}</td>
				<td><fmt:formatDate value="${customer.dateOfBirth}" type="date"/></td>
				<td>${customer.gender}</td>
				<td>${customer.countryName}</td>
				<td>
					<ul>
						<c:forEach items="${customer.language}" var="lang">
							<c:if test="${not empty lang}">
								<li>${lang}
							</c:if>
						</c:forEach>
					</ul>
				</td>
				<td>${customer.address}</td>
				<td>
					<c:url var="updateCus" value="updateCustomerInfo">
	                <%-- <c:param name="operation" value="updateCustomer"></c:param> --%>
	                    <c:param name="name" value="${customer.name}"></c:param>
	                    <c:param name="email" value="${customer.email}"></c:param>
	                    <c:param name="dob" value="${customer.dob}"></c:param>
	                    <c:param name="gender" value="${customer.gender}"></c:param>
	                    <c:param name="country" value="${customer.country}"></c:param>
	                    <c:param name="countryName" value="${customer.countryName}"></c:param>
	                    <c:param name="language" value="${customer.language}"></c:param>
	                    <c:param name="address" value="${customer.address}"></c:param>
	                </c:url>
					<a href="${updateCus}"><button class="update">Update</button></a>
				</td>
				<td>
					<form action="${pageContext.request.contextPath}/deleteCustomer" method="post">
						<input type="hidden" name="email" value="${customer.email}" />
						<input onclick="if(!confirm('Are You sure you want to delete this customer ?')) return false" type="submit" value="Delete" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>