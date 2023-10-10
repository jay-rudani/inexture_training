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
import utility.Country;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<Country> getCountries() {
		Connection connection = DatabaseConnection.getConnection();
		List<Country> countries = new ArrayList<Country>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id, name FROM countries");
			while (rs.next()) {
				Country country = new Country(rs.getInt("id"), rs.getString("name"));
				countries.add(country);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return countries;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		List<Country> countries = getCountries();
		PrintWriter out = response.getWriter();
		out.print(new Gson().toJson(countries));
		out.flush();
	}
}
