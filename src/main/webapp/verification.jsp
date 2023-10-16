<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  	<title>Forgot Password - Verify OTP and Set Password</title>
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
              <form action="ChangePasswordServlet" method="post" onsubmit="return (checkOtp() && verifyPassword())">
                <div class="form-group">
                  <label for="email">Enter OTP :</label>
                  <input
                    type="number"
                    class="form-control"
                    id="otp"
                    name="otp"
                    required
                  />
                  <small id="messageForOtp" class="text-danger"></small>
                </div>
                <div class="form-group">
                  <label for="email">Enter password :</label>
                  <input
                    type="password"
                    class="form-control"
                    id="password"
                    name="password"
                    required
                  />
                  <small id="passwordMessage"></small>
                </div>
                <div class="form-group">
                  <label for="email">Re-enter password :</label>
                  <input
                    type="text"
                    class="form-control"
                    id="repassword"
                    name="repassword"
                    required
                  />
                <small id="messageForPasswordMatch" class="text-danger"></small>
                </div>
                <div class="form-group pt-2">
                  <button type="submit" class="btn btn-primary getOTPBtn">
                    Forgot
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
    <script src="js/otpPasswordVerification.js"></script>
    <script>
    	function checkOtp(){
    		if($("#otp").val() == <%=request.getSession().getAttribute("generatedOTP")%>){
    			document.getElementById("messageForOtp").innerHTML="";
    			return true;
    		}else{
    			document.getElementById("messageForOtp").innerHTML="OTP didn't match!";
    			return false;
    		}
    	}
    </script>
  </body>
</html>
