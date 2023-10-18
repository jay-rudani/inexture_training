package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.DatabaseConnection;
import utility.Country;

public class CountryDAO {

	static Connection connection = DatabaseConnection.getConnection();

	// getCountry by id
	public static Country getCountry(int id) {
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
}
