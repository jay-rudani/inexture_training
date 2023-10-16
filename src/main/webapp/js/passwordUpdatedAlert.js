function showAlertAndRedirect() {

	alert("Password Updated!");

	setTimeout(function() {
		window.location.href = "login.jsp";
	}, 0);
}
showAlertAndRedirect();