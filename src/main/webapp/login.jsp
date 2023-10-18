<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<title>Login</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/all.min.css" />
    <link rel="stylesheet" href="css/profile.css" />
    <link rel="stylesheet" href="css/login.css" />
</head>
<body>
	<section class="login-container">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="neumorphic-bg">
              <form id="loginForm" action="LoginServlet" method="post">
                <div class="form-group">
                  <label for="emailOrUsername">Email or Username :</label>
                  <input
                    type="text"
                    name="emailOrUsername"
                    id="emailOrUsername"
                    class="form-control"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="password">Password :</label>
                  <input
                    type="password"
                    name="password"
                    id="password"
                    class="form-control"
                    required
                  />
                  <div class="form-group mt-2">
                  	<a class="btn-link" href="ForgotPassword.jsp">Forgot Password?</a>
                  </div>
                </div>
                <div class="d-flex justify-content-around">
                	<button type="submit" class="btn btn-success">Login</button>
                	<a class="btn btn-primary" href="register.jsp">
                		Register
                	</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- bootstrap related scripts -->
    <script src="js/jquery-3.7.0.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
	    function preventBack() { window.history.forward(); }  
	    setTimeout("preventBack()", 0);  
	    window.onunload = function () { null };
    </script>
</body>
</html>