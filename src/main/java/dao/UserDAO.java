package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.DatabaseConnection;
import dto.User;
import utility.Address;

public class UserDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// method to check email associated with current account is already exist or not
	public static boolean isAccountExistByEmail(String email) {
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

	// method to check uuid associated with current account is already exist or not
	public static boolean isAccountExistByUUID(String uuid) {
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

	// method to check username associated with current account is already exist or
	// not
	public static boolean isAccountExistByUsername(String username) {
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

	// get user details by user id
	public static User getUserDetails(int user_id) {
		String query = "SELECT * FROM users WHERE user_id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, user_id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {

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
						knownLanguages, gender, profile_pic, user_role, AddressDAO.getAddresses(user_uuid));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	// method for DELETE USER
	public static int deleteUser(int id) {
		String query = "DELETE FROM users where user_id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			int row = statement.executeUpdate();
			return row;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return 0;
	}

	// method for UPDATE PASSWORD
	public static int updatePassword(String email, String password) {
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

	// method to find all users for admin
	public static List<User> getUsers(int id) {
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

				addresses = AddressDAO.getAddresses(user_uuid);
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

	// method to Authenticated user
	public static boolean isAuthenticated(HttpServletRequest request, HttpServletResponse response,
			String emailOrUsername, String password) {
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
						knownLanguages, gender, profile_pic, user_role, AddressDAO.getAddresses(user_uuid));

				if (user_role.equals("ADMIN"))
					request.getSession().setAttribute("isADMIN", true);
				else
					request.getSession().setAttribute("isADMIN", false);

				request.getSession().setAttribute("user_id", resultSet.getInt("user_id"));
				request.getSession().setAttribute("isLoggedIn", true);
				request.getSession().setAttribute("userData", user);
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
