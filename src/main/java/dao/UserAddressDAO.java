package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import connection.DatabaseConnection;
import dto.User;
import utility.Address;

public class UserAddressDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// method to add record in database for registration
	public static int addRecord(String uuid, String firstName, String lastName, String email, String username,
			String password, Date birth_date, String gender, String[] languages, InputStream profilepic,
			List<Address> addresses) {

		if (UserDAO.isAccountExistByEmail(email)) {
			return 0;

		} else if (UserDAO.isAccountExistByUsername(username)) {
			return 0;

		} else if (UserDAO.isAccountExistByUUID(uuid)) {
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
					statementForAddress.setInt(3, address.getCity().getId());
					statementForAddress.setInt(4, address.getState().getId());
					statementForAddress.setInt(5, address.getCountry().getId());
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

	// method for update record
	public static int updateRecord(int userId, String uuid, User user, InputStream profile_picture,
			List<Address> addresses) {
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
				if (address.getId() == 0) {
					statementForAddress.setString(1, address.getAddressLine1());
					statementForAddress.setString(2, address.getAddressLine2());
					statementForAddress.setInt(3, address.getCity().getId());
					statementForAddress.setInt(4, address.getState().getId());
					statementForAddress.setInt(5, address.getCountry().getId());
					statementForAddress.setInt(6, Integer.parseInt(address.getPincode()));
					statementForAddress.setString(7, uuid);
					statementForAddress.addBatch();
				} else {
					statementForSavedAddress.setString(1, address.getAddressLine1());
					statementForSavedAddress.setString(2, address.getAddressLine2());
					statementForSavedAddress.setInt(3, address.getCity().getId());
					statementForSavedAddress.setInt(4, address.getState().getId());
					statementForSavedAddress.setInt(5, address.getCountry().getId());
					statementForSavedAddress.setInt(6, Integer.parseInt(address.getPincode()));
					statementForSavedAddress.setString(7, uuid);
					statementForSavedAddress.setInt(8, address.getId());
					statementForSavedAddress.addBatch();
				}
			}

			int row = statement.executeUpdate();
			int[] rows1 = statementForAddress.executeBatch();
			int[] rows2 = statementForSavedAddress.executeBatch();

			if (row > 0 || rows1.length > 0 || rows2.length > 0) {
				return 1;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return 0;
	}
}
