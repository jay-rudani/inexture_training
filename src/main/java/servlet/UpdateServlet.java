package servlet;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
import dto.User;
import utility.Address;
import utility.City;
import utility.Country;
import utility.State;

@WebServlet("/UpdateServlet")
@MultipartConfig(maxFileSize = 16177215)
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void updateRecord(int userId, String uuid, User user, InputStream profile_picture,
			List<Address> addresses, List<Address> savedAddresses) {

		Connection connection = DatabaseConnection.getConnection();
		String updateQuery = "UPDATE users SET " + "user_first_name = ?, " + "user_last_name = ?, "
				+ "user_birth_date = ?, " + "username = ?, " + "user_email = ?, " + "user_profile_pic = ?, "
				+ "user_known_languages = ?, " + "user_gender = ? " + "WHERE user_id = ? AND user_uuid = ?";
		String queryForAddress = "INSERT INTO addresses(address_line_1, address_line_2, address_city, address_state, address_country, address_pincode, user_uuid) "
				+ "values(?,?,?,?,?,?,?)";
		String queryForSavedAddress = "UPDATE addresses SET " + "address_line_1 = ?, " + "address_line_2 = ?, "
				+ "address_city = ?, " + "address_state = ?, " + "address_country = ?, " + "address_pincode = ? "
				+ "WHERE user_uuid = ? AND address_id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(updateQuery);
			PreparedStatement statementForAddress = connection.prepareStatement(queryForAddress);
			PreparedStatement statementForSavedAddress = connection.prepareStatement(queryForSavedAddress);
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setDate(3, (Date) user.getBirthDate());
			statement.setString(4, user.getUserName());
			statement.setString(5, user.getEmail());
			statement.setBlob(6, profile_picture);
			statement.setString(7, user.getKnownLanguages());
			statement.setString(8, user.getGender());

			statement.setInt(9, userId);
			statement.setString(10, uuid);

			for (Address address : addresses) {
				statementForAddress.setString(1, address.getAddressLine1());
				statementForAddress.setString(2, address.getAddressLine2());
				statementForAddress.setInt(3, address.getCity().getId());
				statementForAddress.setInt(4, address.getState().getId());
				statementForAddress.setInt(5, address.getCountry().getId());
				statementForAddress.setInt(6, Integer.parseInt(address.getPincode()));
				statementForAddress.setString(7, uuid);
				statementForAddress.addBatch();
			}

			for (Address savedAddress : savedAddresses) {
				statementForSavedAddress.setString(1, savedAddress.getAddressLine1());
				statementForSavedAddress.setString(2, savedAddress.getAddressLine2());
				statementForSavedAddress.setInt(3, savedAddress.getCity().getId());
				statementForSavedAddress.setInt(4, savedAddress.getState().getId());
				statementForSavedAddress.setInt(5, savedAddress.getCountry().getId());
				statementForSavedAddress.setInt(6, Integer.parseInt(savedAddress.getPincode()));
				statementForSavedAddress.setString(7, uuid);
				statementForSavedAddress.setInt(8, savedAddress.getId());
				statementForSavedAddress.addBatch();
			}

			int row = statement.executeUpdate();
			int[] rows1 = statementForAddress.executeBatch();
			int[] rows2 = statementForSavedAddress.executeBatch();

			if (row > 0 && rows1.length > 0 && rows2.length > 0) {
				System.out.println("UPDATED");
			} else {
				System.out.println("ERROR");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
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

	public static void deleteSavedAddress(List<String> savedAddressId, String uuid) {

		Connection connection = DatabaseConnection.getConnection();
		String idList = String.join("','", savedAddressId.stream().map(String::valueOf).toArray(String[]::new));
		String tempSql = "delete from addresses where user_uuid = ? and address_id not in ('" + idList + "')";

		try {
			PreparedStatement statement = connection.prepareStatement(tempSql);
			statement.setString(1, uuid);
			statement.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		User user = (User) request.getSession().getAttribute("userData");
		User updatedUser = new User();
		int userId = user.getId();
		String userUUID = user.getUser_uuid();
		InputStream inputStream = null;

		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String birth_date = request.getParameter("birthdate");
		String gender = request.getParameter("gender");
		String[] languages = request.getParameterValues("languages");
		Part filePart = request.getPart("profile_picture");
		String base64ImageData = request.getParameter("profile_pic_data").substring("data:image;base64,".length());

		if (filePart != null)
			inputStream = filePart.getInputStream();

		if (filePart.getSize() > 0) {
			if (filePart != null)
				inputStream = filePart.getInputStream();
		} else {
			byte[] imageData = Base64.getDecoder().decode(base64ImageData);
			inputStream = new ByteArrayInputStream(imageData);
		}

		updatedUser.setFirstName(first_name);
		updatedUser.setLastName(last_name);
		updatedUser.setEmail(email);
		updatedUser.setUserName(username);
		updatedUser.setBirthDate(Date.valueOf(birth_date));
		updatedUser.setGender(gender);

		if (languages != null) {
			StringBuilder selectedValues = new StringBuilder();
			for (String language : languages) {
				selectedValues.append(language).append(", ");
			}
			selectedValues.setLength(selectedValues.length() - 2);
			updatedUser.setKnownLanguages(selectedValues.toString());
		}

		List<String> addressLine1 = getAddressFields("items\\[\\d+\\]\\[addressLine1\\]", request, response);
		List<String> addressLine2 = getAddressFields("items\\[\\d+\\]\\[addressLine2\\]", request, response);
		List<String> cities = getAddressFields("items\\[\\d+\\]\\[city\\]", request, response);
		List<String> states = getAddressFields("items\\[\\d+\\]\\[state\\]", request, response);
		List<String> countries = getAddressFields("items\\[\\d+\\]\\[country\\]", request, response);
		List<String> pincodes = getAddressFields("items\\[\\d+\\]\\[pincode\\]", request, response);
		List<Address> addresses = new ArrayList<>();

		if (!pincodes.isEmpty()) {
			for (int i = 0; i < pincodes.size(); i++) {
				Country country = new Country(Integer.parseInt(countries.get(i)));
				State state = new State(Integer.parseInt(states.get(i)), country.getId());
				City city = new City(Integer.parseInt(cities.get(i)), state.getId());
				Address address = new Address(addressLine1.get(i), addressLine2.get(i), city, state, country,
						pincodes.get(i));
				addresses.add(address);
			}
		}

		List<String> savedAddressId = getAddressFields("savedAddressId_\\d+", request, response);
		List<String> savedAddressLine1 = getAddressFields("savedAddressLine1_\\d+", request, response);
		List<String> savedAddressLine2 = getAddressFields("savedAddressLine2_\\d+", request, response);
		List<String> savedCities = getAddressFields("savedCity_\\d+", request, response);
		List<String> savedStates = getAddressFields("savedState_\\d+", request, response);
		List<String> savedCountries = getAddressFields("savedCountry_\\d+", request, response);
		List<String> savedPincodes = getAddressFields("savedPincode_\\d+", request, response);
		List<Address> savedAddresses = new ArrayList<>();

		if (!savedPincodes.isEmpty()) {
			for (int i = 0; i < savedPincodes.size(); i++) {
				Country country = new Country(Integer.parseInt(savedCountries.get(i)));
				State state = new State(Integer.parseInt(savedStates.get(i)), country.getId());
				City city = new City(Integer.parseInt(savedCities.get(i)), state.getId());
				Address address = new Address(Integer.parseInt(savedAddressId.get(i)), savedAddressLine1.get(i),
						savedAddressLine2.get(i), city, state, country, savedPincodes.get(i));
				savedAddresses.add(address);
			}
		}

		deleteSavedAddress(savedAddressId, userUUID);
		updateRecord(userId, userUUID, updatedUser, inputStream, addresses, savedAddresses);

	}
}
