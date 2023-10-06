package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connection.DatabaseConnection;
import utility.Address;
import utility.UUIDGenerator;

@WebServlet("/RegisterServlet")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static int addRecord(String uuid, String firstName, String lastName, String email, String username,
			String password, Date birth_date, String gender, String[] languages, InputStream profilepic,
			List<Address> addresses) {

		// database connection
		Connection connection = DatabaseConnection.getConnection();

		if (isAccountExistByEmail(connection, email)) {
			return 0;

		} else if (isAccountExistByUsername(connection, username)) {
			return 0;

		} else if (isAccountExistByUUID(connection, uuid)) {
			return 0;

		} else {

			int row = 0;
			String query = "INSERT INTO users(user_uuid, user_first_name, user_last_name, user_birth_date, "
					+ "username, user_email, user_password, user_role, user_profile_pic, "
					+ "user_known_languages, user_gender) values(?,?,?,?,?,?,?,?,?,?,?)";
			String queryForAddress = "INSERT INTO addresses(address_line_1, address_line_2, address_city, address_state, address_country, address_pincode, user_uuid) "
					+ "values(?,?,?,?,?,?,?)";

			try {
				PreparedStatement statement = connection.prepareStatement(query);
				PreparedStatement statementForAddress = connection.prepareStatement(queryForAddress);
				statement.setString(1, uuid);
				statement.setString(2, firstName);
				statement.setString(3, lastName);
				statement.setDate(4, (Date) birth_date);
				statement.setString(5, username);
				statement.setString(6, email);
				statement.setString(7, password);
				statement.setString(8, "USER");

				if (profilepic != null) {
					statement.setBlob(9, profilepic);
				}

				if (languages != null) {
					StringBuilder selectedValues = new StringBuilder();
					for (String language : languages) {
						selectedValues.append(language).append(", ");
					}
					selectedValues.setLength(selectedValues.length() - 2);
					statement.setString(10, selectedValues.toString());
				}

				statement.setString(11, gender);

				for (Address address : addresses) {
					statementForAddress.setString(1, address.getAddressLine1());
					statementForAddress.setString(2, address.getAddressLine2());
					statementForAddress.setString(3, address.getCity());
					statementForAddress.setString(4, address.getState());
					statementForAddress.setString(5, address.getCountry());
					statementForAddress.setInt(6, Integer.parseInt(address.getPincode()));
					statementForAddress.setString(7, uuid);
					statementForAddress.addBatch();
				}

				row = statement.executeUpdate();
				statementForAddress.executeBatch();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			return row;
		}
	}

	public static boolean isAccountExistByEmail(Connection connection, String email) {
		String queryAccountExistByEmail = "SELECT user_email FROM users WHERE user_email = ?";
		try {
			PreparedStatement statementForEmail = connection.prepareStatement(queryAccountExistByEmail);
			statementForEmail.setString(1, email);
			ResultSet rs = statementForEmail.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred : while checking account existance by Email");
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isAccountExistByUsername(Connection connection, String username) {
		String queryAccountExistByUsername = "SELECT username FROM users WHERE username = ?";
		try {
			PreparedStatement statementForUsername = connection.prepareStatement(queryAccountExistByUsername);
			statementForUsername.setString(1, username);
			ResultSet rs = statementForUsername.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred : while checking account existance by Username");
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isAccountExistByUUID(Connection connection, String uuid) {
		String queryAccountExistByUUID = "SELECT user_uuid FROM users WHERE user_uuid = ?";
		try {
			PreparedStatement statementForUUID = connection.prepareStatement(queryAccountExistByUUID);
			statementForUUID.setString(1, uuid);
			ResultSet rs = statementForUUID.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Exception occurred : while checking account existance by UUID");
			e.printStackTrace();
		}
		return false;
	}

	public static List<String> getAddressFields(String regex, HttpServletRequest request,
			HttpServletResponse response) {
		Pattern pattern = Pattern.compile(regex);
		List<String> paramValues = new ArrayList<>();

		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			Matcher matcher = pattern.matcher(paramName);
			if (matcher.matches()) {
				for (String item : request.getParameterValues(paramName)) {
					paramValues.add(item);
				}
			}
		}
		return paramValues;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// getting parameters from the request
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String birth_date = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("languages");
		String uuid = UUIDGenerator.generateUUID();

		List<String> addressLine1 = getAddressFields("items\\[\\d+\\]\\[addressLine1\\]", request, response);
		List<String> addressLine2 = getAddressFields("items\\[\\d+\\]\\[addressLine2\\]", request, response);
		List<String> cities = getAddressFields("items\\[\\d+\\]\\[city\\]", request, response);
		List<String> states = getAddressFields("items\\[\\d+\\]\\[state\\]", request, response);
		List<String> countries = getAddressFields("items\\[\\d+\\]\\[country\\]", request, response);
		List<String> pincodes = getAddressFields("items\\[\\d+\\]\\[pincode\\]", request, response);
		List<Address> addresses = new ArrayList<>();
		for (int i = 0; i < pincodes.size(); i++) {
			Address address = new Address(addressLine1.get(i), addressLine2.get(i), cities.get(i), states.get(i),
					countries.get(i), pincodes.get(i));
			addresses.add(address);
		}

		InputStream inputStream = null;
		Part filePart = request.getPart("profilepic");
		if (filePart != null)
			inputStream = filePart.getInputStream();

		int row = addRecord(uuid, first_name, last_name, email, username, password, java.sql.Date.valueOf(birth_date),
				gender, languages, inputStream, addresses);

		if (row > 0)
			out.println("<script>alert('Registered!');</script>");
		else
			out.println("<script>alert('Email, Username, UUID already existed');</script>");
	}
}
