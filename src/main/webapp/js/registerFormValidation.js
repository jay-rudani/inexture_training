function validateFields() {

	let email = document.getElementById("email");
	let firstName = document.getElementById("firstname");
	let lastName = document.getElementById("lastname");
	let password = document.getElementById("password");
	let username = document.getElementById("username");
	let birthDate = document.getElementById("birthdate");

	let regexEmail =
		/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	let regexFirstName = /^[A-Z][a-z]*$/;
	let regexLastName = /^[A-Z][a-z]*$/;
	
	if(!email.value.match(regexEmail)){
		alert("Not a valid email address!");
		return false;
	}
	if(!firstName.value.match(regexFirstName)){
		$("#not-valid-firstname-message").removeClass("d-none");
		return false;
	}
	if(!lastName.value.match(regexLastName)){
		alert("Last name should start with Uppercase!");
		return false;
	}
	
	

	return true;
}
