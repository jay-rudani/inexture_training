function showAlertAndRedirect() {

	alert("Wrong Id or Password!");

	setTimeout(function() {
		window.location.href = "login.jsp";
	}, 0);
}
showAlertAndRedirect();