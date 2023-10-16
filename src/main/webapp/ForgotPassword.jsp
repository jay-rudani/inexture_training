<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>Forgot Password</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/forgotpass.css" />
  </head>
  <body>
    <section class="forgotPassSection">
      <div class="container">
        <div class="row">
          <div class="col-md-12 mx-auto">
            <div class="form-div">
              <div class="p-3 h3 header">Forgot Password</div>
              <form action="GenerateOtpServlet" method="post">
                <div class="form-group">
                  <label for="email">Email :</label>
                  <input
                    type="email"
                    class="form-control"
                    id="email"
                    name="email"
                    required
                  />
                </div>
                <div class="form-group pt-2">
                  <button type="submit" class="btn btn-primary getOTPBtn">
                    Get OTP
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>

    <script src="js/jquery-3.7.0.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
