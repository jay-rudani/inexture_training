<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("isLoggedIn") == null || session.getAttribute("isLoggedIn").equals(false)) {
	response.sendRedirect("login.jsp");
} else {
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Home</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/all.min.css" />
    <link rel="stylesheet" href="css/profile.css" />
    <link rel="stylesheet" href="css/navbar.css" />
    
</head>
<body>
	<jsp:include page="navbar.jsp" />
	<jsp:include page="profile.jsp" />
	
	<script src="js/jquery-3.7.0.min.js"></script>
    <script src="js/populateCSCData.js"></script>
    <script src="js/jquery.repeater.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/profileFieldDisabler.js"></script>
    
</body>
</html>
<%
}
%>