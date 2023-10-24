function validateForm() {
  //Name validation
  let name = document.forms["myForm"]["name"].value;
  if (name == "") {
	var toast = document.getElementById("mtoast");
    var errorMsg = "Name can not be empty";
  	var imageSrc = "<img draggable='false' src='http://localhost:8080/Spring5_SpringMVC_form_customized_error_message_N47/additional/images/warning.png' width='35px' height='35px' style='vertical-align:middle;'>";
  	toast.innerHTML = imageSrc + "<span style='vertical-align:middle; font-family:Bodoni MT'>"+"&nbsp;&nbsp;"+errorMsg+"</span>";
  	toast.style.display = "block";
    return false;
  }
  
  //DOB validation
  let dob = document.forms["myForm"]["dob"].value;
  if (dob == "") {
    var toast = document.getElementById("mtoast");
    var errorMsg = "Date of birth can not be empty";
  	var imageSrc = "<img draggable='false' src='http://localhost:8080/Spring5_SpringMVC_form_customized_error_message_N47/additional/images/warning.png' width='35px' height='35px' style='vertical-align:middle;'>";
  	toast.innerHTML = imageSrc + "<span style='vertical-align:middle; font-family:Bodoni MT'>"+"&nbsp;&nbsp;"+errorMsg+"</span>";
  	toast.style.display = "block";
    return false;
  }
  
  //Gender validation
  let gender = document.forms["myForm"]["gender"].value;
  if (gender == "") {
    var toast = document.getElementById("mtoast");
    var errorMsg = "Gender must be selected";
  	var imageSrc = "<img draggable='false' src='http://localhost:8080/Spring5_SpringMVC_form_customized_error_message_N47/additional/images/warning.png' width='35px' height='35px' style='vertical-align:middle;'>";
  	toast.innerHTML = imageSrc + "<span style='vertical-align:middle; font-family:Bodoni MT'>"+"&nbsp;&nbsp;"+errorMsg+"</span>";
  	toast.style.display = "block";
    return false;
  }
  
  //Country validation
  let country = document.forms["myForm"]["country"].value;
  if (country == "") {
    var toast = document.getElementById("mtoast");
    var errorMsg = "Country must be selected";
  	var imageSrc = "<img draggable='false' src='http://localhost:8080/Spring5_SpringMVC_form_customized_error_message_N47/additional/images/warning.png' width='35px' height='35px' style='vertical-align:middle;'>";
  	toast.innerHTML = imageSrc + "<span style='vertical-align:middle; font-family:Bodoni MT'>"+"&nbsp;&nbsp;"+errorMsg+"</span>";
  	toast.style.display = "block";
    return false;
  }
  
  //Language validation
  let language = document.querySelectorAll('input[type=checkbox]:checked');
  if (language.length == 0) {
    var toast = document.getElementById("mtoast");
    var errorMsg = "At least one language must be selected";
  	var imageSrc = "<img draggable='false' src='http://localhost:8080/Spring5_SpringMVC_form_customized_error_message_N47/additional/images/warning.png' width='35px' height='35px' style='vertical-align:middle;'>";
  	toast.innerHTML = imageSrc + "<span style='vertical-align:middle; font-family:Bodoni MT'>"+"&nbsp;&nbsp;"+errorMsg+"</span>";
  	toast.style.display = "block";
    return false;
  }
  
  //Address validation
//  let address = document.forms["myForm"]["address"].value;
//  if (address == "") {
//    alert("Address can't be empty");
//    return false;
//  }
  
}