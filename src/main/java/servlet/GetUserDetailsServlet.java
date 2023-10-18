package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/GetUserDetailsServlet")
public class GetUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		
		// getting user details
		if (UserDAO.getUserDetails(user_id) != null) {
			request.getSession().setAttribute("manageUserData", UserDAO.getUserDetails(user_id));
			response.sendRedirect("register.jsp");
		}
	}
}
