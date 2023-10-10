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
  </head>
  <body>
    <section class="register-container">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="neumorphic-bg">
              <form id="registerForm" action="RegisterServlet" method="post" enctype="multipart/form-data" onsubmit="return validateFields()">
                <div class="form-group">
                  <label for="profilepic" class="fileLabel"><b class="addIcon">Add Image</b></label>
                  <input
                    type="file"
                    id="profilepic"
                    name="profilepic"
                    class="form-control"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="firstname">First Name :</label>
                  <input
                    type="text"
                    name="firstname"
                    id="firstname"
                    class="form-control"
                    required
                  />
                  <small id="firstNameMessage"></small>
                </div>
                <div class="form-group">
                  <label for="lastname">Last Name :</label>
                  <input
                    type="text"
                    name="lastname"
                    id="lastname"
                    class="form-control"
                    required
                  />
                  <small id="lastNameMessage"></small>
                </div>
                <div class="form-group">
                  <label for="email">Email :</label>
                  <input
                    type="email"
                    name="email"
                    id="email"
                    class="form-control"
                    required
                  />
                  <small id="emailMessage"></small>
                </div>
                <div class="form-group">
                  <label for="username">Username :</label>
                  <input
                    type="text"
                    name="username"
                    id="username"
                    class="form-control"
                    required
                  />
                  <small id="userNameMessage"></small>
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
                  <small id="passwordMessage"></small>
                </div>
                <div class="form-group">
                  <label for="birthdate">Birth Date :</label>
                  <input
                    type="date"
                    name="birthdate"
                    id="birthdate"
                    class="form-control"
                    required
                  />
                  <small id="birthDateMessage"></small>
                </div>
                <div data-repeater-list="items">
					<div data-repeater-item>
                		<jsp:include page="address.jsp" />
                	</div>
                </div>
                <div class="form-group">
                	<button id="addAnotherBtn" data-repeater-create type="button" class="btn btn-secondary">
        				Add another
      				</button>
                </div>
                <div class="form-group">
                  <p>Gender :</p>
                  <input
                    type="radio"
                    name="gender"
                    id="male"
                    value="Male"
                    required
                  />
                  <label for="male">Male</label>
                  <br />
                  <input
                    type="radio"
                    name="gender"
                    id="female"
                    value="Female"
                    required
                  />
                  <label for="female">Female</label>
                </div>
                <div class="form-group">
                  <p>Known Languages :</p>
                  <input
                    type="checkbox"
                    name="languages"
                    id="english"
                    value="English"
                  />
                  <label for="english">English</label>
                  <br />
                  <input
                    type="checkbox"
                    name="languages"
                    id="hindi"
                    value="Hindi"
                  />
                  <label for="hindi">Hindi</label>
                  <br />
                  <input
                    type="checkbox"
                    name="languages"
                    id="gujarati"
                    value="Gujarati"
                  />
                  <label for="gujarati">Gujarati</label>
                </div>
                <div class="d-flex justify-content-around">
                	<button type="submit" class="btn btn-success">Register</button>
                	<a class="btn btn-primary" href="login.jsp">
                		Login
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
    <script src="js/jquery.repeater.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/registerFormValidation.js"></script>
    <script src="js/populateCSCData.js"></script>
  </body>
</html>
