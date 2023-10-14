package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DatabaseConnection;
import dto.User;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static boolean isAuthenticated(HttpServletRequest request, HttpServletResponse response,
			String emailOrUsername, String password) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM users WHERE (user_email = ? OR username = ?) AND user_password = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, emailOrUsername);
			statement.setString(2, emailOrUsername);
			statement.setString(3, password);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {

				int user_id = resultSet.getInt("user_id");
				String user_uuid = resultSet.getString("user_uuid");
				String firstName = resultSet.getString("user_first_name");
				String lastName = resultSet.getString("user_last_name");
				Date birthDate = resultSet.getDate("user_birth_date");
				String userName = resultSet.getString("username");
				String email = resultSet.getString("user_email");
				String knownLanguages = resultSet.getString("user_known_languages");
				String gender = resultSet.getString("user_gender");
				String user_role = resultSet.getString("user_role");

				Blob profilePicBlob = resultSet.getBlob("user_profile_pic");
				byte[] profile_pic = profilePicBlob.getBytes(1, (int) profilePicBlob.length());

				User user = new User(user_id, user_uuid, firstName, lastName, birthDate, userName, email,
						knownLanguages, gender, profile_pic, user_role);

				if (user_role.equals("ADMIN"))
					request.getSession().setAttribute("isADMIN", true);
				else
					request.getSession().setAttribute("isADMIN", false);
				
				request.getSession().setAttribute("user_id", resultSet.getInt("user_id"));
				request.getSession().setAttribute("isLoggedIn", true);
				request.getSession().setAttribute("userData", user);
				request.getSession().setAttribute("userAddresses", getAddresses(user_uuid));
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static List<Address> getAddresses(String user_uuid) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM addresses WHERE user_uuid = ?";
		List<Address> addresses = new ArrayList<Address>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user_uuid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Country country = getCountry(resultSet.getInt("address_country"));
				State state = getState(resultSet.getInt("address_state"));
				City city = getCity(resultSet.getInt("address_city"));
				Address address = new Address(resultSet.getInt("address_id"),resultSet.getString("address_line_1"),
						resultSet.getString("address_line_2"), city, state, country,
						String.valueOf(resultSet.getInt("address_pincode")));
				addresses.add(address);
			}
			return addresses;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Country getCountry(int id) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT id, name FROM countries WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				Country country = new Country(resultSet.getInt("id"), resultSet.getString("name"));
				return country;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static State getState(int id) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT id, name, country_id FROM states WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				State state = new State(resultSet.getInt("id"), resultSet.getString("name"),
						resultSet.getInt("country_id"));
				return state;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static City getCity(int id) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT id, name, state_id FROM cities WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				City city = new City(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("state_id"));
				return city;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String emailOrUsername = request.getParameter("emailOrUsername");
		String password = request.getParameter("password");

		if (isAuthenticated(request, response, emailOrUsername, password)) {
			response.sendRedirect("home.jsp");
		} else {
			out.println("<script src='js/loginFail.js'></script>");
		}
	}
}
