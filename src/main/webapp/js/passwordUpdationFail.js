function showAlertAndRedirect() {

	alert("Error while forgotting password! Please try again.");

	setTimeout(function() {
		window.location.href = "ForgotPassword.jsp";
	}, 0);
}
showAlertAndRedirect();