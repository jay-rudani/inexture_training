function showAlertAndRedirect() {

	alert("No account is registered with this Email!");

	setTimeout(function() {
		window.location.href = "ForgotPassword.jsp";
	}, 0);
}
showAlertAndRedirect();