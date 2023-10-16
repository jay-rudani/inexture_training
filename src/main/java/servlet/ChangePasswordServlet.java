package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DatabaseConnection;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int updatePassword(String email, String password) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "UPDATE users SET user_password = ? where user_email = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, password);
			statement.setString(2, email);
			int row = statement.executeUpdate();
			return row;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = (String) request.getSession().getAttribute("emailForForgot");
		String password = request.getParameter("password");
		if(updatePassword(email, password)==1) {
			request.getSession().removeAttribute("generatedOTP");
			request.getSession().removeAttribute("emailForForgot");
			out.println("<script src='js/passwordUpdatedAlert.js'></script>");
		}else {
			request.getSession().removeAttribute("generatedOTP");
			request.getSession().removeAttribute("emailForForgot");
			out.println("<script src='js/passwordUpdationFail.js'></script>");
		}
	}

}
