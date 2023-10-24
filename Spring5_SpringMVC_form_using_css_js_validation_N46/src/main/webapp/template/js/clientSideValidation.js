function validateForm() {
  //Name validation
  let name = document.forms["myForm"]["name"].value;
  if (name == "") {
    alert("Name can't be empty");
    return false;
  }
  
  //DOB validation
  let dob = document.forms["myForm"]["dob"].value;
  if (dob == "") {
    alert("Date of birth can't be empty");
    return false;
  }
  
  //Gender validation
  let gender = document.forms["myForm"]["gender"].value;
  if (gender == "") {
    alert("Gender can't be empty");
    return false;
  }
  
  //Country validation
  let country = document.forms["myForm"]["country"].value;
  if (country == "") {
    alert("Country can't be empty");
    return false;
  }
  
  //Language validation
  let language = document.querySelectorAll('input[type=checkbox]:checked');
  if (language.length == 0) {
    alert("Language can't be empty");
    return false;
  }
  
  //Address validation
//  let address = document.forms["myForm"]["address"].value;
//  if (address == "") {
//    alert("Address can't be empty");
//    return false;
//  }
  
}