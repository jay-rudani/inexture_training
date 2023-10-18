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

import com.google.gson.Gson;

import connection.DatabaseConnection;
import dto.User;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;

@WebServlet("/ViewUsersServlet")
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static List<User> getUsers(int id) {
		Connection connection = DatabaseConnection.getConnection();
		List<User> users = new ArrayList<User>();
		List<Address> addresses = new ArrayList<Address>();
		String query = "SELECT * FROM users WHERE user_id <> ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				int user_id = rs.getInt("user_id");
				String user_uuid = rs.getString("user_uuid");
				String firstName = rs.getString("user_first_name");
				String lastName = rs.getString("user_last_name");
				Date birthDate = rs.getDate("user_birth_date");
				String userName = rs.getString("username");
				String email = rs.getString("user_email");
				String knownLanguages = rs.getString("user_known_languages");
				String gender = rs.getString("user_gender");
				String user_role = rs.getString("user_role");

				Blob profilePicBlob = rs.getBlob("user_profile_pic");
				byte[] profile_pic = profilePicBlob.getBytes(1, (int) profilePicBlob.length());

				addresses = getAddresses(user_uuid);
				User user = new User(user_id, user_uuid, firstName, lastName, birthDate, userName, email,
						knownLanguages, gender, profile_pic, user_role, addresses);
				user.setProfile_pic_string(profile_pic);
				users.add(user);
			}
			return users;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static List<Address> getAddresses(String uuid) {
		Connection connection = DatabaseConnection.getConnection();
		List<Address> addresses = new ArrayList<Address>();
		String query = "SELECT * FROM addresses WHERE user_uuid = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, uuid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Address address = new Address(rs.getInt("address_id"), rs.getString("address_line_1"),
						rs.getString("address_line_2"), getCity(rs.getInt("address_city")),
						getState(rs.getInt("address_state")), getCountry(rs.getInt("address_country")),
						String.valueOf(rs.getInt("address_pincode")));
				addresses.add(address);
			}
			return addresses;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static Country getCountry(int countryId) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM countries WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, countryId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				Country country = new Country(rs.getInt("id"), rs.getString("name"));
				return country;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static State getState(int stateId) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM states WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, stateId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				State state = new State(rs.getInt("id"), rs.getString("name"), rs.getInt("country_id"));
				return state;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static City getCity(int cityId) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM cities WHERE id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, cityId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				City city = new City(rs.getInt("id"), rs.getString("name"), rs.getInt("state_id"));
				return city;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (request.getSession().getAttribute("isADMIN") != null
				&& request.getSession().getAttribute("isADMIN").equals(true)) {
			User user = (User) request.getSession().getAttribute("userData");
			List<User> users = getUsers(user.getId());
			if (!(users.isEmpty())) {
//				request.getSession().setAttribute("allUsersData", users);
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
