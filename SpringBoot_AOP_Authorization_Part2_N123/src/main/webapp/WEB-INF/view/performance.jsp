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
<title>Performance</title>
<link href="${pageContext.request.contextPath}/additional/css/decorate-home.css" rel="stylesheet" />
</head>
<body>

<ul>
  <li><a href="${pageContext.request.contextPath}/">Home</a></li>
  <security:authorize access="isAuthenticated()">
  	<li><a href="${pageContext.request.contextPath}/notice">Notice</a></li>
  	<li><a href="${pageContext.request.contextPath}/holiday">Holiday List</a></li>
  </security:authorize>
  <li><a href="${pageContext.request.contextPath}/admission">Admission</a></li>
  <security:authorize access="hasAuthority('TEACHER')">
  	<li><a class="active" href="${pageContext.request.contextPath}/performance">Performance of Students</a></li>
  </security:authorize>
  <security:authorize access="hasAuthority('ADMIN')">
  	<li><a href="${pageContext.request.contextPath}/pendingFees">Pending Fees of Students</a></li>
  </security:authorize>
  <li><a href="${pageContext.request.contextPath}/about">About</a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:700px;">
  <p style="text-align: center">
	  <a href="${pageContext.request.contextPath}/">
		<img src="${pageContext.request.contextPath}/additional/images/khems.png" alt="KHEMS" height="90" width="200">
	  </a>
  </p>
  <h2 style="text-align: center">${schoolName}</h2>
  <hr>
  <div class="float-parent-element">
  	  <security:authorize access="isAuthenticated()">
		  <div class="float-child-element1">
		  	<div class="red">
				  <table>
					<tr>
						<td><b>Username:</b> <security:authentication property="principal.username"/></td>
					</tr>
					<tr>
						<td><b>Role:</b> <security:authentication property="principal.authorities"/></td>
					</tr>
				  </table>
		  	</div>
		  </div>
		  <div class="float-child-element2">
		    <div class="yellow">
		    
		    	<table>
					<tr>
						<td>
							<security:authorize access="hasAuthority('ADMIN')">
						 		<form:form action="${pageContext.request.contextPath}/viewPendingUsers" method="GET">
									<input type="submit" value="Pending Request">
						 		</form:form> 
				      		</security:authorize>
						</td>
						<td> 
							<form:form action="${pageContext.request.contextPath}/logout" method="POST">
								<input type="submit" value="Logout">
							</form:form> 
						</td>
					</tr>
			    </table>
		    </div>
		  </div>
	  </security:authorize>
  </div>
  <div class="float-parent-element">
	  <security:authorize access="!isAuthenticated()">
		<p>
			<a href="${pageContext.request.contextPath}/myLogin"><button>Login</button></a>
			<a href="${pageContext.request.contextPath}/registration"><button>Registration</button></a> <%-- By default GET --%>
		</p>
	  </security:authorize>
	  <hr>
	  <h3>PERFORMANCE OF STUDENTS</h3>
	  <p>
	  	Performance of all students from all classes are saved in database which can be seen from here.
	  </p>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>