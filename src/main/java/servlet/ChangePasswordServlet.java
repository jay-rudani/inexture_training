package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String email = (String) request.getSession().getAttribute("emailForForgot");
		String password = request.getParameter("password");

		// calling updatePassword() of UserDAO to update password
		if (UserDAO.updatePassword(email, password) == 1) {
			request.getSession().removeAttribute("generatedOTP");
			request.getSession().removeAttribute("emailForForgot");
			out.println("<script src='js/passwordUpdatedAlert.js'></script>");
		} else {
			request.getSession().removeAttribute("generatedOTP");
			request.getSession().removeAttribute("emailForForgot");
			out.println("<script src='js/passwordUpdationFail.js'></script>");
		}
	}

}
