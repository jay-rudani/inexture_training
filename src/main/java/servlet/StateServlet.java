package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import connection.DatabaseConnection;
import utility.State;

@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<State> getStates(String countryId) {
		Connection connection = DatabaseConnection.getConnection();
		List<State> states = new ArrayList<State>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT id, name, country_id FROM states WHERE country_id = '" + countryId + "'");
			while (rs.next()) {
				State state = new State(rs.getInt("id"), rs.getString("name"), rs.getInt("country_id"));
				states.add(state);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return states;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String countryId = request.getParameter("countryId");
		List<State> states = getStates(countryId);
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(states));
		out.flush();
	}
}
