function showAlertAndRedirect() {

	alert("Error while registering!");

	setTimeout(function() {
		window.location.href = "register.jsp";
	}, 0);
}
showAlertAndRedirect();