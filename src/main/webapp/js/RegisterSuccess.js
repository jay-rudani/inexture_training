function showAlertAndRedirect() {

	alert("Registered!");

	setTimeout(function() {
		window.location.href = "login.jsp";
	}, 0);
}
showAlertAndRedirect();