package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String emailOrUsername = request.getParameter("emailOrUsername");
		String password = request.getParameter("password");

		// calling isAuthenticated of UserDAO
		if (UserDAO.isAuthenticated(request, response, emailOrUsername, password)) {
			response.sendRedirect("home.jsp");
		} else {
			out.println("<script src='js/loginFail.js'></script>");
		}
	}
}
