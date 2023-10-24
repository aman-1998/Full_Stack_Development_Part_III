<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<link href="${pageContext.request.contextPath}/additional/css/decoration.css" rel="stylesheet">
</head>
<body>
<div id="mtoast" onclick="this.style.display='none'"></div>

<div class="container">
  <form:form name="myForm" action="${pageContext.request.contextPath}/displayInfo" method="get" modelAttribute="customer" onsubmit="return validateForm()">
    <div class="row">
      <div class="col-25">
        <label for="name">Full Name</label>
      </div>
      <div class="col-75">
        <%-- <input type="text" id="name" name="name" placeholder="Your full name..."> --%>
        <form:input id="name" path="name" placeholder="Your full name..."/>
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="dob">Date Of Birth</label>
      </div>
      <div class="col-75">
        <input type="date" id="dob" name="dob">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label for="genderMale">Gender</label>
      </div>
      <div class="col-75">
       <%-- <input type="radio" id="genderMale" name="gender" value="Male"> Male
        <input type="radio" id="genderFemale" name="gender" value="Female"> Female 
        <form:radiobutton id="genderMale" path="gender" value="Male"/> Male
        <form:radiobutton id="genderFemale" path="gender" value="Female"/> Female --%>
        <form:radiobuttons path="gender" items="${genderMap}" />
      </div>
    </div>
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
    <div class="row">
	    <div class="col-25">
	        <label for="gender">Languages</label>
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
	        <form:checkboxes items="${langMap}" path="language"/>
	      </div>
	    </div>
    <div class="row">
      <div class="col-25">
        <label for="address">Address</label>
      </div>
      <div class="col-75">
       <%-- <textarea id="address" name="address" placeholder="Write your address..." style="height:200px"></textarea> --%>
       <form:textarea id="address" path="address" cssStyle="height:200px" placeholder="Write your address..."/>
      </div>
    </div>
    <div class="row">
      <input type="submit" value="Submit">
      <input type="reset" value="Reset">
    </div>
  </form:form>
</div>
<script src="${pageContext.request.contextPath}/additional/js/validatingForm.js"></script>
</body>
</html>