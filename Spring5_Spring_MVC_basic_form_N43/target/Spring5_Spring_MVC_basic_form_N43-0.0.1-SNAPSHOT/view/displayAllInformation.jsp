<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information</title>
</head>
<body>
First Name: <%= request.getAttribute("fname") %><br>
Last Name: <%= request.getAttribute("lname") %><br>
Gender: <%= request.getAttribute("gender") %><br>
Country: <%= request.getAttribute("country") %><br>
Languages: 
<%
	String[] languages = (String[])request.getAttribute("languages");
	for(String lang : languages){
		out.print(lang+" ");
	}
%>
</body>
</html>