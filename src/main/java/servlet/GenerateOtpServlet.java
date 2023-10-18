package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import utility.EmailUtil;

@WebServlet("/GenerateOtpServlet")
public class GenerateOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		if (UserDAO.isAccountExistByEmail(email)) {
			final String fromEmail = "user.managent.system@gmail.com"; // requires valid gmail id
			final String password = "zemq rkpk qwtk yzsf"; // correct password for gmail id
			final String toEmail = email; // can be any email id

			System.out.println("TLSEmail Start");
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
			props.put("mail.smtp.port", "587"); // TLS Port
			props.put("mail.smtp.auth", "true"); // enable authentication
			props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

			// create Authenticator object to pass in Session.getInstance argument
			Authenticator auth = new Authenticator() {
				// override the getPasswordAuthentication method
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};

			Random random = new Random();
			int otp = random.nextInt(9999 - 1000 + 1) + 1000;
			Session session = Session.getInstance(props, auth);
			try {
				EmailUtil.sendEmail(session, toEmail, "Forgot Password - Verification Code",
						"Here is your OTP : " + otp);
				request.getSession().setAttribute("generatedOTP", otp);
				request.getSession().setAttribute("emailForForgot", email);
				response.sendRedirect("verification.jsp");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}

		} else {
			out.println("<script src='js/ForgotPassEmailNotFound.js'></script>");
		}
	}
}
