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
<link href="${pageContext.request.contextPath}/additional/css/decorate-authorization.css" rel="stylesheet">
</head>
<body>
<div class="home-refresh">
	<a href="${pageContext.request.contextPath}/"><button class="home">Home</button></a>
	<a href="${pageContext.request.contextPath}/viewPendingUsers"><button class="refresh">Refresh</button></a><br>
</div>
<h2>Authorize Registration Requests:-</h2>

<div class="tab">
  <button class="tablinks active" onclick="openRequest(event, 'Pending')">Pending Requests</button>
  <button class="tablinks" onclick="openRequest(event, 'Accepted')">Accepted Requests</button>
  <button class="tablinks" onclick="openRequest(event, 'Rejected')">Rejected Requests</button>
</div>

<div id="Pending" class="tabcontent">
  <jsp:include page="listOfPendingUsers.jsp"></jsp:include>
</div>

<div id="Accepted" class="tabcontent">
  <jsp:include page="listOfAcceptedUsers.jsp"></jsp:include>
</div>

<div id="Rejected" class="tabcontent">
  <jsp:include page="listOfRejectedUsers.jsp"></jsp:include>
</div>

<script>
function openRequest(evt, request) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(request).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>

</body>
</html>