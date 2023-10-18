package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.UserDAO;
import dto.User;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (request.getSession().getAttribute("isADMIN") != null
				&& request.getSession().getAttribute("isADMIN").equals(true)) {
			User user = (User) request.getSession().getAttribute("userData");
			List<User> users = UserDAO.getUsers(user.getId());
			if (!(users.isEmpty())) {
				out.print(new Gson().toJson(users));
			} else {
				response.sendRedirect("home.jsp");
			}
		} else if ((request.getSession().getAttribute("isADMIN") != null
				&& request.getSession().getAttribute("isADMIN").equals(false))
				&& (request.getSession().getAttribute("isLoggedIn") != null
						&& request.getSession().getAttribute("isLoggedIn").equals(true))) {
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}
	}
}
