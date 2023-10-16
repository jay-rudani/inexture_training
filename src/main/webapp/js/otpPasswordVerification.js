function verifyPassword() {
	let password = $("#password").val();
	let retypedPassword = $("#repassword").val();

	if (password == retypedPassword) {
		document.getElementById("messageForPasswordMatch").innerHTML = "";
		return true;
	} else if (!validatePassword()) {
		return false;
	} else if (password != retypedPassword) {
		document.getElementById("messageForPasswordMatch").innerHTML = "Password didn't match!";
		return false;
	} else {
		document.getElementById("messageForPasswordMatch").innerHTML = "";
		return false;
	}
}
function validatePassword() {

	let password = document.getElementById("password").value;
	let passwordMessage = document.getElementById("passwordMessage");

	const upperCaseRegex = /[A-Z]/;
	const lowerCaseRegex = /[a-z]/;
	const specialSymbolRegex = /[!@#$%]/;
	const numberRegex = /\d/;

	if (!(password.length) >= 8) {
		passwordMessage.innerHTML = "Password at least 8 characters long!";
		passwordMessage.style.color = "red";
		return false;
	} else if (!upperCaseRegex.test(password)) {
		passwordMessage.innerHTML = "Password should contain at least 1 uppercase letter!";
		passwordMessage.style.color = "red";
		return false;
	} else if (!lowerCaseRegex.test(password)) {
		passwordMessage.innerHTML = "Password should contain at least 1 lowercase letter!";
		passwordMessage.style.color = "red";
		return false;
	} else if (!specialSymbolRegex.test(password)) {
		passwordMessage.innerHTML = "Password should contain at least 1 of (!@#$%) symbol!";
		passwordMessage.style.color = "red";
		return false;
	} else if (!numberRegex.test(password)) {
		passwordMessage.innerHTML = "Password should contain at least 1 number (0-9)";
		passwordMessage.style.color = "red";
		return false;
	} else {
		passwordMessage.innerHTML = "";
		return true;
	}
}