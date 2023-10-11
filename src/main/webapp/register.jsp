<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/all.min.css" />
    <link rel="stylesheet" href="css/register.css" />
    <link rel="stylesheet" href="css/profile.css" />
    <link rel="stylesheet" href="css/navbar.css" />
    <script src="js/jquery-3.7.0.min.js"></script>
    <script src="js/populateCSCData.js"></script>
  </head>
  <body>
  	<%
  		if(request.getSession().getAttribute("isLoggedIn")!=null && request.getSession().getAttribute("isLoggedIn").equals(true)){
  	%>
  		<jsp:include page="navbar.jsp"></jsp:include>
  	<%
  		}
  	%>
    <section class="register-container">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="neumorphic-bg">
              <form id="registerForm" action="RegisterServlet" method="post" enctype="multipart/form-data" onsubmit="return validateFields()">
                <jsp:include page="form.jsp"></jsp:include>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- bootstrap related scripts -->
    <script src="js/jquery.repeater.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registerFormValidation.js"></script>
  </body>
</html>
