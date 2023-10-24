<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
</head>
<body>
	<form action="<%= request.getContextPath() %>/displayInformation" method="post">
		First Name: <input type="text" name="fname" placeholder="First Name" required>&nbsp;&nbsp;
		Last Name: <input type="text" name="lname" placeholder="Last Name"><br>
		
		Gender: <input type="radio"  name="gender" value="Male" checked="checked"> Male&nbsp;&nbsp;
				<input type="radio" name="gender" value="Female"> Female<br>
		
		Languages Known: <input type="checkbox" name="language" value="Hindi"> Hindi&nbsp;&nbsp;
						 <input type="checkbox" name="language" value="English"> English&nbsp;&nbsp;
						 <input type="checkbox" name="language" value="Sanskrit"> Sanskrit<br>
						 
		Country: <select name="country">
				 	<option value="Nepal">Nepal</option>
				 	<option value="China">China</option>
				 	<option value="India">India</option>
				 	<option value="USA">USA</option>
				 	<option value="Russia">Russia</option>
				 	<option value="Australia">Australia</option>
				 </select><br>
		<input type="submit" value="submit">
	</form>
</body>
</html>