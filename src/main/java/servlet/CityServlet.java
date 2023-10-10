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
import utility.City;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<City> getCities(String stateId) {
		Connection connection = DatabaseConnection.getConnection();
		List<City> cities = new ArrayList<City>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement
					.executeQuery("SELECT id, name, state_id FROM cities WHERE state_id = '" + stateId + "'");
			while (rs.next()) {
				City city = new City(rs.getInt("id"), rs.getString("name"), rs.getInt("state_id"));
				cities.add(city);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return cities;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String stateId = request.getParameter("stateId");
		List<City> cities = getCities(stateId);
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(cities));
		out.flush();
	}

}
