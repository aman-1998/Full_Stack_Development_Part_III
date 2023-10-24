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
<link href="${pageContext.request.contextPath}/additional/css/decorate-home.css" rel="stylesheet" />
</head>
<body>

<ul>
  <li><a class="active" href="${pageContext.request.contextPath}/">Home</a></li>
  <security:authorize access="isAuthenticated()">
  	<li><a href="${pageContext.request.contextPath}/notice">Notice</a></li>
  	<li><a href="${pageContext.request.contextPath}/holiday">Holiday List</a></li>
  </security:authorize>
  <li><a href="${pageContext.request.contextPath}/admission">Admission</a></li>
  <security:authorize access="hasRole('TEACHER')">
  	<li><a href="${pageContext.request.contextPath}/performance">Performance of Students</a></li>
  </security:authorize>
  <security:authorize access="hasRole('ADMIN')">
  	<li><a href="${pageContext.request.contextPath}/pendingFees">Pending Fees of Students</a></li>
  </security:authorize>
  <li><a href="${pageContext.request.contextPath}/about">About</a></li>
</ul>

<div style="margin-left:25%;padding:1px 16px;height:700px;">
  <p style="text-align: center">
	  <a href="${pageContext.request.contextPath}/">
		<img src="https://www.khems.co.in/wp-content/uploads/2016/11/khems-logo-composed-1.png" alt="KHEMS" height="120" width="118">
	  </a>
  </p>
  <h2 style="text-align: center">${school}</h2>
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
		<form:form action="${pageContext.request.contextPath}/logout" method="POST"> <%-- /logout is default and POST is mandatory --%>
			<input type="submit" value="Logout">
		</form:form>
	  </p>
  </security:authorize>
  <security:authorize access="!isAuthenticated()">
	<p>
		<a href="${pageContext.request.contextPath}/myLogin"><button>Login</button></a> <%-- By default GET --%>
	</p>
  </security:authorize>
  <hr>
  <h3>Principal's Desk</h3>
  <p>Keeping the contemporary global and national context in mind, we, at KANCHRAPARA HARNETT ENGLISH MEDIUM SCHOOL, 
  KANCHRAPARA, strive to make the pursuit of excellence a way of life; a habit. Our school is filled with enthusiastic 
  students willing to learn, supportive parents interested in their children's education, and a dedicated professional 
  staff committed to providing the students with a quality education. We provide a balanced environment focused on 
  shaping children into leaders of tomorrow by offering comprehensive education through a developmental approach. The 
  school environment promotes order, independence, a love for learning, a connection to the world and a sense of social 
  responsibility. KANCHRAPARA HARNETT ENGLISH MEDIUM SCHOOL, KANCHRAPARA, nurtures the leaders of tomorrow through a 
  unique, well-defined curriculum and a dedicated focus on "learning beyond the classroom."</p>
  <p>
  Mr. BIKASH CHANDRA PAUL
  <br>Principal, Kanchrapara Harnett Engish Medium School
  </p>
  <hr>

  <p>KANCHRAPARA HARNETT ENGLISH MEDIUM SCHOOL has made a huge leap in the field of  education by providing ample 
  opportunities so that the students can cultivate their innermost talent to pursue their greater aspiration and 
  stronger passion.</p>
  <p>The school provides such an optimum nourishing ground for every child with its scientific CBSE Syllabus, competent 
  faculty, the Wifi campus and State-of-the-Art Technology- all of which are as per global standard.</p>
  <p>The school has developed from strength to strength in the last few years, balancing a tight rope walk of culture 
  on one side and modern, scientific educational system on the other.</p>
  <jsp:include page="footer.jsp"></jsp:include>
</div>

</body>
</html>