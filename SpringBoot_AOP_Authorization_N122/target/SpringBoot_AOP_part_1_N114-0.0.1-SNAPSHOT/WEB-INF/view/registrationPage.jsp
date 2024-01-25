<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>

<link href="${pageContext.request.contextPath}/additional/css/decorate-registration.css" rel="stylesheet">

</head>
<body>
<div class="mtoast">
	<div class="error-container">
		<div class="warning" style="float: left;">
			<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
		</div>
		<div class="errorMsgDiv" style="float: left;">
			<span class="errorMessage" style="vertical-align:middle;"></span>
		</div>
		<div class="close" style="float: left;">
			<img onclick="vanishClientSideError()" draggable="false" src="${pageContext.request.contextPath}/additional/images/cross.png" width="22px" height="22px" style="vertical-align:middle;">
		</div>
	</div>
</div>

<div class="home-refresh">
	<a href="${pageContext.request.contextPath}/"><button class="home">Home</button></a>
	<a href="${pageContext.request.contextPath}/registration"><button class="refresh">Refresh</button></a><br>
</div>

<div class="container">
  <form:form name="myForm" action="${pageContext.request.contextPath}/registration" method="post" modelAttribute="user" onsubmit="return validateForm()">
    
    <%-- Error Block --%>
    <c:set var="usernameHasBindError">
		<form:errors path="username"/>
	</c:set>
	<c:set var="passwordHasBindError">
		<form:errors path="password"/>
	</c:set>
	<c:set var="emailHasBindError">
		<form:errors path="email"/>
	</c:set>
	<c:set var="firstNameHasBindError">
		<form:errors path="firstName"/>
	</c:set>
	<c:set var="dobHasBindError">
		<form:errors path="dob"/>
	</c:set>
	<c:set var="genderHasBindError">
		<form:errors path="gender"/>
	</c:set>
	<c:set var="countryHasBindError">
		<form:errors path="country"/>
	</c:set>
	<c:set var="langHasBindError">
		<form:errors path="listOfLang"/>
	</c:set>
	<c:set var="roleHasBindError">
		<form:errors path="listOfRole"/>
	</c:set>
	
	<c:if test="${not empty usernameHasBindError ||  not empty passwordHasBindError || not empty emailHasBindError || not empty firstNameHasBindError || not empty dobHasBindError || not empty genderHasBindError || not empty countryHasBindError || not empty langHasBindError || not empty roleHasBindError}">
		<div class="mtoast2">
	    	<div class="error-container">
				<div class="multiple-errors" style="float: left;">
					<c:if test="${not empty usernameHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${usernameHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty passwordHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${passwordHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty emailHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${emailHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty firstNameHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${firstNameHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty dobHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${dobHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty genderHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${genderHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty countryHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${countryHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty langHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${langHasBindError}</span>
							</div>
						</div>
					</c:if>
					<c:if test="${not empty roleHasBindError}">
						<div class="single-error">
							<div class="warning" style="float: left;">
								<img draggable="false" src="${pageContext.request.contextPath}/additional/images/warning.png" width="28px" height="28px" style="vertical-align:middle;">
							</div>
							<div class="errorMsgDiv" style="float: left;">
								<span class="errorMessage" style="vertical-align:middle;">${roleHasBindError}</span>
							</div>
						</div>
					</c:if>
				</div>
				<div class="close" style="float: left;">
					<img onclick="vanishServerSideError()" draggable="false" src="${pageContext.request.contextPath}/additional/images/cross.png" width="22px" height="22px" style="vertical-align:middle;">
				</div>
			</div>
		</div>
	</c:if>
	<%--End Of Error Block --%>
	
	<%-- Username --%>
    <div class="row">
      <div class="col-25">
        <label for="username">Username</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="username" name="username" placeholder="Your username..."> --%>
        <form:input id="username" path="username" placeholder="Your username..."/>
      </div>
    </div>
    
    <%-- Password --%>
    <div class="row">
      <div class="col-25">
        <label for="password">Password</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="password" name="password" placeholder="Your password..."> --%>
        <form:password id="password" path="password" placeholder="Your Password..."/>
      </div>
    </div>
    
    <%-- First Name --%>
    <div class="row">
      <div class="col-25">
        <label for="firstName">First Name</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="firstName" name="firstName" placeholder="Your first name..."> --%>
        <form:input id="firstName" path="firstName" placeholder="Your first name..."/>
      </div>
    </div>
    
    <%-- Last Name --%>
    <div class="row">
      <div class="col-25">
        <label for="lastName">Last Name</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="lastName" name="lastName" placeholder="Your last name..."> --%>
        <form:input id="lastName" path="lastName" placeholder="Your last name..."/>
      </div>
    </div>
    
    <%-- Email Id --%>
    <div class="row">
      <div class="col-25">
        <label for="email">Email Id</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="email" name="email" placeholder="abc@gmail.com"> --%>
        <form:input id="email" path="email" placeholder="abc@gmail.com"/>
      </div>
    </div>
    
    <%-- Date of birth --%>
    <div class="row">
      <div class="col-25">
        <label for="dob">Date Of Birth</label>
      </div>
      <div class="col-75">
        <input type="date" id="dob" name="dob" autocomplete="on">
      </div>
    </div>
    
    <%-- Gender --%>
    <div class="row">
      <div class="col-25">
        <label for="gender">Gender</label>
      </div>
      <div class="col-75">
       <%-- <input type="radio" id="genderMale" name="gender" value="Male"> Male
        <input type="radio" id="genderFemale" name="gender" value="Female"> Female 
        <form:radiobutton id="genderMale" path="gender" value="Male"/> Male
        <form:radiobutton id="genderFemale" path="gender" value="Female"/> Female --%>
        <form:radiobuttons id="gender" path="gender" items="${genderMap}" />
      </div>
    </div>
    
    <%-- Country --%>
    <div class="row">
      <div class="col-25">
        <label for="country">Country</label>
      </div>
      <div class="col-75">
        <%-- <select id="country" name="country">
          <option value="Australia">Japan</option>
          <option value="United Kingdom">United Kingdom</option>
          <option value="India">India</option>
          <option value="USA">USA</option>
        </select> --%>
        <form:select id="country" path="country" items="${countryMap}" />
      </div>
    </div>
    
    <%-- Languages --%>
    <div class="row">  
	    <div class="col-25">
	        <label for="lang">Languages</label>
	      </div>
	      <div class="col-75">
	        <%-- <input type="checkbox" id="langHindi" name="language" value="Hindi"> Hindi
	        <input type="checkbox" id="langEnglish" name="language" value="English"> English
	        <input type="checkbox" id="langSanskrit" name="language" value="Sanskrit"> Sanskrit
	        <input type="checkbox" id="langMaithili" name="language" value="Maithili"> Mathili 
	        <form:checkbox id="langHindi" path="language" value="Hindi"/> Hindi
	        <form:checkbox id="langEnglish" path="language" value="English"/> English
	        <form:checkbox id="langSanskrit" path="language" value="Sanskrit"/> Sanskrit
	        <form:checkbox id="langMaithili" path="language" value="Mathili"/> Mathili --%>
	        <form:checkboxes id="lang" items="${langMap}" path="listOfLang"/>
	      </div>
	</div>
	
	<%-- Role --%>
    <div class="row">  
	    <div class="col-25">
	        <label for="lang">Role</label>
	      </div>
	      <div class="col-75">
	        <%-- <input type="checkbox" id="langHindi" name="language" value="Hindi"> Hindi
	        <input type="checkbox" id="langEnglish" name="language" value="English"> English
	        <input type="checkbox" id="langSanskrit" name="language" value="Sanskrit"> Sanskrit
	        <input type="checkbox" id="langMaithili" name="language" value="Maithili"> Mathili 
	        <form:checkbox id="langHindi" path="language" value="Hindi"/> Hindi
	        <form:checkbox id="langEnglish" path="language" value="English"/> English
	        <form:checkbox id="langSanskrit" path="language" value="Sanskrit"/> Sanskrit
	        <form:checkbox id="langMaithili" path="language" value="Mathili"/> Mathili --%>
	        <form:checkboxes id="role" items="${roleMap}" path="listOfRole"/>
	      </div>
	</div>
	
	<%-- Address --%>
    <div class="row">
      <div class="col-25">
        <label for="address">Address</label>
      </div>
      <div class="col-75">
       <%-- <textarea id="address" name="address" placeholder="Write your address..." style="height:200px"></textarea> --%>
       <form:textarea id="address" path="address" cssStyle="height:200px" placeholder="Write your address..."/>
      </div>
    </div>
    
    <%-- Submit and Reset --%>
    <div class="row">
       <input type="submit" value="Submit"> 
      <%--<button type="submit">Submit</button>--%>
      <input type="reset" value="Reset">
    </div>
    
  </form:form>
</div>
<script src="${pageContext.request.contextPath}/additional/js/customer.js"></script>
</body>
</html>